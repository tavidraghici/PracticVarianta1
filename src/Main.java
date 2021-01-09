public class Main {

    public static void main(String[] args){
        WeineRepo wRep = new WeineRepo();
        wRep.WriteInFiles();
        System.out.println(wRep.Gesamtkosten());
    }
}
