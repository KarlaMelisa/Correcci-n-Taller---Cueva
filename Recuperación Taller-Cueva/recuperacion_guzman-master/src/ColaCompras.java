import java.util.LinkedList;
import java.util.Queue;

public class ColaCompras {
    private Queue<Compra> colaCompras;

    public ColaCompras(){
        colaCompras = new LinkedList<Compra>();
    }

    public void agregarCompra(Compra compra){
        colaCompras.add(compra);
    }

    public Compra sacarCompra(){
        return colaCompras.poll();
    }

    @Override
    public String toString() {
        return "La cola de compras es:\n" + colaCompras;
    }
}
