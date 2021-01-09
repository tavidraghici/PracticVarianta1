import java.time.LocalDate;

public class Wein {
    String name;
    String kategory;
    float price;
    int menge;
    LocalDate herstellungsdatum;

    public Wein(String name, String kategory, float price, int menge, LocalDate herstellungsdatum) {
        this.name = name;
        this.kategory = kategory;
        this.price = price;
        this.menge = menge;
        this.herstellungsdatum = herstellungsdatum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKategory() {
        return kategory;
    }

    public void setKategory(String kategory) {
        this.kategory = kategory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public LocalDate getHerstellungsdatum() {
        return herstellungsdatum;
    }

    public void setHerstellungsdatum(LocalDate herstellungsdatum) {
        this.herstellungsdatum = herstellungsdatum;
    }
}
