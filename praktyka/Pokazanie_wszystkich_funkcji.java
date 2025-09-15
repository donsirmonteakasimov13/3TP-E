// Klasa reprezentująca osobę
public class Osoba {

    // ----------------------
    // Pola prywatne (enkapsulacja)
    // ----------------------
    private String imie;
    private String nazwisko;
    private int wiek;

    // Pole statyczne - wspólne dla wszystkich obiektów klasy Osoba
    private static int licznikOsob = 0;

    // ----------------------
    // Konstruktor - wywoływany przy tworzeniu obiektu
    // ----------------------
    public Osoba(String imie, String nazwisko, int wiek) {
        this.imie = imie;             // this odnosi się do bieżącego obiektu
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        licznikOsob++;                 // przy każdym nowym obiekcie zwiększamy licznik
    }

    // ----------------------
    // Gettery i Settery (enkapsulacja)
    // ----------------------
    public int getWiek() {
        return wiek;                   // odczyt pola prywatnego
    }

    public void setWiek(int wiek) {
        if (wiek < 0) {                // walidacja wartości
            throw new IllegalArgumentException("Wiek nie może być ujemny");
        }
        this.wiek = wiek;              // ustawienie pola
    }

    // ----------------------
    // Metoda obiektu typu void - wypisuje dane osoby
    // ----------------------
    public void przedstawSie() {
        System.out.println("Cześć, mam na imię " + imie + " " + nazwisko + ", mam " + wiek + " lat.");
    }

    // ----------------------
    // Metoda statyczna - dostępna bez tworzenia obiektu
    // ----------------------
    public static int getLicznikOsob() {
        return licznikOsob;            // zwraca liczbę wszystkich utworzonych obiektów
    }

    // ----------------------
    // Przeciążanie metod - różne parametry
    // ----------------------
    public void log(String msg) {
        System.out.println(msg);       // wypisuje komunikat
    }

    public void log(String msg, int level) {
        System.out.println("[" + level + "] " + msg); // wypisuje komunikat z poziomem
    }

    // ----------------------
    // Typy prymitywne vs obiekty
    // ----------------------
    public void modifyPrimitive(int x) {
        x = 99;                        // zmiana lokalnej kopii, nie wpływa na oryginał
    }

    public void modifyObject(StringBuilder sb) {
        sb.append(" dopisane");        // zmiana stanu obiektu, widoczna na zewnątrz
    }

    // ----------------------
    // Metoda zwracająca wartość
    // ----------------------
    public int suma(int a, int b) {
        return a + b;                  // zwraca wynik dodawania
    }

    // ----------------------
    // Metoda void z parametrem
    // ----------------------
    public void wypiszPowitanie(String imie) {
        System.out.println("Cześć, " + imie + "!"); // efekt wypisania tekstu
    }
}

// ----------------------
// Klasa reprezentująca konto bankowe
// ----------------------
class Konto {

    private String numer;      // pole prywatne
    private double stan;       // pole prywatne

    // ----------------------
    // Konstruktor z użyciem this
    // ----------------------
    public Konto(String numer, double poczatkowyStan) {
        this.numer = numer;            // this odnosi się do bieżącego obiektu
        this.stan = poczatkowyStan;
    }

    // ----------------------
    // Metoda wpłaty z final dla parametru
    // ----------------------
    public void wplac(final double kwota) {
        if (kwota <= 0) {              // walidacja wartości
            throw new IllegalArgumentException("Kwota musi być > 0");
        }
        this.stan += kwota;            // zmiana stanu obiektu
    }

    // ----------------------
    // Getter - odczyt stanu konta
    // ----------------------
    public double getStan() {
        return stan;
    }
}

// ----------------------
// Klasa z metodą main - tworzenie obiektów i wywoływanie metod
// ----------------------
class Main {
    public static void main(String[] args) {

        // ----------------------
        // Tworzenie obiektu klasy Osoba
        // ----------------------
        Osoba osoba1 = new Osoba("Jan", "Kowalski", 30);
        osoba1.przedstawSie();           // Metoda typu void wypisuje dane osoby

        // ----------------------
        // Przeciążanie metod
        // ----------------------
        osoba1.log("Informacja");        // wywołanie metody log(String)
        osoba1.log("Błąd krytyczny", 1); // wywołanie metody log(String, int)

        // ----------------------
        // Praca z polami statycznymi
        // ----------------------
        System.out.println("Liczba osób: " + Osoba.getLicznikOsob());

        // ----------------------
        // Typy prymitywne vs obiekty
        // ----------------------
        int a = 10;
        osoba1.modifyPrimitive(a);
        System.out.println("Prymityw po metodzie: " + a); // 10 - nie zmieniło się

        StringBuilder sb = new StringBuilder("Tekst");
        osoba1.modifyObject(sb);
        System.out.println("Obiekt po metodzie: " + sb); // Tekst dopisane - zmiana widoczna

        // ----------------------
        // Tworzenie konta bankowego
        // ----------------------
        Konto konto1 = new Konto("123456", 1000);
        konto1.wplac(500);               // wpłata z walidacją
        System.out.println("Stan konta: " + konto1.getStan());
    }
}
