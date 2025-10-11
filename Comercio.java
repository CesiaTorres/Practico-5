import java.util.*;
/**
 * La clase ArtefactoHogar simula ..
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Comercio {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<ArtefactoHogar> artefactosHogar = new ArrayList<>();

        //Crear algunos artefactos
        System.out.println("=== COMERCIO DE ELECTRODOMESTICOS ===");
        crearArtefactos(artefactosHogar);
        System.out.println("Catalogo inicial cargado correctamente.\n");

        int opcion = 1;
        while (opcion != 0) {
            System.out.println("\n*** MENU DE CONSULTAS: CREDITOS ***");
            System.out.println("1. Consultar Heladera");
            System.out.println("2. Consultar Lavarropas");
            System.out.println("3. Consultar Cocina");
            System.out.println("0. Salir");
            System.out.print("\nIngrese una opcion: ");
            opcion = Integer.parseInt(lector.nextLine());

            switch(opcion) {
                case 1:
                    System.out.println("Con compresor (1) o sin compresor (2): ");
                    if(Integer.parseInt(lector.nextLine()) == 1) {
                        consultarCredito(artefactosHogar.get(0), lector);
                    }
                    else {
                        consultarCredito(artefactosHogar.get(1), lector);
                    }
                    break;
                case 2:
                    System.out.println("Automatico (1) o no automatico (2): ");
                    if(Integer.parseInt(lector.nextLine()) == 1) {
                        consultarCredito(artefactosHogar.get(4), lector);
                    }
                    else {
                        consultarCredito(artefactosHogar.get(5), lector);
                    }
                    break;
                case 3:
                    System.out.println("Con cuatro hornallas (1) o con dos (2): ");
                    if(Integer.parseInt(lector.nextLine()) == 1) {
                        consultarCredito(artefactosHogar.get(2), lector);
                    }
                    else {
                        consultarCredito(artefactosHogar.get(3), lector);
                    }
                    break;
                case 0:
                    System.out.println("Adios");
                    return;
                default:
                     System.out.println("Opcion invalida. Vuelva a ingresar.");

            }
        }


    }

    /**
     * Crea artefactos de hogar con valores estaticos.
     * 
     * @param p_artefactos coleccion de artefactos
     */
    private static void crearArtefactos(ArrayList<ArtefactoHogar> p_artefactos) {
        ArtefactoHogar h1 = new Heladera(4, 2, true, "Whirlpool", 450000, 3);
        p_artefactos.add(h1);
        ArtefactoHogar h2 = new Heladera(2, 1, false, "Patrick", 300000, 5);
        p_artefactos.add(h2);
        ArtefactoHogar c1 = new Cocina(4, 9000, "60x60", "Longvie", 250000, 4);
        p_artefactos.add(c1);
        ArtefactoHogar c2 = new Cocina(2, 9000, "30x30", "Longvie", 150000, 4);
        p_artefactos.add(c2);
        ArtefactoHogar l1 = new Lavarropas(10, 7.5f, true, "Samsung", 400000, 2);
        p_artefactos.add(l1);
        ArtefactoHogar l2 = new Lavarropas(8, 5.0f, false, "Drean", 270000, 6);
        p_artefactos.add(l2);
    }

    /**
     * Consulta el valor del credito para cada artefacto del hogar.
     * 
     * @param p_artefacto artefacto a consultar
     * @param p_lector entrada por teclado
     */
    public static void consultarCredito(ArtefactoHogar p_artefacto, Scanner p_lector) {
        System.out.println("\n--- Consulta de credito para " + p_artefacto.getMarca() + " ---");
        System.out.print("Ingrese cantidad de cuotas: ");
        int cuotas = Integer.parseInt(p_lector.nextLine());
        System.out.print("Ingrese interes (%): ");
        float interes = Float.parseFloat(p_lector.nextLine());
        
        float cuotaValor = p_artefacto.creditoConAdicional(cuotas, interes);
        float totalPrecio = cuotaValor * cuotas;
        
        p_artefacto.imprimir();
        System.out.println(".......................................");
        System.out.println("Precio base: $" + p_artefacto.getPrecio());
        System.out.println("Cuotas: " + cuotas + " - Interes: " +
                        interes + "%");
        System.out.printf("Valor de cada Cuota: $%.2f\n", p_artefacto.cuotaCredito(cuotas, interes));
        System.out.println("Valor Cuota Con Adicionales: $" + cuotaValor);
        System.out.println("Precio total: $" + totalPrecio);
    }
}



