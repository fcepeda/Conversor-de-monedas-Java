import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MoneyConvertor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ConvertorAPI api = new ConvertorAPI();
        api.getDefaultMapFromApi();
        ConversionHistory history = new ConversionHistory();
        LocalDateTime time = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss");

        while(true)
        {
            System.out.println("""
                    **********************************\s
                    
                    Sea bienvenido/a al Conversor de Moneda =)
                    
                    1) Dólar ==>> Peso Chileno
                    2) Peso Chileno ==>> Dólar
                    3) Dólar ==>> Peso Argentino
                    4) Peso Argentino ==>> Dólar
                    5) Otros paises
                    6) Revisar historial
                    7) Salir
                    
                    **********************************""");
            try
            {
                int numberElection = Integer.parseInt(input.nextLine());
                double money = 0;
                double multiplier = 0;
                String temporalConversion = "";
                switch (numberElection)
                {
                    case 1:
                        System.out.println("Ingrese el valor a convertir: ");
                        money = Double.parseDouble(input.nextLine());
                        multiplier = api.getOtherCurrency("USD","CLP");
                        temporalConversion = "El valor "+money+"[USD] corresponde al valor final de >>> "
                                +(money*multiplier)+"[CLP]";
                        time = LocalDateTime.now();
                        history.addConversion(temporalConversion+" "+time.format(formatter));
                        System.out.println(temporalConversion);
                        break;
                    case 2:
                        System.out.println("Ingrese el valor a convertir: ");
                        money = Double.parseDouble(input.nextLine());
                        multiplier = api.getOtherCurrency("CLP","USD");
                        temporalConversion = "El valor "+money+"[CLP] corresponde al valor final de >>> "
                                +(money*multiplier)+"[USD]";
                        time = LocalDateTime.now();
                        history.addConversion(temporalConversion+" | "+time.format(formatter));
                        System.out.println(temporalConversion);
                        break;
                    case 3:
                        System.out.println("Ingrese el valor a convertir: ");
                        money = Double.parseDouble(input.nextLine());
                        multiplier = api.getOtherCurrency("USD","ARS");
                        temporalConversion = "El valor "+money+"[USD] corresponde al valor final de >>> "
                                +(money*multiplier)+"[ARS]";
                        time = LocalDateTime.now();
                        history.addConversion(temporalConversion+" "+time.format(formatter));
                        System.out.println(temporalConversion);
                        break;
                    case 4:
                        System.out.println("Ingrese el valor a convertir: ");
                        money = Double.parseDouble(input.nextLine());
                        multiplier = api.getOtherCurrency("ARS","USD");
                        temporalConversion = "El valor "+money+"[ARS] corresponde al valor final de >>> "
                                +(money*multiplier)+"[USD]";
                        time = LocalDateTime.now();
                        history.addConversion(temporalConversion+" "+time.format(formatter));
                        System.out.println(temporalConversion);
                        break;
                    case 5:
                        System.out.println("Ingrese el código de moneda del país proveniente: ");
                        String fromCode = input.nextLine().toUpperCase();
                        if(!api.isCodeInAPI(fromCode))
                        {
                            System.out.println("No se encuentra este código de moneda");
                            break;
                        }
                        System.out.println("Ingrese el código de moneda del país a convertir: ");
                        String toCode = input.nextLine().toUpperCase();
                        if(!api.isCodeInAPI(toCode))
                        {
                            System.out.println("No se encuentra este código de moneda");
                            break;
                        }

                        System.out.println("Ingrese el valor a convertir: ");
                        money = Double.parseDouble(input.nextLine());



                        multiplier = api.getOtherCurrency(fromCode,toCode);
                        temporalConversion = "El valor "+money+"["+fromCode+"] corresponde al valor final de >>> "
                                +(money*multiplier)+"["+toCode+"]";
                        ;
                        time = LocalDateTime.now();
                        history.addConversion(temporalConversion+" "+time.format(formatter));
                        System.out.println(temporalConversion);
                        break;
                    case 6:
                        System.out.println(history.toString());
                        break;
                }
                System.out.println("\n\n");
                if(numberElection == 7)
                {
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("No corresponde a una eleccion correcta "+e.getMessage());

            }


        }

    }
}
