import java.util.*;
/**
 * La clase EjecutableZoologico contiene el metodo main para ejecutar el programa del zoologico.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class EjecutableZoologico {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        //Creo el zoologico
        Zoologico zoologico = new Zoologico("El Caribú");

        //Menu interactivo
        int opcion = 1;
        Visitante visitante = null;
        Calendar fechaVisita = null;
        while(opcion != 0) {
            System.out.println("\n=== MENU DEL ZOOLOGICO EL CARIBÚ ===");
            System.out.println("1. Registrar individuo visitante");
            System.out.println("2. Registrar delegacion de visitantes");
            System.out.println("3. Listar todos los visitantes por fecha");
            System.out.println("4. Listar un tipo de visitantes por fecha");
            System.out.println("5. Recaudacion entre fechas");
            System.out.print("\nIngrese una opcion: ");
            opcion = Integer.parseInt(lector.nextLine());

            switch(opcion) {
                case 1:
                    fechaVisita = solicitarFecha(lector);
                    visitante = registrarIndividuo(lector, fechaVisita);
                    if(visitante != null) {
                        zoologico.inscribirVisitante(visitante);
                        System.out.println("¡Visitante registrado con exito!.");
                    }
                    else {
                        System.out.println("No se pudo registrar el visitante.");
                    }
                    break;
                case 2:
                    fechaVisita = solicitarFecha(lector);
                    visitante = registrarDelegacion(lector, fechaVisita);
                    if(visitante != null) {
                        zoologico.inscribirVisitante(visitante);
                        System.out.println("¡Delegacion registrada con exito!.");
                    }
                    else {
                        System.out.println("No se pudo registrar la delegacion.");
                    }
                    break;
                case 3:
                    if(zoologico.cantidadVisitantes() == 0) {
                        System.out.println("No hay visitantes registrados en el zoologico.");
                        break;
                    }
                    System.out.println("\n*** Listado de visitantes por fecha ***");
                    zoologico.listarVisitantePorFecha(solicitarFecha(lector));
                    break;
                case 4:
                    if(zoologico.cantidadVisitantes() == 0) {
                        System.out.println("No hay visitantes registrados en el zoologico.");
                        break;
                    }
                    System.out.println("\n*** Listado de un tipo de visitantes por fecha ***");
                    System.out.print("Tipo de visitante (Individuo/Delegacion): ");
                    String tipo = lector.nextLine();
                    zoologico.listarTipoVisitantePorFecha(solicitarFecha(lector), tipo);
                    break;
                case 5:
                    System.out.println("\n*** Recaudacion entre fechas ***");
                    System.out.println("Ingrese la fecha inicial");
                    Calendar fechaInicio = solicitarFecha(lector);
                    System.out.println("Ingrese la fecha final");
                    Calendar fechaFin = solicitarFecha(lector);
                    zoologico.recaudacion(fechaInicio, fechaFin);
                    System.out.println("\nTotal recaudado: $" + 
                                       zoologico.recaudacion(fechaInicio, fechaFin));
                    break;
                case 0:
                    System.out.println("Adios!");
                    return;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }                   
        }
    }

    /**
     * Registra un individuo visitante.
     * @param p_lector Scanner para leer la entrada del usuario.
     * @param p_fechaVisita Fecha de la visita del individuo.
     * @return El objeto Individuo registrado
     */
    private static Visitante registrarIndividuo(Scanner p_lector, Calendar p_fechaVisita) {
        System.out.println("\n*** Nuevo registro de individuo ***");
        System.out.print("Nombre: ");
        String nombre = p_lector.nextLine();
        System.out.print("Apellido: ");
        String apellido = p_lector.nextLine();
        System.out.print("DNI: ");
        int dni = Integer.parseInt(p_lector.nextLine());
        System.out.print("Año de nacimiento: ");
        int anioNacimiento = Integer.parseInt(p_lector.nextLine());
        Persona persona = new Persona(dni, nombre, apellido, anioNacimiento);
        Visitante visitante = new Individuo("Individuo", p_fechaVisita, persona);
        return visitante;    
    }

    /**
     * Solicita una fecha al usuario. Luego la devuelve.
     * @param p_lector Scanner para leer la entrada del usuario.
     * @return La fecha ingresada por el usuario como un objeto Calendar.
     */
    private static Calendar solicitarFecha(Scanner p_lector) {
        System.out.println("Fecha de visita ");
        System.out.print("Dia: ");
        int dia = Integer.parseInt(p_lector.nextLine());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(p_lector.nextLine()) - 1; //Resta 1 porque los meses en Calendar van de 0 a 11
        System.out.print("Anio: ");
        int anio = Integer.parseInt(p_lector.nextLine());
        return new GregorianCalendar(anio, mes, dia);
    }

    /**
     * Registra una delegacion de visitantes.
     * @param p_lector Scanner para leer la entrada del usuario.
     * @param p_fechaVisita Fecha de la visita de la delegacion.
     */
    private static Visitante registrarDelegacion(Scanner p_lector, Calendar p_fechaVisita) {
        System.out.println("\n*** Nuevo registro de delegacion ***");
        System.out.print("Nombre de la delegacion: ");
        String nombre = p_lector.nextLine();
        
        ArrayList<Individuo> individuos = new ArrayList<Individuo>();
        Individuo individuo = null;
        String opcion = "s";
        System.out.println("\nInscripcion de individuos en la delegacion");
        while(opcion.equalsIgnoreCase("s")) {
            individuo = (Individuo) registrarIndividuo(p_lector, p_fechaVisita); //Cast necesario
            
            if(individuo != null) {
                individuos.add(individuo);
                System.out.println("Individuo inscripto.");
            }
            else {
                System.out.println("No se pudo inscribir el individuo.");
            }

            System.out.print("\n¿Desea inscribir otro individuo? (s/n): ");
            opcion = p_lector.nextLine();
        }

        if(!individuos.isEmpty() || individuos.size() > 1) { //Delegacion de un individuo ???
            Visitante visitante = new Delegacion(individuos, nombre, p_fechaVisita);
            return visitante;
        }
        else {
            System.out.println("No se pudo registrar la delegacion. Debe tener al menos dos individuo.");
            return null;
        }  

        /*CASO DE PRUEBA
        Fecha de visita: 22.9.2024 
        ..........................
        
        Ingrese una opcion: 1
        Nombre: Carlos
        Apellido: Gimenez
        DNI: 42
        Año de nacimiento: 2000
        ..........................

        Ingrese una opcion: 2
        Nombre de la delegacion: PAMI

        Nombre: Maria
        Apellido: Lusteau
        DNI: 23
        Año de nacimiento: 1969
        Individuo inscripto.

        Nombre: Carlos
        Apellido: Lopez
        DNI: 24
        Año de nacimiento: 1978
        Individuo inscripto.
        ............................

        Ingrese una opcion: 3
        -------------***---------------
        Nombre y Apellido: Carlos Gimenez
        DNI: 42 Edad: 25 años
        -------------------------------
        Delegacion: PAMI
        Integrantes:
        ...............................
        Nombre y Apellido: Maria Lusteau
        DNI: 23 Edad: 56 años
        ...............................
        Nombre y Apellido: Carlos Lopez
        DNI: 24 Edad: 47 años
        ...............................
        Cantidad de integrantes: 2
        Monto total de entrada (-10%): $18.0
        -------------------------------
        ............................

        Ingrese una opcion: 5
        Ingrese la fecha inicial: 22.9.2024
        Total recaudado: $28.0

        */      
    }
}
