
/**
 * La clase ArtefactoHogar simula ..
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Cocina extends ArtefactoHogar {
    //V.I
    private int hornallas;
    private int calorias;
    private String dimensiones;

    //CONSTRUCTORES
    /**
     * Cocina con hornallas, calorias y dimensiones.
     * Ademas, presenta una marca, un precio y una cantidad de stock.
     * 
     * @param p_hornallas cantidad de hornallas
     * @param p_calorias calorias
     * @param p_dimensiones dimensiones de la cocina
     * @param p_marca marca
     * @param p_precio precio
     * @param p_stock stock total
     */
    public Cocina (int p_hornallas, int p_calorias, String p_dimensiones,
                    String p_marca, float p_precio, int p_stock) {
        super(p_marca, p_precio, p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);                
    }

    //SETTERS
    private void setHornallas(int p_hornallas) {
        this.hornallas = p_hornallas;
    }
    private void setCalorias(int p_calorias) {
        this.calorias = p_calorias;
    }
    private void setDimensiones(String p_dimensiones) {
        this.dimensiones = p_dimensiones;
    }

    //GETTERS
    public int getHornallas() {
        return this.hornallas;
    }
    public int getCalorias() {
        return this.calorias;
    }
    public String getDimensiones() {
        return this.dimensiones;
    }

    //METODOS
    /**
     * Muestra por pantalla los datos de la cocina.
     */
    @Override
    public void imprimir() {
        System.out.println("\n**** Cocina ****");
        super.imprimir();
        System.out.println("Hornallas: " + this.getHornallas() + "\nCalorias: " +
                    this.getCalorias() + "\nDimensiones: " + this.getDimensiones());
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
        return this.cuotaCredito(p_cuotas, p_interes);
    }

}
