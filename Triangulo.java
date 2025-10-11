
/**
 * La clase Triangulo representa una figura geometrica triangular ubicada en el plano cartesiano.
 * Permite calcular su superficie a partir de su base y altura.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Triangulo extends FiguraGeometrica {
    //V.I
    private double base;
    private double altura;
    
    //CONSTRUCTOR
    /**
     * Triangulo con punto, base y altura ingresados por parametros.
     * 
     * @param p_punto punto inicio del triangulo
     * @param p_base base del triangulo
     * @param p_altura altura del triangulo
     */
    public Triangulo(Punto p_punto, double p_base, double p_altura) {
        super(p_punto);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }
    
    /**
     * Triangulo con punto (0,0) y, base y altura ingresados por parametros.
     * 
     * @param p_base base del triangulo
     * @param p_altura altura del triangulo
     */
    public Triangulo(double p_base, double p_altura) {
        super(new Punto());
        this.setBase(p_base);
        this.setAltura(p_altura);
    }
    
    //SETTERS
    private void setBase(double p_base) {
        this.base = p_base;
    }
    private void setAltura(double p_altura) {
        this.altura = p_altura;
    }
    
    //GETTERS
    public double getBase() {
        return this.base;
    }
    public double getAltura() {
        return this.altura;
    }
    
    //METODOS DE COMPORTAMIENTO
    /**
     * Devuelve el nombre de la figura.
     * 
     * @return una cadena de caracteres
     */
    public String nombreFigura() {
        return "****** Triangulo ******";
    }
    
    /**
     * Calcula y devuelve la superficie del triangulo.
     * 
     * @return un valor tipo double
     */
    public double superficie() {
        return (this.getBase() * this.getAltura()) / 2;
    }
}