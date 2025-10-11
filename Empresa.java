import java.util.*;
/**
 * La clase ejecutable Empresa permite crear y gestionar Personas y 
 * Empleados mediante entrada por teclado.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Empresa {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();
        
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("\n=== MENU EMPRESA ===");
            System.out.println("1. Crear Persona/Empleado");
            System.out.println("2. Mostrar todas las Personas/Empleados");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = lector.nextInt();
            /**ME QUEDA AGREGAR LA OPCION DE ELIMINAR -> OLVIDÉ**/
            switch(opcion) {
               case 1:
                   crearPersonaEmpleado(lector, personas);
                   break;
               case 2:
                   System.out.println("\n--- LISTADO ---\n");
                   for (Persona p : personas) {
                       p.mostrar();
                       System.out.println("--------------------------------");
                   }
                   break;
               case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
    }
    
    /**
     * Crea un objeto Persona o Empleado segun eleccion del usuario.
     *
     * @param lector Scanner para leer datos
     * @param personas ArrayList donde se guardará el objeto
     * @return objeto Persona (puede ser Empleado)
     */
    private static void crearPersonaEmpleado(Scanner p_lector, ArrayList<Persona> p_personas) {
        System.out.println("\n--- DATOS BASICOS ---");
        System.out.print("DNI: ");
        int dni = p_lector.nextInt();
        p_lector.nextLine();
        System.out.print("Nombre: ");
        String nombre = p_lector.nextLine();
        System.out.print("Apellido: ");
        String apellido = p_lector.nextLine();

        System.out.println("Fecha de nacimiento:");
        System.out.print("Dia: ");
        int dia = p_lector.nextInt();
        System.out.print("Mes: ");
        int mes = p_lector.nextInt();
        System.out.print("Año: ");
        int anio = p_lector.nextInt();
        Calendar fechaN = new GregorianCalendar(anio, mes-1, dia);

        System.out.print("\nDesea crear una Persona o Empleado? (P/E): ");
        char tipo = p_lector.next().toUpperCase().charAt(0);

        if(tipo == 'E') {
            System.out.println("\n--- DATOS EMPLEADO ---");
            System.out.print("CUIL: ");
            long cuil = p_lector.nextLong();
            System.out.print("Sueldo básico: ");
            double sueldo = p_lector.nextDouble();
            System.out.print("Año de ingreso: ");
            int anioIngreso = p_lector.nextInt();

            Empleado empleado = new Empleado(cuil, apellido, nombre, dni, fechaN, sueldo, anioIngreso);
            p_personas.add(empleado);
            System.out.println("¡Empleado creado con éxito!");
        } else {
            Persona persona = new Persona(dni, nombre, apellido, fechaN);
            p_personas.add(persona);
            System.out.println("¡Persona creada con éxito!");
        }
    }
}