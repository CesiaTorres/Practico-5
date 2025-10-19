/**
 * La clase Renglon representa un renglon en un pedido.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Renglon {
    //V.I
    private int cantidad; //Cantidad de etiquetas de ese tipo
    private double importe; //Importe total de todas las etiquetas del renglon
    private Etiqueta item; //Etiqueta asociada al renglon

    //CONSTRUCTOR
    /**
     * Crea un renglon con una cantidad, un importe y un item de tipo etiqueta.
     * @param p_cantidad cantidad de etiquetas
     * @param p_item etiqueta asociada al renglon
     */
    public Renglon(int p_cantidad, Etiqueta p_item) {
        this.setCantidad(p_cantidad);
        this.setItem(p_item);
        this.setImporte(this.getItem().precio(this.getCantidad()));
    }

    //SETTERS
    private void setCantidad(int p_cantidad) {
        this.cantidad = p_cantidad;
    }
    private void setImporte(double p_importe) {
        this.importe = p_importe;
    }
    private void setItem(Etiqueta p_item) {
        this.item = p_item;
    }

    //GETTERS
    public int getCantidad() {
        return this.cantidad;
    }
    public double getImporte() {
        return this.importe;
    }
    public Etiqueta getItem() {
        return this.item;
    } 

    //METODOS DE COMPORTAMIENTO
    /**
     * Muestra en pantalla la cantidad de etiquetas y sus datos.
     */
    public void mostrar() {
        System.out.println(this.getCantidad() + " Etiquetas de " +
            this.getItem().toString());
    }
}
