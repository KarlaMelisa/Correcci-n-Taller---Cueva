public class Compra {
    private String cliente;
    private int cantidadEntradas;
    private String pelicula;
    private double precio;


    public Compra(String cliente, int cantidadEntradas, String pelicula, double precio){
        this.cliente = cliente;
        this.cantidadEntradas = cantidadEntradas;
        this.pelicula = pelicula;
        this.precio = precio*cantidadEntradas;
    }

    public double getPrecio(){
        return precio;
    }

    @Override
    public String toString(){
        return cliente + " con " + cantidadEntradas + " entradas para la pelicula " + pelicula + ". Precio: " + precio + "\n";
    }
}
