package pl_barber;

public class pracownicy extends klienci {
    private String stanowisko;
    private double stawkaBazowa;

    public pracownicy(String imie, String nazwisko, int id, String stanowisko, double stawkaBazowa) {
        super(imie, nazwisko, id);
        this.stanowisko = stanowisko;
        this.stawkaBazowa = stawkaBazowa;
    }

    public double getStawkaBazowa() {
        return stawkaBazowa;
    }

    @Override
    public void info() {
        System.out.println("Barber: " + imie + " " + nazwisko  + ", stanowisko: " + stanowisko + ", stawka bazowa: " + stawkaBazowa + " zł");
    }
}