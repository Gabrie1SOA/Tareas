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

        // Operaciones avanzadas
        double raizCuadrada1 = Math.sqrt(num1);
        double raizCuadrada2 = Math.sqrt(num2);
        double potencia = Math.pow(num1, num2);
        double seno1 = Math.sin(Math.toRadians(num1));
        double seno2 = Math.sin(Math.toRadians(num2));
        double coseno1 = Math.cos(Math.toRadians(num1));
        double coseno2 = Math.cos(Math.toRadians(num2));
        double tangente1 = Math.tan(Math.toRadians(num1));
        double tangente2 = Math.tan(Math.toRadians(num2));
        double logaritmo1 = Math.log(num1);
        double logaritmo2 = Math.log(num2);




        scanner.close();
    }

}