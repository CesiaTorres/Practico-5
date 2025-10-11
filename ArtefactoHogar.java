/**
 * La clase ArtefactoHogar simula ..
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public abstract class ArtefactoHogar {
    //V.I
    private String marca;
    private float precio;
    private int stock;

    //CONSTRUCTOR
    /**
     * Artefactos de hogar con marca, precio y una cantidad de stock.
     * 
     * @param p_marca marca del artefacto de hogar
     * @param p_precio precio del artefacto de hogar
     * @param p_stock cantidad de unidades disponibles
     */
    public ArtefactoHogar(String p_marca, float p_precio, int p_stock) {
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }

    //SETTERS
    private void setMarca(String p_marca) {
        this.marca = p_marca;
    }
    private void setPrecio(float p_precio) {
        this.precio = p_precio;
    }
    private void setStock(int p_stock) {
        this.stock = p_stock;
    }

    //GETTERS
    public String getMarca() {
        return this.marca;
    }
    public float getPrecio() {
        return this.precio;
    }
    public int getStock() {
        return this.stock;
    }

    //METODOS
    /**
     * Muestra por pantalla los datos comunes a todos los artefactos.
     */
    public void imprimir() {
        System.out.println("Marca: " + this.getMarca() +"\t- Precio: $" + 
                        this.getPrecio() + "\t- Stock: " + this.getStock());
    }

    /**
     * Calcula y devuelve el valor de la cuota al solicitar un credito.
     * 
     * @param p_cuotas cantidad de cuotas
     * @param p_interes interes a pagar
     * @return valor de la cuota en formato float
     */
    public float cuotaCredito(int p_cuotas, float p_interes) {
        return (this.getPrecio() + ((this.getPrecio() * p_interes)/100)) / p_cuotas;
    }

    /**
     * Calcula y devuelve el valor total del credito con el adicional.
     * 
     * @param p_cuotas cantidad de cuotas
     * @param p_interes interes a pagar
     */
    public abstract float creditoConAdicional(int p_cuotas, float p_interes);
}

