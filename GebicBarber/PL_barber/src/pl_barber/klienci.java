package pl_barber;

public class klienci implements salon {
    String imie;
    String nazwisko;
    int id;

    public klienci(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }

    @Override
    public void info() {
        System.out.println("Klient: " + imie + " " + nazwisko + " ");
    }
}