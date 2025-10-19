import java.util.*;
/**
 * La clase Pedido representa un pedido compuesto por varios renglones.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Pedido {
    //V.I
    private ArrayList<Renglon> renglones; //1...*

    //CONSTRUCTOR
    /**
     * Crea un pedido con una lista de renglones vacia.
     * @param p_renglon renglon a agregar al pedido
     */
    public Pedido(Renglon p_renglon) {
        this.setRenglones (new ArrayList<Renglon>());
        this.agregarRenglon(p_renglon);
    }

    //SETTERS
    private void setRenglones(ArrayList<Renglon> p_renglones) {
        this.renglones = p_renglones;
    }
    //GETTERS
    public ArrayList<Renglon> getRenglones() {
        return this.renglones;
    }

    //METODOS PARA EL MANEJO DE ARRAYLIST
    public void agregarRenglon(Renglon p_renglon) {
        this.getRenglones().add(p_renglon);
    }
    public void eliminarRenglon(Renglon p_renglon) {
        this.getRenglones().remove(p_renglon);
    }
    public Renglon obtenerRenglon(int p_indice) {
        return this.getRenglones().get(p_indice-1);
    }
    public int cantidadRenglones() {
        return this.getRenglones().size();
    }

    //METODOS DE COMPORTAMIENTO
    /**
     * Muestra en pantalla los datos del pedido.
     */
    public void mostrar() {
        System.out.println("\nPedido: " + "\nCantidad de items: " +
            this.cantidadRenglones());
        int i = 1;
        int totalEtiquetas = 0;
        double sumaImportes = 0;
        
        for(Renglon unRenglon : this.getRenglones()) {
            System.out.print("Item " + i++ + ": ");
            unRenglon.mostrar();
            System.out.println("Precio: " + unRenglon.getItem().precio(unRenglon.getCantidad()));
            totalEtiquetas += unRenglon.getCantidad();
            sumaImportes += unRenglon.getItem().precio(unRenglon.getCantidad());
        }
        
        System.out.println("--- Total pedido: " + totalEtiquetas + 
            " Etiquetas por un Importe total de: $" + sumaImportes);

    }
}

