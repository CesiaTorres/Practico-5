
/**
 * La clase CuentaCorriente representa un tipo de cuenta bancaria
 * que permite extracciones hasta un limite de descubierto. Extiende de CuentaBancaria.
 * <p>Esta clase mantiene un límite de descubierto y controla la extracción
 * de dinero considerando tanto el saldo disponible como el descubierto permitido.</p>
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class CuentaCorriente extends CuentaBancaria{
    //V.I
    private double limiteDescubierto; 
    
    //CONSTRUCTORES
    /**
     * Cuenta corriente con titular, numero de cuenta, titular, saldo inicial y limite
     * de descubierto de $500.
     * 
     * @param p_nroCuenta numero identificador de la cuenta
     * @param p_titular   titular de la cuenta
     * @param p_saldo     Saldo inicial de la cuenta
     */
    public CuentaCorriente (int p_nroCuenta, Persona p_titular,  double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setLimiteDescubierto(500);
    }
    
    //SETTERS
    private void setLimiteDescubierto(double p_limiteDescubierto) {
        this.limiteDescubierto = p_limiteDescubierto;
    }
    
    //GETTERS
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    //METODOS DE COMPORTAMIENTO     
    /**
     * Indica si es posible realizar una extraccion de un monto dado.
     * La extraccion es posible si el monto solicitado no supera la suma
     * del saldo disponible y el limite de descubierto.
     * 
     * @param p_importe monto que se desea extraer.
     * @return true si la extraccion puede realizarse, false en caso contrario.
     */
    protected boolean puedeExtraer(double p_importe) {
        if(p_importe <= (this.getSaldo() + this.getLimiteDescubierto())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Devuelve un mensaje indicando que no se puede realizar la extraccion
     * porque el importe supera el límite de descubierto.
     * 
     * @param p_importe monto que se desea extraer.
     * @return mensaje explicativo de la imposibilidad de extracción.
     */
    protected String xNoPuedeExtraer(double p_importe) {
        return "Importe supera el limite de descubierto.";
    }
      
    /**
     * Muestra por pantalla los detalles completos de la cuenta corriente:
     * número de cuenta, saldo, titular y limite de descubierto.
     */
    public void mostrar () {
        System.out.println("\n*** Cuenta Corriente ***");
        System.out.println("------------------------------------");
        super.mostrar();
        System.out.println("------------------------------------");
        System.out.println("Limite de descubierto: $" + this.getLimiteDescubierto());
    }
}