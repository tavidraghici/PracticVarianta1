import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class WeineRepo {

    List<Wein> weine = new ArrayList<>();

    public WeineRepo() {
        ReadWeine();
    }

    private void ReadWeine(){
        try {
            File myObj = new File("C:/Users/Tavi/Desktop/PracticVarianta1/src/weine.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(",");
                Wein wein = new Wein(attributes[0],
                        attributes[1],
                        Float.parseFloat(attributes[2]),
                        Integer.parseInt(attributes[3]),
                        LocalDate.parse(attributes[4]));
                weine.add(wein);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading from file.");
            e.printStackTrace();
        }
    }

    public double Gesamtkosten(){
        List<Float> preisPerWein = new ArrayList<>();
        for(Wein wein : weine){
            preisPerWein.add(wein.getMenge()*wein.getPrice());
        }
        return preisPerWein.stream().mapToDouble(a -> a).sum();
    }

    public void WriteInFiles(){
        String[] kategories = {"ROT", "ROSE", "WEISS"};
        for(String kat : kategories)
            try {
                String filename = kat.toLowerCase() + ".txt";
                FileWriter myWriter = new FileWriter(filename);
                for(Wein wein : SortAfterHerstellungsdatum(FilterAfterType(kat))){
                    myWriter.write(wein.toString());
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }

    private List<Wein> SortAfterHerstellungsdatum(List<Wein> weine){
        weine.sort(Comparator.comparing(Wein::getHerstellungsdatum).reversed());
        return weine;
    }

    private List<Wein> FilterAfterType(String type){
        return weine.stream().filter((n)->n.getKategory().equals(type)).collect(Collectors.toList());
    }
}
