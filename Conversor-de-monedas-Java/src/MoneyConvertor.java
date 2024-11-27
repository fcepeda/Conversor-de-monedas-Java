import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MoneyConvertor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ConvertorAPI api = new ConvertorAPI();
        ConversionHistory history = new ConversionHistory();
        api.getDefaultMapFromApi(); // Inicializa el mapa por defecto para la API

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss");

        while (true) {
            System.out.println("""
                    **********************************
                    
                    Sea bienvenido/a al Conversor de Moneda =)
                    
                    1) Dólar ==>> Peso Chileno
                    2) Peso Chileno ==>> Dólar
                    3) Dólar ==>> Peso Argentino
                    4) Peso Argentino ==>> Dólar
                    5) Otros países
                    6) Revisar historial
                    7) Salir
                    
                    **********************************""");

            try {
                int numberElection = Integer.parseInt(input.nextLine());

                if (numberElection == 7) {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    break;
                }

                switch (numberElection) {
                    case 1 -> performConversion(input, api, history, formatter, "USD", "CLP");
                    case 2 -> performConversion(input, api, history, formatter, "CLP", "USD");
                    case 3 -> performConversion(input, api, history, formatter, "USD", "ARS");
                    case 4 -> performConversion(input, api, history, formatter, "ARS", "USD");
                    case 5 -> handleCustomConversion(input, api, history, formatter);
                    case 6 -> System.out.println(history.toString());
                    default -> System.out.println("Por favor, elija una opción válida.");
                }

                System.out.println("\n\n");
            } catch (NumberFormatException e) {
                System.out.println("No corresponde a una elección correcta: " + e.getMessage());
            }
        }
    }

    private static void performConversion(Scanner input, ConvertorAPI api, ConversionHistory history,
                                          DateTimeFormatter formatter, String fromCode, String toCode) {
        try {
            System.out.println("Ingrese el valor a convertir: ");
            double money = Double.parseDouble(input.nextLine());
            double multiplier = api.getOtherCurrency(fromCode, toCode);

            String result = String.format("El valor %.2f [%s] corresponde al valor final de >>> %.2f [%s]",
                    money, fromCode, money * multiplier, toCode);

            LocalDateTime time = LocalDateTime.now();
            history.addConversion(result + " | " + time.format(formatter));
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Error al ingresar el valor: " + e.getMessage());
        }
    }

    private static void handleCustomConversion(Scanner input, ConvertorAPI api, ConversionHistory history,
                                               DateTimeFormatter formatter) {
        try {
            System.out.println("Ingrese el código de moneda del país proveniente: ");
            String fromCode = input.nextLine().toUpperCase();
            if (!api.isCodeInAPI(fromCode)) {
                System.out.println("No se encuentra este código de moneda.");
                return;
            }

            System.out.println("Ingrese el código de moneda del país a convertir: ");
            String toCode = input.nextLine().toUpperCase();
            if (!api.isCodeInAPI(toCode)) {
                System.out.println("No se encuentra este código de moneda.");
                return;
            }

            performConversion(input, api, history, formatter, fromCode, toCode);
        } catch (Exception e) {
            System.out.println("Error en la conversión personalizada: " + e.getMessage());
        }
    }
}

