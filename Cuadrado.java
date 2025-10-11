
/**
 * La clase Cuadrado representa una figura geométrica cuadrada en el plano cartesiano.
 * Permite obtener su superficie, nombre y mostrar sus características por pantalla.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Cuadrado extends Rectangulo {
    //CONSTRUCTOR
    /**
     * Cuadrado con origen y lados pasados por parametros.
     * 
     * @param p_origen origen del cuadrado
     * @param p_lado lado del cuadrado
     */
    public Cuadrado(Punto p_origen, double p_lado) {
        super(p_origen, p_lado, p_lado);
    }
    
    /**
       * Cuadrado con origen (0,0) y lado pasados por parametro.
       * 
       * @param p_lado lado del rectangulo
       */
    public Cuadrado (double p_lado) {
        super(new Punto(), p_lado, p_lado);    
    }
    
    //METODOS
    /**
     * Devuelve el nombre de la figura.
     * 
     * @return una cadena de caracteres
     */
    public String nombreFigura() {
        return "****** Cuadrado ******";
    }
    
    /**
     * Calcula y devuelve la superficie del cuadrado.
     * 
     * @return un valor de tipo double
     */
    public double superficie() {
      return this.getAlto() * this.getAncho();
    }
    
    /**
     * Muestra por pantalla las caracteristicas del cuadrado.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        super.caracteristicas();
    }
    
    /**EL polimorfismo es un comportamiento, se da en la herencia. 
     * Es la capacidad de que objetos de 
       diferentes tipos o clases puedan responder a un mismo mensajes.
       
       El polimorfismo del metodo ... nombreFigura() por ej.**/
}