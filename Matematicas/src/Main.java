import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de los datos
        System.out.println("Ingrese el primer número:");
        double num1 = scanner.nextDouble();
        System.out.println("Ingrese el segundo número:");
        double num2 = scanner.nextDouble();

        // Operaciones básicas
        double suma = num1 + num2;
        double resta = num1 - num2;
        double multiplicacion = num1 * num2;
        double division = num1 / num2;
        double modulo = num1 % num2;




        scanner.close();
    }

}