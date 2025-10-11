
/**
 * La clase CajaDeAhorro representa un tipo de cuenta bancaria 
 * que permite realizar extracciones limitadas por un maximo de movimientos.
 * Extiende de CuentaBancaria.
 * <p>Esta clase mantiene un contador de extracciones posibles y controla 
 * la extracción de dinero de acuerdo con el saldo disponible y la cantidad 
 * de extracciones restantes.</p>
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class CajaDeAhorro extends CuentaBancaria{
    //V.I
    private int extraccionesPosibles;
    
    //CONSTRUCTORES 
    /**
     * Caja de Ahorro con titular, numero identificador, saldo inicial y
     * con un maximo de 10 extracciones.
     * 
     * @param p_nroCuenta numero identificador de la cuenta.
     * @param p_titular   titular de la cuenta
     * @param p_saldo     saldo inicial de la cuenta.
     */
    public CajaDeAhorro (int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }
    
    //SETTERS
    private void setExtraccionesPosibles(int p_extraccionesPosibles) {
        this.extraccionesPosibles = p_extraccionesPosibles;
    }
    
    //GETTERS
    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }
    
    //METODOS DE COMPORTAMIENTO
    /**
     * Indica si es posible realizar una extraccion de un monto dado.
     * La extracción es posible solo si el saldo es suficiente y 
     * quedan extracciones disponibles.
     * 
     * @param p_importe monto que se desea extraer.
     * @return un valor de tipo booleano
     */
    protected boolean puedeExtraer(double p_importe) {
        if(p_importe <= this.getSaldo() && this.getExtraccionesPosibles() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Realiza una extraccion de dinero de la cuenta y descuenta una extraccion
     * de las disponibles.
     * 
     * @param p_importe monto a extraer del saldo.
     */
    public void extraccion (double p_importe) {
       super.extraccion(p_importe);
       this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }
    
    /**
     * Devuelve un mensaje indicando por qué no se puede realizar una extracción.
     * 
     * @param p_importe monto que se desea extraer.
     * @return mensaje explicativo de la imposibilidad de extracción.
     */
    protected String xNoPuedeExtraer(double p_importe) {
        if (this.getExtraccionesPosibles() <= 0)
            return "No quedan extracciones disponibles.";
        else
            return "Saldo insuficiente.";
    }

    /**
     * Muestra por pantalla los detalles completos de la cuenta:
     * número de cuenta, saldo, titular y extracciones posibles.
     */
    public void mostrar () {
        System.out.println("\n*** Caja de Ahorros ***");
        System.out.println("------------------------------------");
        super.mostrar();
        System.out.println("------------------------------------");
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }
}