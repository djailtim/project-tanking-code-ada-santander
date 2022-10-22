import java.util.Scanner;

public class CalculateTemperatures {


    public static Double[][] conversions( int numberOfConversions, int temperatureUnit1, int temperatureUnit2) {
        Double[] temperatures = new Double[numberOfConversions];
        Double[] convertedTemperatures = new Double[numberOfConversions];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("\nDigite a temperatura #" + (i+1) + ": ");
            Double temperature = input.nextDouble();
            temperatures[i] = temperature;

            Double newTemperature = Temperature.convert(temperature,temperatureUnit1, temperatureUnit2);
            convertedTemperatures[i] = newTemperature;
            if (temperatureUnit1 == 1) {
                Display.printMessageConversion("Celsius", newTemperature);
            } else if (temperatureUnit1 == 2) {
                Display.printMessageConversion("Fahrenheit", newTemperature);
            } else {
                Display.printMessageConversion("Kelvin", newTemperature);
            }
        }

        return new Double[][]{ temperatures, convertedTemperatures };
    }

    public static Double calculateAverage (Double[] temperatures) {
        Double sumTemperatures = 0.0;
        double average;
        for (Double temperature : temperatures) {
            sumTemperatures += temperature;
        }

        average = sumTemperatures / temperatures.length;
        return average;
    }
}
