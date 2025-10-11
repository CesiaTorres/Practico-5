/**
 * La clase ArtefactoHogar simula ..
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Heladera extends ArtefactoHogar {
    //V.I
    private int pies;
    private int puertas;
    private boolean compresor;

    //CONSTRUCTOR
    /**
     * Heladera que cuenta con una cantidad de puertas, pies cubicos y la posibilidad de tener compresor.
     * Ademas, presenta una marca, un precio y una cantidad de stock.
     * 
     * @param p_pies pies cubicos de la heladera
     * @param p_puertas cantidad de puertas
     * @param p_compresor si tiene compresor
     * @param p_marca marca
     * @param p_precio precio
     * @param p_stock stock total
     */
    public Heladera(int p_pies, int p_puertas, boolean p_compresor,
                    String p_marca, float p_precio, int p_stock) {
        super(p_marca, p_precio, p_stock);
        this.setPies(p_pies);
        this.setPuertas(p_puertas);
        this.setCompresor(p_compresor);
    }
    //SETTERS
    private void setPies(int p_pies) {
        this.pies = p_pies;
    }
    private void setPuertas(int p_puertas) {
        this.puertas = p_puertas;
    }
    private void setCompresor(boolean p_compresor) {
        this.compresor = p_compresor;
    }

    //GETTERS
    public int getPies() {
        return this.pies;
    }
    public int getPuertas() {
        return this.puertas;
    }
    public boolean getCompresor() {
        return this.compresor;
    }
    //METODOS
    /**
     * Muestra por pantalla los datos de la heladera.
     */
    @Override
    public void imprimir() {
        System.out.println("\n**** Heladera ****");
        super.imprimir();
        System.out.println("Pies: " + this.getPies() + "\nPuertas: " + 
                this.getPuertas() + "\nCompresor: " + this.getCompresor());
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
        if(this.getCompresor()) {
            return this.cuotaCredito(p_cuotas, p_interes) + 50; 
        }
        else {
            return this.cuotaCredito(p_cuotas, p_interes);
        }
    }

}
