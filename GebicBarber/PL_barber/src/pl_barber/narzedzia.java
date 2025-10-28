package pl_barber;

public class narzedzia {
    private String nazwa;

    public narzedzia(String nazwa) {
        this.nazwa = nazwa;
    }

    public void uzyj() {
        System.out.println("Użyto narzędzia: " + nazwa);
    }
}