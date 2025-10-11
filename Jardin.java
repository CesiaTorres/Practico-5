import java.util.*;
/**
 * La clase Jardin representa a una institucion educativa tipo jardin de infantes.
 * Cuenta con un nombre y una coleccion de figuras geométricas en su piso. Las figuras 
 * se pueden administrar y pintar.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Jardin {
    //V.I
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;
    
    //CONSTRUCTORES
    /**
     * Jardin con un nombre y figuras en su piso.
     * 
     * @param p_nombre nombre del jardín
     * @param p_figuras lista de figuras geometricas que forman el jardín
     */
    public Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras) {
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras);
    }
    
    /**
     * Jardin con nombre.
     * 
     * @param p_nombre nombre del jardin
     */
    public Jardin(String p_nombre) {
        this.setNombre(p_nombre);
        this.setFiguras(new  ArrayList<FiguraGeometrica>());
    }
    
    //SETTERS
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras) {
        this.figuras = p_figuras;
    }
    
    //GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public ArrayList<FiguraGeometrica> getFiguras() {
        return this.figuras;
    }
    
    //METODOS PARA EL MANEJO DE ARRAYLIST
    public boolean agregarFigura(FiguraGeometrica p_figura) {
        return this.getFiguras().add(p_figura);
    }
    public boolean quitarFigura(FiguraGeometrica p_figura) {
        return this.getFiguras().remove(p_figura);
    }
    public int contarFiguras() {
        return this.getFiguras().size();
    }
    public FiguraGeometrica buscarFigura(int p_posicion) {
        return this.getFiguras().get(p_posicion-1);
    }
    
    //METODOS DE COMPORTAMIENTO
    /**
     * Calcula y devuelve el area total de todas las figuras del jardin en metros 
     * cuadrados.
     * 
     * @return area total de las figuras
     */
    public double cuantosMetros() {
        double totalMetros = 0;
        for(FiguraGeometrica unaFigura : this.getFiguras()) {
            totalMetros += unaFigura.superficie();
        }
        return totalMetros;
    }
    
    /**
     * Calcula y devuelve la cantidad de litros de pintura necesarios para cubrir 
     * la superficie de todas las figuras.
     * 
     * @return litros de pintura
     */
    public double cuantosLitros() {
        return cuantosMetros() / 5; //1 litro -> 5 m²
    }
    
    /**
     * Calcula y devuelve la cantidad de latas de pintura que se necesitan para cubrir 
     * la superficie de todas las figuras.
     * 
     * @return numero de latas
     */
    public int cuantasLatas() {
        return (int) Math.ceil(cuantosLitros() / 4); //1 lata -> 4 litros -> 20 m²
    }
    
    /**
     * 
     */
    public void detalleFiguras() {
        int i = 1;
        System.out.println("*** Detalles de Figuras/Pintura ***");
        System.out.println("----------------***----------------");
        for(FiguraGeometrica unaFigura : this.getFiguras()) { 
           unaFigura.mostrarSuperficie();
           System.out.println(".................................");
        }
        System.out.println("Figuras totales: " + this.contarFiguras());
        System.out.printf("Metros a cubrir:  %.2f\n", this.cuantosMetros());
        System.out.printf("Litros:  %.2f\n", this.cuantosLitros());
        System.out.println("Latas de 4L: " + this.cuantasLatas());
        System.out.println("----------------***----------------\n");
    }
}