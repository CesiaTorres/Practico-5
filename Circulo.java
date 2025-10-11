
/**
 * La clase Circulo representa una figura geométrica circular en el plano cartesiano.
 * Permite calcular su superficie, perímetro (circunferencia), desplazar su posición,
 * medir la distancia entre centros de dos círculos y determinar cuál tiene mayor superficie.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Circulo extends Elipse {
    
  //CONSTRUCTORES
  /**
   * Constructor con radio 0 y centro en (0,0).
   */
  public Circulo () {
    super(new Punto(), 0.0, 0.0);
  }
  
  /**
   * Constructor con centro y radio pasados por parametros.
   * 
   * @param p_radio radio que tendrá el circulo
   * @param p_centro centro que tendrá el del circulo
   */
  public Circulo (double p_radio, Punto p_centro) {
    super(p_centro, p_radio, p_radio);
  }
  
  /**
   * Constructor con centro y radio pasados por parametros.
   * 
   * @param p_radio radio que tendrá el circulo
   * @param p_centro centro que tendrá el del circulo
   */
  public Circulo (double p_radio) {
    super(new Punto(), p_radio, p_radio);
  }
  
  //GETTERS
  public double getRadio() {
      return this.getSEjeMayor();
      /*this incluye los metodos heredados. Es decir primero busca en la clase actual
         si no la encuentra, busca en Elipse (donde si está)*/
  }
  
  //METODOS
  /**
   * Devuelve el nombre de la figura.
   * 
   * @return una cadena de caracteres
   */
  public String nombreFigura() {
        return "****** Circulo ******";
  }
    
  /**
   * Desplaza el circulo moviendo su centro.
   * 
   * @param p_dx desplazamiento en X
   * @param p_dy desplazamiento en Y
   */
  public void desplazar (double p_dx, double p_dy) {
    super.getOrigen().desplazar(p_dx, p_dy);
  }
  
  /**
   * Muestra por pantalla las caracteristicas del circulo.
   */
  public void caracteristicas() {
    System.out.println(this.nombreFigura());
    System.out.printf("Centro: %s - Radio: %.2f%n", this.getOrigen().coordenadas(), this.getRadio());
    System.out.printf("Superficie: %.2f - Perimetro: %.2f%n", this.superficie(), this.perimetro());
  }
    
   /**
   * Calcula y devuelve el primetro (circunferencia) del circulo.
   * 
   * @return perimetro
   */
  public double perimetro() {
    return 2 * Math.PI * this.getRadio();
  }
  
  /**
   * Calcula y devuelve la superficie del circulo.
   * 
   * @return un valor de tipo double
   */
  public double superficie() {
      return Math.PI * Math.pow(this.getRadio(), 2);
  }
  
  /**
   * Devuelve la distancia entre los centros de dos circulos.
   * 
   * @param otroCirculo el otro circulo con el cual medir distancia
   * @return distancia entre centros
   */
  public double distanciaA (Circulo otroCirculo) {
    return this.getOrigen().distanciaA(otroCirculo.getOrigen());
  }
  
  /**
   * Devuelve el circulo con mayor superficie (si son iguales, devuelve this).
   * 
   * @param otroCirculo el otro circulo
   * @return el circulo de mayor superficie
   */
  public Circulo elMayor (Circulo otroCirculo) {
      if(this.superficie() >= otroCirculo.superficie()) {
          return this;
      }
      else {
          return otroCirculo;
      }
  }
}