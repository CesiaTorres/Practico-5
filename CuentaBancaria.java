
/**
 * Clase abstracta CuentaBancaria representa una cuenta bancaria basica que permite 
 * gestionar un numero de cuenta, un titular y un saldo, y ofrece
 * operaciones fundamentales como depósito, extracción y consulta de informacion.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */

public abstract class CuentaBancaria {
    //V.I
    private int nroCuenta;
    private double saldo;
    private Persona titular; //TIENE 1 titular -> Relacion: Agregacion
    
    //CONSTRUCTORES
    /**
     * Cuenta bancaria con numero de cuenta, titular y saldo inicial.
     * 
     * @param p_nroCuenta numero de la cuenta bancaria
     * @param p_titular titular de la cuenta bancaria
     * @param p_saldo saldo de la cuenta bancaria
     */
    public CuentaBancaria (int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(p_saldo);
        this.setTitular(p_titular);
    }
    
    //SETTERS
    private void setNroCuenta (int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }
    private void setTitular (Persona p_titular) {
        this.titular = p_titular;
    }
    
    //GETTERS
    public int getNroCuenta() {
        return this.nroCuenta;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public Persona getTitular() {
        return this.titular;
    }
    
    //METODOS DE COMPORTAMIENTO
    /**
     * Deposita un monto en la cuenta, sumandolo al saldo actual.
     * 
     * @param p_importe monto a depositar.
     */
    public void depositar (double p_importe) {
      this.setSaldo(this.getSaldo() + p_importe);
    }
    
     /**
     * Extrae un monto del saldo actual de la cuenta sin realizar ninguna validacion.
     * 
     * @param p_importe monto a extraer.
     */
    public void extraccion (double p_importe) {
        this.setSaldo(getSaldo() - p_importe);
    }
    
    /**
     * Determina si se puede realizar una extracción de un monto dado.
     * 
     * @param p_importe monto que se desea extraer.
     * @return true si la extracción es posible, false en caso contrario.
     */
    protected abstract boolean puedeExtraer(double p_importe);
    
    /**
     * Realiza una extraccion de dinero de la cuenta.
     * Si la extraccion no es posible, muestra un mensaje explicativo.
     * 
     * @param p_importe Monto a extraer.
     */
    public void extraer (double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            this.extraccion(p_importe);
        }
        else {
            System.out.println(this.xNoPuedeExtraer(p_importe));
        }
    }
    
     /**
     * Devuelve un mensaje indicando por que no se puede realizar una extraccion.
     * 
     * @param p_importe monto que se desea extraer.
     * @return mensaje explicativo de la imposibilidad de extraccion.
     */
    protected abstract String xNoPuedeExtraer(double p_importe);

    /**
     * Muestra por pantalla los datos de la cuenta bancaria, incluyendo
     * número de cuenta, saldo y los datos del titular.
     */
    public void mostrar() {
        System.out.printf("Nro. Cuenta: %d - Saldo: $%.2f \n", this.getNroCuenta(),
                          this.getSaldo());
        System.out.println("\n*** Datos del titular ***");
        this.getTitular().mostrar();
    }
}