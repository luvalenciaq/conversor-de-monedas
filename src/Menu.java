import java.util.Scanner;

public class Menu {
    private final Scanner scaner = new Scanner(System.in);
    private final ConexionApi api = new ConexionApi();

    public void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("********** Bienvenido al conversor de monedas ***********");
            mostrarCodigosDeMonedas();

            String monedaBase = pedirCodigoMoneda("base");
            String monedaAConvertir = pedirCodigoMoneda("a convertir");
            double cantidad = pedirCantidad();

            System.out.println("\nHas ingresado: ");
            System.out.println("Moneda base: " + monedaBase);
            System.out.println("Moneda a convertir: " + monedaAConvertir);
            System.out.println("Cantidad: " + cantidad);

            try {
                RespuestaConversion respuesta = api.conectar(monedaBase, monedaAConvertir, cantidad);
                System.out.println("\nResultado:");
                System.out.println(cantidad + " " + monedaBase + " equivalen a " + respuesta.conversion_result() + " " + monedaAConvertir);
            } catch (RuntimeException e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }

            System.out.println("\n¿Desea hacer otra conversión? (s/n): ");
            String opcion = scaner.nextLine().toLowerCase();

            if (!opcion.equals("s")) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta pronto!");
            }
        }
    }

    private void mostrarCodigosDeMonedas() {
        System.out.println("\nCódigos de las monedas");
        System.out.println("USD - Dólar estadounidense");
        System.out.println("EUR - Euro");
        System.out.println("MXN - Peso mexicano");
        System.out.println("COP - Peso colombiano");
        System.out.println("ARS - Peso argentino");
        System.out.println("CLP - Peso chileno");
        System.out.println("PEN - Sol peruano");
        System.out.println("BRL - Real brasileño");
        System.out.println("UYU - Peso uruguayo");
        System.out.println("PYG - Guaraní paraguayo");
    }

    private String pedirCodigoMoneda(String tipo) {
        String codigo;
        while (true) {
            System.out.print("\nIngresa el código de la moneda " + tipo + " (ej: USD): ");
            codigo = scaner.nextLine().toUpperCase();

            if (codigo.matches("^[A-Z]{3}$")) {
                break;
            } else {
                System.out.println("Código inválido. Debe tener exactamente 3 letras (ej: USD, EUR).");
            }
        }
        return codigo;
    }

    private double pedirCantidad() {
        double cantidad = 0;
        while (true) {
            System.out.print("\nIngresa la cantidad a convertir: ");
            String entrada = scaner.nextLine();

            try {
                cantidad = Double.parseDouble(entrada);
                if (cantidad > 0) {
                    break;
                } else {
                    System.out.println("La cantidad debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número válido.");
            }
        }
        return cantidad;
    }
}

