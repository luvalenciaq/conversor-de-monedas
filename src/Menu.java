import java.util.Scanner;

public class Menu {
    private final Scanner scaner = new Scanner(System.in);
    private final ConexionApi api = new ConexionApi();

    public void mostrarMenu(){
        boolean continuar = true;

        while (continuar) {
            System.out.println("********** Bienvenido al conversor de monedas ***********");
            System.out.println("\nCódigos de las monedas");
            System.out.println("\n1. USD - Dólar estadounidense");
            System.out.println("2. EUR - Euro");
            System.out.println("3. MXN - Peso mexicano");
            System.out.println("4. COP - Peso colombiano");
            System.out.println("5. ARS - Peso argentino");
            System.out.println("6. CLP - Peso chileno");
            System.out.println("7. PEN - Sol peruano");
            System.out.println("8. BRL - Real brasileño");
            System.out.println("9. UYU - Peso uruguayo");
            System.out.println("10. PYG - Guaraní paraguayo");

            System.out.println("\nIngresa el código de la moneda base (ej: USD): ");
            String monedaBase = scaner.nextLine().toUpperCase();

            System.out.println("\nIngresa el código de la moneda a convertir (ej: COP): ");
            String monedaAConvertir = scaner.nextLine().toUpperCase();

            System.out.println("\nIngresa la cantidad a convertir:");
            double cantidad = scaner.nextDouble();
            scaner.nextLine();

            System.out.println("\nHas ingresado: ");
            System.out.println("Moneda base: " + monedaBase);
            System.out.println("Moneda a convertir: " + monedaAConvertir);
            System.out.println("Cantidad: " + cantidad);

            //aqui deberia ir la logica de la api
            RespuestaConversion respuesta = api.conectar(monedaBase, monedaAConvertir, cantidad);
            System.out.println("\nResultado:");
            System.out.println(cantidad + " " +monedaBase+ " equivalen a "+ respuesta.conversion_result() + " "+ monedaAConvertir);


            System.out.println("\n¿Desea hacer otra conversión? (s/n): ");
            String opcion = scaner.nextLine().toLowerCase();

            if (!opcion.equals("s")){
                continuar=false;
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta pronto!");
            }
        }
    }
}
