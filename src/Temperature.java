import java.util.InputMismatchException;

public class Temperature {
    Double value;
    int temperatureUnit1;
    int temperatureUnit2;

    public Temperature(Double value, int temperatureUnit1, int temperatureUnit2) {
        this.value = value;
        this.temperatureUnit1 = temperatureUnit1;
        this.temperatureUnit2 = temperatureUnit2;
    }

    public static Double convert (Double value, int temperatureUnit1, int temperatureUnit2) {
        switch (temperatureUnit2) {
            case 1:
                if (temperatureUnit1 == 2) {
                    return convertFahrenheitInCelsius(value);
                }else {
                    return convertKelvinInCelsius(value);
                }

            case 2:
                if (temperatureUnit1 == 1) {
                    return convertCelsiusInFahrenheit(value);
                } else {
                    return convertKelvinInFahrenheit(value);
                }

            case 3:
                if (temperatureUnit1 == 1) {
                    return convertCelsiusInKelvin(value);
                } else {
                    return convertFahrenheitInKelvin(value);
                }

            default:
                throw new InputMismatchException("Unidade de medida não existente no sistema.");
        }
    }

    private static Double convertCelsiusInFahrenheit(Double temperature) {
        final double FACTOR1 = 9.0/5.0;
        final double FACTOR2 = 32.0;
        return (temperature * FACTOR1) + FACTOR2;
    }

    private static Double convertCelsiusInKelvin(Double value) {
        final double FACTOR1 = 273.15;
        return value + FACTOR1;
    }

    private static Double convertFahrenheitInCelsius(Double temperature) {
        final double FACTOR1 = 5.0/9.0;
        final double FACTOR2 = 32.0;
        return (temperature - FACTOR2) / FACTOR1;
    }

    private static Double convertFahrenheitInKelvin(Double value) {
        final double FACTOR1 = 273.15;
        final double FACTOR2 = 5.0/9.0;
        final double FACTOR3 = 32.0;
        return (value - FACTOR3) * FACTOR2 + FACTOR1;
    }

    private static Double convertKelvinInCelsius(Double value) {
        final double FACTOR1 = 273.15;
        return value - FACTOR1;
    }

    private static Double convertKelvinInFahrenheit(Double value) {
        final double FACTOR1 = 273.15;
        final double FACTOR2 = 9.0/5.0;
        final double FACTOR3 = 32.0;
        return (value - FACTOR1) * FACTOR2 + FACTOR3;
    }
}
