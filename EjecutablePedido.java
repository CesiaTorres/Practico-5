import java.util.*;
/**
 * La clase ejecutable EjecutablePedido permite ejecutar la clase Pedido
 * y administrar todas sus opciones.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class EjecutablePedido {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("*** Creacion de un pedido ***");
        Pedido pedido = new Pedido(crearRenglon(lector));

        int opcion = 1;
        while (opcion != 0) {
            System.out.println("\nMENU DE OPCIONES:");
            System.out.println("1. Agregar item\n2. Quitar item\n3. Mostrar pedido\n0. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(lector.nextLine());

            switch (opcion) {
                case 1:
                    Renglon nuevoRenglon = crearRenglon(lector);
                    pedido.agregarRenglon(nuevoRenglon);
                    System.out.println("¡Item agregado con exito!.");
                    break;
                case 2:
                    if(pedido.cantidadRenglones() == 1) {
                        System.out.println("No se puede eliminar el item.");
                        break;
                    }
                    pedido.mostrar();
                    System.out.print("Ingrese el item a eliminar (1 a " + (pedido.cantidadRenglones()) + "): ");
                    int item = Integer.parseInt(lector.nextLine());
                    if (item >= 0 && item < pedido.cantidadRenglones()) {
                        Renglon renglonAEliminar = pedido.obtenerRenglon(item);
                        pedido.eliminarRenglon(renglonAEliminar);
                        System.out.println("¡Item eliminado con exito!.");
                    } else {
                        System.out.println("Item invalido.");
                    }
                    break;
                case 3:
                    pedido.mostrar();
                    break;
                case 0:
                    System.out.println("Adios.");
                    break;
                default:
                    System.out.println("Opcion invalida. Vuelva a intentarlo.");
            }
        }    
    }

    /**
     * Crea un nuevo item y lo devuelve.
     * @param p_lector Scanner para leer la entrada del usuario.
     * @return un objeto Renglon
     */
    private static Renglon crearRenglon(Scanner p_lector) {
        System.out.println("\n-- Nuevo item --");
        System.out.print("Ingrese la cantidad de etiquetas: ");
        int cantidad = Integer.parseInt(p_lector.nextLine());
        System.out.print("Ingrese el tipo de etiqueta (1. Comun, 2. Premium): ");
        int tipo = Integer.parseInt(p_lector.nextLine());
        
        if(tipo == 1) {
            return new Renglon(cantidad, new Comun(100));
        } else {
            System.out.print("Ingrese la cantidad de colores: ");
            int colores = Integer.parseInt(p_lector.nextLine());
            return new Renglon(cantidad, new Premium(200, colores));
        }
    }
    /* Pedido: 
        Cantidad de items: 3
        Item 1: 7 Etiquetas de Tipo Premium - Costo: $200.0 - Colores: 10
        Precio: 1820.0
        Item 2: 57 Etiquetas de Tipo Comun - Costo: $100.0 - Diseño: $100.0
        Precio: 5510.0
        Item 3: 94 Etiquetas de Tipo Premium - Costo: $200.0 - Colores: 7
        Precio: 22748.0
        --- Total pedido: 158 Etiquetas por un Importe total de: $30078.0
    */
}
