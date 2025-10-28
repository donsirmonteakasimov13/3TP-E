package pl_barber;

public class promocje {
    private String opis;
    private int procent;

    public promocje(String opis, int procent) {
        this.opis = opis;
        this.procent = procent;
    }

    public void pokazPromocje() {
        System.out.println("Promocja: " + opis + " (" + procent + "% taniej)");
    }

    public static int obliczZnizke(double suma) {
        if (suma >= 200) return 25;
        else if (suma >= 150) return 20;
        else if (suma >= 100) return 15;
        else if (suma >= 50) return 10;
        else return 0;
    }
}