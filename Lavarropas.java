/**
 * La clase ArtefactoHogar simula ..
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */

public class Lavarropas extends ArtefactoHogar {
    //V.I
    private int programas;
    private float kilos;
    private boolean automatico;

    //CONSTRUCTOR
    /**
     * Lavarropas que cuenta con programas, kilos y la posibilidad de ser automatico.
     * Ademas, presenta una marca, un precio y una cantidad de stock.
     * 
     * @param p_programas programas
     * @param p_kilos kilos que soporta
     * @param p_automatico si es automatico
     * @param p_marca marca
     * @param p_precio precio
     * @param p_stock stock total
     */
    public Lavarropas(int p_programas, float p_kilos, boolean p_automatico,
                    String p_marca, float p_precio, int p_stock) {
        super(p_marca, p_precio, p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);             
    }

    //SETTERS
    private void setProgramas(int p_programas) {
        this.programas = p_programas;
    }
    private void setKilos(float p_kilos) {
        this.kilos = p_kilos;
    }
    private void setAutomatico(boolean p_automatico) {
        this.automatico = p_automatico;
    }

    //GETTERS
    public int getProgramas() {
        return this.programas;
    }
    public float getKilos() {
        return this.kilos;
    }
    public boolean getAutomatico() {
        return this.automatico;
    }

    //METODOS
    /**
     * Muestra por pantalla los datos del lavarropas.
     */
    @Override
    public void imprimir() {
        System.out.println("\n**** Lavarropas ****");
        super.imprimir();
        System.out.println("Programas: " + this.getProgramas() + 
                    "\nKilos: " + this.getKilos() + "kg\nAutomatico: " +
                    this.getAutomatico());
    }

    /**
     * Calcula y devuelve el monto total de cada cuota con el adicional.
     * 
     * @param p_cuotas cantidad de cuotas
     * @param p_interes interes a pagar
     * @return total de la cuota con el adicional en formato float
     */
    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        float cuotaBase = this.cuotaCredito(p_cuotas, p_interes);
        if(!this.getAutomatico()) {
            return  cuotaBase - (cuotaBase * 0.02f);
        }
        else {
            return this.cuotaCredito(p_cuotas, p_interes);
        }
    }
}
