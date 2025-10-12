import java.util.*;
/**
 * La clase AdministracionGerencia permite la administracion de una gerencia.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class AdministracionGerencia {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
        //Crear gerencia
		Gerencia gerencia = new Gerencia("Gerencia Los Arroyos");
        //Crear servicios disponibles
        ArrayList<Servicio> serviciosDisponibles = new ArrayList<Servicio>();
		crearServiciosDisponibles(serviciosDisponibles);
		
        //Menu interactivo
        Alojamiento nuevoAlojamiento = null;
		int opcion = 1;
		while (opcion != 0) {
			System.out.println("\n--- MENU ADMINISTRACION ---");
			System.out.println("1. Agregar alojamiento");
			System.out.println("2. Mostrar liquidación");
			System.out.println("0. Salir");
			System.out.print("\nIngrese una opcion: ");
			opcion = Integer.parseInt(lector.nextLine());

			switch (opcion) {
				case 1:
					nuevoAlojamiento = crearAlojamiento(lector);
                    gerencia.agregarAlojamiento(nuevoAlojamiento);
                    if (nuevoAlojamiento != null) {
                        System.out.println("Alojamiento agregado correctamente.");
                        agregarServiciosAlojamiento(nuevoAlojamiento, lector, serviciosDisponibles);
                    } else {
                        System.out.println("No se pudo agregar el alojamiento.");
                    }
					break;
				case 2:
					System.out.println("\n*** LIQUIDACION ***");
					gerencia.mostrarLiquidacion();
					break;
				case 0:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción inválida.");
			}
		}

	}

    /**
     * Crea los servicios disponibles y los agrega a la lista proporcionada.
     * @param p_servicios la lista donde se agregaran los servicios
     */
    private static void crearServiciosDisponibles(ArrayList<Servicio> p_servicios) {
        Servicio internet = new Servicio("Internet", 1500);
        p_servicios.add(internet);
		Servicio lavanderia = new Servicio("Lavanderia", 2000);
        p_servicios.add(lavanderia);
		Servicio alquilerAuto = new Servicio("Alquiler de auto", 1000);
        p_servicios.add(alquilerAuto);
    }

    /**
     * Crea un nuevo alojamiento (Hotel o Cabaña) segun la entrada del usuario.
     * @param p_lector Scanner para leer la entrada del usuario
     * @return el objeto Alojamiento creado, o null si la entrada es invalida
     */
    private static Alojamiento crearAlojamiento(Scanner p_lector) {
        System.out.println("\n*** Nueva reserva de alojamiento ***");        
        System.out.print("Ingrese tipo de alojamiento (1. Hotel, 2. Cabaña): ");
		int tipo = Integer.parseInt(p_lector.nextLine());
		System.out.print("Nombre del alojamiento: ");
		String nombre = p_lector.nextLine();
		System.out.print("Precio base por dia: ");
		double precioBase = Double.parseDouble(p_lector.nextLine());
		System.out.print("Cantidad de dias: ");
		int dias = Integer.parseInt(p_lector.nextLine());
        Alojamiento alojamiento = null;
        
        switch(tipo) {
            case 1:
                System.out.print("Ingrese tipo de habitacion (Single/Double): ");
                String tipoHabitacion = p_lector.nextLine();
                alojamiento = new Hotel(tipoHabitacion, nombre, precioBase, dias);
                return alojamiento;
            case 2:
                System.out.print("Ingrese cantidad de habitaciones: ");
                int nroHabitaciones = Integer.parseInt(p_lector.nextLine());
                alojamiento = new Cabaña(nroHabitaciones, nombre, precioBase, dias);
                return alojamiento;
            default:
                System.out.println("Tipo de alojamiento invalido.");
                return null;    
        }
    }
    
    /**
     * Permite al usuario agregar servicios a un alojamiento.
     * @param p_alojamiento el alojamiento al que se le agregaran servicios
     * @param p_lector Scanner para leer la entrada del usuario
     * @param p_serviciosDisponibles lista de servicios disponibles para agregar
     */
    private static void agregarServiciosAlojamiento(Alojamiento p_alojamiento, Scanner p_lector, 
                                            ArrayList<Servicio> p_serviciosDisponibles) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Servicios ---");
            System.out.println("1. Internet");
            System.out.println("2. Lavanderia");
            System.out.println("3. Alquiler de auto");
            System.out.println("0. Finalizar seleccion de servicios");
            System.out.print("\nSeleccione servicio: ");
            opcion = Integer.parseInt(p_lector.nextLine());

            switch (opcion) {
                case 1:
                    p_alojamiento.agregarServicio(p_serviciosDisponibles.get(0));
                    System.out.println("¡Internet agregado con exito!.");
                    break;
                case 2:
                    p_alojamiento.agregarServicio(p_serviciosDisponibles.get(1));
                    System.out.println("¡Lavanderia agregado con exito!.");
                    break;
                case 3:
                    p_alojamiento.agregarServicio(p_serviciosDisponibles.get(2));
                    System.out.println("Servicio Alquiler de auto agregado.");
                    break;
                case 0:
                    System.out.println("Finalizando seleccion de servicios.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
    //CASO DE PRUEBA
    /** Gerencia Gerencia Central
        Liquidacion ---------------------

        Alojamiento: Hotel Sol
        Costo por 7 dias: $10000.0
        1. Internet: $1500.0
        2. Lavandería: $2000.0
        ...............................
        Habitacion Single
        Total: -----> $73650.0

        Alojamiento: Cabaña Bosque
        Costo por 5 dias: $8000.0
        1. Lavanderia: $2000.0
        2. Alquiler de auto: $1000.0
        ...............................
        Cabaña con 2 habitaciones
        Total: -----> $43300.0
        
        Alojamiento tipo Hotel -----> 1
        Alojamiento tipo Cabaña -----> 1 **/

}

