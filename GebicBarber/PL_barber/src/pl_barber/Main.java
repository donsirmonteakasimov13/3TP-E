package pl_barber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj w salonie PL_Barber!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("podaj swoje imie:");
        String imieKlienta = scanner.nextLine();
        System.out.println("podaj swoje nazwisko:");
        String nazwiskoKlienta = scanner.nextLine();

        klienci klient = new klienci(imieKlienta, nazwiskoKlienta, 1);
        klient.info();

        pracownicy[] barberzy = {
                new pracownicy("Jan", "Kowalski", 1, "Fryzjer", 50),
                new pracownicy("Zofia", "Nowicka", 2, "Fryzjerka", 55),
                new pracownicy("Marek", "Malinowski", 3, "Fryzjer", 60)
        };
        //wybieranie barbera
        int wyborBarber = 0;
        while (wyborBarber < 1 || wyborBarber > barberzy.length) {
            System.out.println("Wybierz barbera:");
            for (int i = 0; i < barberzy.length; i++) {
                System.out.println((i + 1) + ". " + barberzy[i].imie + " " + barberzy[i].nazwisko +
                        " (stawka bazowa: " + barberzy[i].getStawkaBazowa() + " zł)");
            }
            wyborBarber = scanner.nextInt();
            if (wyborBarber < 1 || wyborBarber > barberzy.length) {
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

        pracownicy wybranyBarber = barberzy[wyborBarber - 1];
        System.out.println("Wybrałeś: " + wybranyBarber.imie + " " + wybranyBarber.nazwisko);
        wybranyBarber.info();

        double suma = wybranyBarber.getStawkaBazowa();
        //wybieranie fryzury
        int wyborFryzura = 0;
        while (wyborFryzura < 1 || wyborFryzura > 3) {
            System.out.println("Wybierz fryzurę:");
            System.out.println("1. Buzz Cut (30 zł)");
            System.out.println("2. Mid Fade (45 zł)");
            System.out.println("3. Strawberry Fade (60 zł)");
            wyborFryzura = scanner.nextInt();
            if (wyborFryzura < 1 || wyborFryzura > 3) {
                System.out.println("Nieprawidłowy wybór fryzury. Spróbuj ponownie.");
            }
        }

        switch (wyborFryzura) {
            case 1:
                suma += 30;
                break;
            case 2:
                suma += 45;
                break;
            case 3:
                suma += 60;
                break;
            default:
                System.out.println("Nieprawidłowy wybór fryzury.");
                break;
        }
        //wybieranie opcji mycia
        int wyborMycie = 0;
        while (wyborMycie < 1 || wyborMycie > 3) {
            System.out.println("Wybierz opcję mycia włosów:");
            System.out.println("1. Standardowe mycie szamponem (30 zł)");
            System.out.println("2. Peeling skóry głowy (35 zł)");
            System.out.println("3. Tonik oczyszczający (40 zł)");
            wyborMycie = scanner.nextInt();
            if (wyborMycie < 1 || wyborMycie > 3) {
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

        switch (wyborMycie) {
            case 1:
                suma += 25.99;
                break;
            case 2:
                suma += 34.99;
                break;
            case 3:
                suma += 39.99;
                break;
            default:
                System.out.println("Nieprawidłowy wybór opcji mycia.");
                break;
        }

        //wybieranie dodatkowych uslug
        System.out.println("Wybierz dodatkowe usługi (wpisz numery oddzielone spacją, 0 = brak):");
        System.out.println("1. Masaż głowy (20 zł)");
        System.out.println("2. Olejek na włosy (30 zł)");
        System.out.println("3. Woskowanie brwi (25 zł)");
        System.out.println("4. Gorący ręcznik (15 zł)");
        System.out.println("0. Brak");

        scanner.nextLine();
        String linia = scanner.nextLine();
        String[] wyborDodatki = linia.split
                (" ");

        List<String> wybraneDodatki = new ArrayList<>();

        for (String w : wyborDodatki) {
            if (w.equals("1")) {
                suma += 20;
                wybraneDodatki.add("Masaż głowy");
            } else if (w.equals("2")) {
                suma += 30;
                wybraneDodatki.add("Olejek na włosy");
            } else if (w.equals("3")) {
                suma += 25;
                wybraneDodatki.add("Woskowanie brwi");
            } else if (w.equals("4")) {
                suma += 15;
                wybraneDodatki.add("Gorący ręcznik");
            } else if (w.equals("0")) {
            } else {
                System.out.println("Nieprawidłowy wybór: " + w);
            }
        }

        if (wybraneDodatki.isEmpty()) {
            System.out.println("Brak dodatkowych usług.");
        } else {
            System.out.println("Wybrano dodatkowe usługi: " + String.join(", ", wybraneDodatki));
        }
        //znizki
        int procentZnizki = promocje.obliczZnizke(suma);
        double znizkaKwota = suma * procentZnizki / 100;
        double cenaPoZnizce = suma - znizkaKwota;

        promocje promo = new promocje("Zniżka za większe zakupy", procentZnizki);
        promo.pokazPromocje();
        //rachunek
        System.out.println("--- PODSUMOWANIE ---");
        System.out.printf("Suma przed zniżką: %.2f zł\n",  suma);
        System.out.printf("Zniżka (%d%%): -%.2f zł\n", procentZnizki, znizkaKwota);
        System.out.printf("Do zapłaty: %.2f zł\n", cenaPoZnizce);

        scanner.close();
    }
}