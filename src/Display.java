import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
    public static int[] initMenu () throws IOException, InterruptedException {
        int quantity;
        int temperatureUnit1;
        int temperatureUnit2;
        int[] dataForConversion = new int[3];

        Scanner input = new Scanner(System.in);

        try {
            quantity = menuQuantity();
            menuTypes("Que unidade de medida inserir os valores de temperatura?");
            temperatureUnit1 = input.nextInt();

            if (temperatureUnit1 == 0) {
                printMessage("\nObrigado por usar o conversor!");
                System.exit(0);
            }

            do {
                menuTypes("Para qual unidade de medida deseja converter os valores de temperatura?");
                temperatureUnit2 = input.nextInt();
                if (temperatureUnit1 == temperatureUnit2) {
                    printMessage("Escolha uma unidade diferente da primeira.");
                }

            }while(temperatureUnit1 == temperatureUnit2);

            dataForConversion[0] = quantity;
            dataForConversion[1] = temperatureUnit1;
            dataForConversion[2] = temperatureUnit2;

            return dataForConversion;
        } catch (NullPointerException | InputMismatchException e){
            clearDisplay();
            printMessage("\n\nVocê precisa digitar um número!\n");
            initMenu();
        }
        return new int[]{0};
    }

    public static int menuQuantity () {
        Scanner input = new Scanner(System.in);
        printMessage("==================== CONVERSOR DE TEMPERATURAS ====================");
        printMessage("Quantas valores de temperatura deseja converter?");
        return input.nextInt();
    }

    public static void menuTypes(String message) {
            printMessage("\n==================== CONVERSOR DE TEMPERATURAS ====================");
            printMessage(">> " + message + " <<");
            printMessage("1. CELSIUS");
            printMessage("2. FAHRENHEIT");
            printMessage("3. KELVIN");
            printMessage("0. Encerrar programa");
    }

    public static void clearDisplay () throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    public static void printMessageConversion (String TemperatureUnit, Double value) {
        System.out.printf("O valor desta temperatura em %s é %.2f\n", TemperatureUnit, value);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
