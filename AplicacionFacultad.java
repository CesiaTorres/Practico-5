import java.util.*;
/**
 * Write a description of class AplicacionFacultad here.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class AplicacionFacultad {
    public static void main (String[] args) {
        Scanner lector = new Scanner(System.in);
        
        //Nueva facultad
        System.out.println("*** Nueva Facultad ***");
        System.out.print("Ingrese un nombre: "); //FaCENA
        Facultad facultad = new Facultad(lector.nextLine());
        crearProfesor(lector, facultad);
        
        //Menu interactivo
        int opcion = 1;
        while(opcion != 0) {
            System.out.println("\n************ MENU FACULTAD ************");
            System.out.println("1. Agregar un Profesor");
            System.out.println("2. Quitar un Profesor");
            System.out.println("3. Buscar un Profesor");
            System.out.println("4. Listar cargos de todos los Profesores");
            System.out.println("5. Mostrar nómina y sueldos totales");
            System.out.println("0. Salir");
            System.out.print("\nIngrese una opcion: ");
            opcion = Integer.parseInt(lector.nextLine());
            
            switch(opcion) {
                case 1:
                    crearProfesor(lector, facultad);
                    System.out.println("¡Profesor añadido con exito!");
                    break;
                case 2:
                    if(facultad.contarProfesores() > 1) {
                        eliminarProfesor(lector, facultad);
                    }
                    else {
                        System.out.println("¡No se puede eliminar el profesor de la lista!");
                    }
                    break;
                case 3:
                    buscarProfesor(lector, facultad);
                    break;
                case 4:
                    facultad.listarProfesorCargos();
                    break;
                case 5: 
                    facultad.nominaProfesores();
                    break;
                default:
                    System.out.println("Opcion invalida. Vuelva a intentarlo.");
            }
        }
    }
    
    /**
     * Crea y agrega un nuevo profesor a la facultad.
     * 
     * @param p_lector Scanner para entrada por teclado
     * @param p_facultad facultad a la que se le añade el profesor
     */
    private static void crearProfesor(Scanner p_lector, Facultad p_facultad) {
        System.out.println("\n** Nuevo Profesor **");
        System.out.print("Ingrese el titulo profesional: ");
        String titulo = p_lector.nextLine();
        
        System.out.println("\nDatos personales");
        System.out.print("DNI: ");
        int dni = p_lector.nextInt();
        p_lector.nextLine();
        System.out.print("Apellido/s: ");
        String apellido = p_lector.nextLine();
        System.out.print("Nombre/s: ");
        String nombre = p_lector.nextLine();
        System.out.println("Fecha de nacimiento");
        System.out.print("Dia: ");
        int dia = p_lector.nextInt();
        System.out.print("Mes: ");
        int mes = p_lector.nextInt();
        System.out.print("Año: ");
        int anio = p_lector.nextInt();
        p_lector.nextLine();
        
        Calendar fechaN = new GregorianCalendar(anio, mes, dia);
        Profesor profesor = new Profesor(dni, nombre, apellido, fechaN, titulo);
        
        System.out.println("\n** Ingresar Cargos (hasta " + profesor.getCargos().length + ") **");
        int cargosIngresados = 0;
        String opcion;
        for (int i = 0; i < profesor.getCargos().length; i++) {
             System.out.print("\n¿Desea ingresar el cargo " + (i+1) + " de " + profesor.getCargos().length + "? (s/n): ");
             opcion = p_lector.nextLine().trim().toLowerCase();
             if (opcion.equals("s") || opcion.equals("S")) {
                crearCargo(p_lector, profesor);
                cargosIngresados++;
                System.out.println("Cargo agregado!");
             }
             else {
                 System.out.println("No se ingresará mas cargos.");
                 break;
             } 
        } 
        
        if (cargosIngresados > 0) {
            p_facultad.agregarProfesor(profesor);
            System.out.println("\nProfesor creado correctamente con " + cargosIngresados + " cargos.");
        } else {
            System.out.println("\nNo se puede crear un profesor sin cargos. El registro fue cancelado.");
        }
    }
    
    private static void eliminarProfesor(Scanner p_lector, Facultad p_facultad) {
        p_facultad.nominaProfesores();
        System.out.println("\n** Profesor a eliminar **");
        System.out.print("Ingrese el DNI: ");
        int dni = Integer.parseInt(p_lector.nextLine());
        Profesor profesor = p_facultad.quitarProfesor(dni);
        if(profesor == null) {
             System.out.println("¡El profesor no encontrado!");
        }
        else {
             System.out.println("¡Profesor eliminado con exito!");
        }
    }
    
    private static void buscarProfesor(Scanner p_lector, Facultad p_facultad) {
        System.out.println("** Profesor a buscar **");
        System.out.print("Ingrese el DNI: ");
        int dni = Integer.parseInt(p_lector.nextLine());
        Profesor profesor = p_facultad.buscarProfesor(dni);
        if(profesor == null) {
           System.out.println("¡El profesor no encontrado!");
        }
        else {
           System.out.println("¡Profesor encontrado!\n");
           profesor.mostrar();
        }
    }
    
    private static void crearCargo (Scanner p_lector, Profesor p_profesor) {
        int horasE = 0, horasI = 0;
        String tipoCargo;
        
        System.out.printf("Nombre del cargo: ");
        String cargo = p_lector.nextLine();
        System.out.printf("Sueldo basico: ");
        double sueldo = Double.parseDouble(p_lector.nextLine());
        System.out.printf("Año de Ingreso: ");
        int anio = Integer.parseInt(p_lector.nextLine());
        
        do {
            System.out.print("\nTipo de Cargo (S: Simple, E: Exclusivo, SE: Semiexclusivo): ");
            tipoCargo = p_lector.nextLine().toUpperCase();
            if (!tipoCargo.equals("S") && !tipoCargo.equals("E") && !tipoCargo.equals("SE")) {
                System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (!tipoCargo.equals("S") && !tipoCargo.equals("E") && !tipoCargo.equals("SE"));
    
            
        switch(tipoCargo) {
            case "S":
                Cargo cargoSimple = new Simple(cargo, sueldo, anio);
                p_profesor.agregarCargo(cargoSimple);
                break;
            case "E":
                System.out.printf("\nIngrese horas dedicadas a docencia: ");
                int docencia = Integer.parseInt(p_lector.nextLine());
                System.out.printf("Ingrese horas dedicadas a invesigacion: ");
                int investigacion = Integer.parseInt(p_lector.nextLine());
                System.out.printf("Ingrese horas de extension: ");
                int extension = Integer.parseInt(p_lector.nextLine());
                Cargo cargoExclusivo = new Exclusivo(cargo, sueldo, anio, docencia,
                                                    investigacion, extension);
                p_profesor.agregarCargo(cargoExclusivo);
                break;
            case "SE":
                int maxHoras = 10;
                do {
                    System.out.print("\nDedica horas a extension (E), investigación (I) o ambas (A)?: ");
                    tipoCargo = p_lector.nextLine().toUpperCase();
                    if (!tipoCargo.equals("E") && !tipoCargo.equals("I") && !tipoCargo.equals("A")) {
                        System.out.println("Opcion invalida. Intente nuevamente.");
                    }
                } while (!tipoCargo.equals("E") && !tipoCargo.equals("I") && !tipoCargo.equals("A"));

                switch(tipoCargo) {
                    case "E":
                        System.out.printf("Cantidad de horas a extension (max 10hs): ");
                        horasE = Integer.parseInt(p_lector.nextLine());
                        if(horasE <= maxHoras) {
                            Cargo semiExclusivo = new SemiExclusivo(cargo, sueldo,
                                        anio, horasE, 0);
                            p_profesor.agregarCargo(semiExclusivo);
                        }
                        else {
                            System.out.println("Se excede el limite de horas");
                        }
                        break;
                    case "I":
                        System.out.printf("Cantidad de horas de investigacion (max 10hs): ");
                        horasI = Integer.parseInt(p_lector.nextLine());
                        if(horasI <= maxHoras) {
                            Cargo semiExclusivo = new SemiExclusivo(cargo, sueldo,
                                        anio, 0, horasI);
                            p_profesor.agregarCargo(semiExclusivo);
                        }
                        else {
                            System.out.println("Se excede el limite de horas");
                        }
                        break;
                    case "A":
                        System.out.printf("Cantidad de horas a extension: ");
                        horasE = Integer.parseInt(p_lector.nextLine());
                        System.out.printf("Cantidad de horas de investigacion: ");
                        horasI = Integer.parseInt(p_lector.nextLine());
                        if(horasE+horasI <= maxHoras) {
                            Cargo semiExclusivo = new SemiExclusivo(cargo, sueldo,
                                        anio, horasE, horasI);
                            p_profesor.agregarCargo(semiExclusivo);
                        }
                        else {
                            System.out.println("Se excede el limite de horas");
                        }
                        break;
                    default:
                        System.out.printf("Opcion invalida. Vuelva a intentalo.");
                }
                break;
            default:
                System.out.printf("Opcion invalida. Vuelva a intentalo.");
        }
    }
}