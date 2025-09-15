public class Samochod {
    String marka;
    int rokProdukcji;

    public Samochod(String marka, int rokProdukcji) {
        this.marka = marka;
        this.rokProdukcji = rokProdukcji;
    }

    public void wyswietlInformacje() {
        System.out.println("Marka: " + marka + ", Rok produkcji: " + rokProdukcji);
    }

    public static void main(String[] args) {
        Samochod mojSamochod = new Samochod("Toyota", 2015);

        mojSamochod.wyswietlInformacje();
    }
}
