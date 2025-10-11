import java.util.*;
/**
 * La clase ejecutable Escuela representa a una institucion educativa que permite crear y gestionar Personas y Alumnos 
 * mediante entrada por teclado.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Escuela {
    public static void main (String[] args) {
        Scanner lector = new Scanner(System.in);
        //Coleccion de personas
        ArrayList<Persona> personas = new ArrayList<>();
        /** Cada posición del ArrayList guarda una referencia a un objeto Persona, 
             pero el objeto real puede ser Persona o Alumno.**/
        int opcion = 1;
        
        while (opcion != 0) {
            System.out.println("\n=== MENU ESCUELA ===");
            System.out.println("1. Crear persona/alumno");
            System.out.println("2. Mostrar todas las personas/alumnos");
            System.out.println("0. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion = lector.nextInt();
            /**ME QUEDA AGREGAR LA OPCION DE ELIMINAR -> OLVIDÉ**/
            switch(opcion) {
                case 1:
                    crearPersona(lector, personas);
                    break;
                case 2:
                    System.out.println("\n--- LISTADO ---\n");
                    for (Persona unaPersona : personas) {
                        unaPersona.mostrar();
                        System.out.println("--------------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida. Vuelta a intentarlo");        
            }
        }
    }

    
    /**
     * Crea un objeto Persona o Alumno segun la eleccion del usuario.
     * 
     * @param p_lector Scanner para leer datos por teclado
     * @param p_personas coleccion donde se guardará la persona/alumno
     * @return un objeto de tipo Persona (puede ser Alumno)
     */
    private static void crearPersona(Scanner p_lector, 
                                    ArrayList<Persona> p_personas) {   
        System.out.println("\n--- DATOS BASICOS---");
        System.out.print("DNI: ");
        int dni = p_lector.nextInt();
        p_lector.nextLine();   
        System.out.print("Nombre: ");
        String nombre = p_lector.nextLine();
        System.out.print("Apellido: ");
        String apellido = p_lector.nextLine(); 
        
        System.out.println("\nFecha de nacimiento: ");
        System.out.print("Dia: ");
        int dia = p_lector.nextInt();
        System.out.print("Mes: ");
        int mes = p_lector.nextInt();
        System.out.print("Año: ");
        int año = p_lector.nextInt(); 
        Calendar fechaN = new GregorianCalendar(año, mes-1, dia);
        
        System.out.println("\n¿Desea crear un Alumno o solo una Persona? (A/P): ");
        char tipo = p_lector.next().toUpperCase().charAt(0); //entrada -> mayus -> primera letra
        
        if(tipo == 'A') {
            System.out.println("\n--- Datos Escolares ---");
            System.out.print("LU: ");
            int lu = p_lector.nextInt();
            System.out.print("Nota 1: ");
            double nota1 = p_lector.nextDouble();
            System.out.print("Nota 2: ");
            double nota2 = p_lector.nextDouble();
            
            Alumno alumno = new Alumno(dni, lu, nombre, apellido, fechaN);
            alumno.setNota1(nota1);
            alumno.setNota2(nota2);
            
            p_personas.add(alumno);
            System.out.println("¡Alumno creado con exito!");
        }
        else {
            Persona persona = new Persona(dni, nombre, apellido, fechaN);
            p_personas.add(persona);
            System.out.println("¡Persona creada con exito!");
        }  
    }
}