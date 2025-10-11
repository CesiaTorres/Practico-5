
/**
 * La clase abstracta FiguraGeometrica representa la forma general
 * de una figura en el plano cartesiano. Define un punto de origen comun
 * para todas las figuras y establece la estructura basica que deben seguir
 * las clases hijas.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public abstract class FiguraGeometrica {
    //V.I
    private Punto origen;
    
    //CONSTRUCTOR
    /**
     * Figura geometrica con un punto de origen determinado.
     * 
     * @param p_origen punto de origen
     */
    public FiguraGeometrica(Punto p_origen) {
        this.setOrigen(p_origen);
    }
    
    //SETTERS
    private void setOrigen(Punto p_punto) {
        this.origen = p_punto;
    }
    
    //GETTERS
    public Punto getOrigen() {
        return this.origen;
    }
    
    //METODOS ABSTRACTOS
    /**
     * Devuelve el nombre de la figura geometrica.
     * 
     * @return una cadena de caracteres con el nombre de la figura
     */
    public abstract String nombreFigura();
    
    /**
     * Calcula y devuelve la superficie de la figura geometrica.
     * 
     * @return valor numérico de tipo double
     */
    public abstract double superficie();
    
    //METODOS CONCRETOS
     /**
     * Muestra por pantalla el nombre de la figura y su superficie.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.printf("Superficie: %.2f\n", this.superficie());
    }
}