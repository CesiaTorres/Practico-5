import java.util.*;
/**
 * Write a description of class Administracion here.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Administracion {
    public static void main (String [] args) {
        Scanner lector = new Scanner(System.in);
        int opcion = 1;
        
        //Crear jardin
        System.out.println("*** Crear Jardin ***");
        System.out.println("Ingrese nombre: ");
        Jardin jardin = new Jardin(lector.nextLine());
        System.out.println("¡Jardin creado con exito!\n");
        
        //Menu interactivo
        while(opcion != 0) {
            System.out.println("*** MENU JARDIN: FIGURAS A PINTAR ***");
            System.out.println("1. Crear figura"); 
            System.out.println("2. Eliminar figura"); 
            System.out.println("3. Mostrar detalles");
            System.out.println("0. Salir");
            System.out.print("\nIngrese una opcion: ");
            opcion = Integer.parseInt(lector.nextLine());
            
            switch(opcion) {
                case 1:
                    FiguraGeometrica figura = crearFigura(lector, jardin);
                    jardin.agregarFigura(figura);
                    System.out.println("¡Figura creada con exito!\n");
                    break;
                case 2:
                    if(jardin.getFiguras().isEmpty()) {
                        System.out.println("No hay figuras para mostrar.\n");
                        break;
                    }
                    FiguraGeometrica elimFigura = elegirFigura(lector, jardin);
                    if(elimFigura == null) {
                        System.out.println("No se encontró la figura.\n");
                        break;
                    }
                    jardin.quitarFigura(elimFigura);
                    System.out.println("¡Figura quitada con exito!\n");
                    break;
                case 3:
                    if(jardin.getFiguras().isEmpty()) {
                        System.out.println("No hay figuras para mostrar\n");
                        break;
                    }
                    jardin.detalleFiguras();
                    break;
                case 0:
                    System.out.println("Adios.");
                    return;
                default:
                    System.out.println("Opcion invalida. Vuelva a intertalo");
                
            }                      
        }
    }
    
    private static FiguraGeometrica crearFigura(Scanner p_lector, Jardin p_figuras) {
        System.out.println("*** Figura a crear *** ");
        System.out.println("1.Rectangulo\n2.Cuadrado\n3.Elipse\n4.Circulo\n5.Triangulo\n");
        System.out.print("Ingrese una opcion: ");
        int opcion = Integer.parseInt(p_lector.nextLine());
        
        switch(opcion) {
            case 1:
                System.out.print("Ingrese el ancho del rectangulo: ");
                double ancho = Double.parseDouble(p_lector.nextLine());
                System.out.print("Ingrese el alto del rectangulo: ");
                double alto = Double.parseDouble(p_lector.nextLine());
                return new Rectangulo(ancho, alto);
            case 2:
                System.out.print("Ingrese la longitud del lado: ");
                double lado = Double.parseDouble(p_lector.nextLine());
                return new Cuadrado(lado);
            case 3:
                System.out.print("Ingrese el semi eje mayor: ");
                double semiEjeMayor = Double.parseDouble(p_lector.nextLine());     
                System.out.print("Ingrese el semi eje menor: ");
                double semiEjeMenor = Double.parseDouble(p_lector.nextLine());
                return new Elipse(semiEjeMayor, semiEjeMenor);
            case 4:
                System.out.print("Ingrese el radio: ");
                double radio = Double.parseDouble(p_lector.nextLine()); 
                return new Circulo(radio);
            case 5:
                System.out.print("Ingrese la longitud de la base del triangulo: ");
                double base = Double.parseDouble(p_lector.nextLine());
                System.out.print("Ingrese la altura del triangulo: ");
                double altura = Double.parseDouble(p_lector.nextLine());
                return new Triangulo(base, altura);
            default:
                System.out.print("Opción invalida. Vuelva a intentarlo.");
                return null;
        }
    }
    
    private static FiguraGeometrica elegirFigura(Scanner p_lector, Jardin p_jardin) {
        int i = 1;
        System.out.println(".................................");
        for(FiguraGeometrica unaFigura : p_jardin.getFiguras()) {
            System.out.print(i++ + ". "); 
            unaFigura.mostrarSuperficie();
            System.out.println(".................................");
        }
        System.out.print("\nIngrese figura a eliminar (1, 2, ...): ");
        int nroFigura = Integer.parseInt(p_lector.nextLine());
        return p_jardin.buscarFigura(nroFigura);
    }
}