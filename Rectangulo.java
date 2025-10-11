
/**
 * La clase Rectangulo representa una figura geométrica rectangular en el plano cartesiano,
 * definida por su origen (esquina inferior izquierda), su ancho y su alto.
 * Permite calcular su superficie y perímetro, desplazar su posición, 
 * medir la distancia entre rectángulos y determinar cuál tiene mayor superficie.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Rectangulo extends FiguraGeometrica{
  //V.I
  private double ancho;
  private double alto;
    
  /**
   * Constructor con origen, ancho y alto pasados por parametros.
   * 
   * @param p_origen Punto que representa el origen del rectangulo
   * @param p_ancho ancho del rectangulo
   * @param p_alto alto del rectangulo
   */
  Rectangulo (Punto p_origen, double p_ancho, double p_alto) {
      super(p_origen);
      this.setAncho(p_ancho);
      this.setAlto(p_alto);
  }
    
  /**
   * Constructor con origen (0,0), ancho y alto pasados por parametro.
   * 
   * @param p_ancho ancho del rectangulo
   * @param p_alto alto del rectangulo
   */
  Rectangulo (double p_ancho, double p_alto) {
    super(new Punto());
    this.setAncho(p_ancho);
    this.setAlto(p_alto);       
  }
  
  //SETTERS
  private void setAncho(double p_ancho) {
      this.ancho = p_ancho;
  }
  private void setAlto(double p_alto) {
      this.alto = p_alto;
  }
  
  //GETTERS
  public double getAncho() {
      return this.ancho;
  }
  public double getAlto() {
      return this.alto;
  }
  
  //METODOS DE COMPORTAMIENO
  /**
   * Desplaza el rectangulo en el plano sin cambiar sus dimensiones.
   * 
   * @param p_dx desplazamiento en el eje X
   * @param p_dy desplazamiento en el eje Y
   */
  public void desplazar(double p_dx, double p_dy) {
      this.getOrigen().desplazar(p_dx, p_dy);
  }
  
  /**
   * Calcula y devuelve el perimetro del rectangulo.
   * 
   * @return un valor tipo double
   */
  public double perimetro() {
      return 2 * (this.getAncho() + this.getAlto());
  }
  
  /**
   * Calcula y devuelve la superficie del rectangulo.
   * 
   * @return un valor tipo double
   */
  public double superficie() {
      return this.getAncho() * this.getAlto();
  }
  
  /**
   * Muestra por pantalla las caracteristicas del rectangulo.
   */
  public void caracteristicas() {
      System.out.printf("Origen: %s - Alto: %.2f - Ancho: %.2f", 
                        this.getOrigen().coordenadas(), this.getAlto(), this.getAncho());
      System.out.printf("\nSuperficie: %.2f - Perimetro: %.2f", 
                        this.superficie(), this.perimetro());
  }
  
  /**
   * Devuelve el nombre de la figura.
   * 
   * @return una cadena de caracteres
   */
  public String nombreFigura() {
        return "****** Rectangulo ******";
    }
  
  /**
   * Calcula y devuelve la distancia entre los origenes dos rectangulos.
   * 
   * @param otroRectangulo otro rectangulo a comparar
   * @return un valor de tipo double
   */
  public double distanciaA(Rectangulo otroRectangulo) {
      return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
  }
  
  /**
   * Determina y devuelve el rectangulo de mayor superficie.
   * 
   * @param otroRectangulo otro rectangulo a comparar
   * @return un objeto de tipo Rectangulo
   */
  public Rectangulo elMayor(Rectangulo otroRectangulo) {
      if(this.superficie() >= otroRectangulo.superficie()) {
          return this;
      }
      else {
          return otroRectangulo;
      }
  }
}