import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // pobieramy liczbę od użytkownika
        System.out.print("Podaj liczbę: ");
        int n = sc.nextInt();

        // pętla do wypisania tabliczki mnożenia
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }

        sc.close();
    }
}
