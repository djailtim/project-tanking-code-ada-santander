import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        int[] dataForConversion = Display.initMenu();
        int quantity = dataForConversion[0];
        int temperatureUnit1 = dataForConversion[1];
        int temperatureUnit2 = dataForConversion[2];
        Double[][] temperatures = CalculateTemperatures.conversions(quantity,temperatureUnit1, temperatureUnit2);

        Double averageTypedTemperatures = CalculateTemperatures.calculateAverage(temperatures[0]);
        Display.printMessage("\n\nA média das temperaturas digitadas é: %.2f", averageTypedTemperatures);

        Double averageConvertedTemperatures = CalculateTemperatures.calculateAverage(temperatures[1]);
        Display.printMessage("\nA média das temperaturas convertidas é: %.2f", averageConvertedTemperatures);
    }
}