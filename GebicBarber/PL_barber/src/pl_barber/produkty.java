package pl_barber;

public class produkty {
    private String nazwa;
    private double cena;

    public produkty(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public void pokazProdukt() {
        System.out.println("Produkt: " + nazwa + ", cena: " + cena + " zł");
    }
}