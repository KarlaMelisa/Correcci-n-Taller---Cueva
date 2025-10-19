import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane TabbedPane;
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JTextField txtCantidad;
    private JLabel lblCantidad;
    private JLabel lblPelícula;
    private JComboBox cbPelicula;
    private JButton btnComprar;
    private JButton btnLimpiar;
    private JPanel paneComprar;
    private JPanel main;
    private JTextArea txtInfo;
    private JPanel paneInfo;
    private JLabel lblPelicula;
    private JLabel lblMARIO;
    private JLabel lblXMEN;
    private JLabel lblXmen;
    private JLabel lblMario;
    private JLabel lblBatman;
    private JLabel lblTotal;
    private JLabel lblLabel;
    private JLabel lblAsientosComprados;
    private JLabel lblCompradoXmen;
    private JLabel lblAsientosDisponibles;
    private JLabel lblBATMAN;
    private JLabel lblCompradoMario;
    private JLabel lblCompradoBatman;
    private JLabel lblInfo;

    private ColaCompras colaCompras = new ColaCompras();
    private final double[] precio = {2.25, 3.25, 3.75};
    private final int[] sillas = {23, 23, 23};
    private final int[] comprados = {0, 0, 0};
    double contador = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());
                String pelicula = (String) cbPelicula.getSelectedItem();
                int index = cbPelicula.getSelectedIndex();

                Compra compra = new Compra(nombre, cantidad, pelicula, precio[index - 1]);
                if (cantidad > 0 && cantidad<=4) {
                    if (sillas[index - 1 ] >= cantidad && sillas[index - 1] > 0) {
                        colaCompras.agregarCompra(compra);
                        sillas[index - 1] -= cantidad;
                        comprados[index - 1] += cantidad;
                        txtInfo.setText(colaCompras.toString());
                        txtNombre.setText("");
                        txtCantidad.setText("");
                        lblXmen.setText(Integer.toString(sillas[0]));
                        lblMario.setText(Integer.toString(sillas[1]));
                        lblBatman.setText(Integer.toString(sillas[2]));
                        lblCompradoXmen.setText(Integer.toString(comprados[0]));
                        lblCompradoMario.setText(Integer.toString(comprados[1]));
                        lblCompradoBatman.setText(Integer.toString(comprados[2]));
                        cbPelicula.setSelectedIndex(0);
                        contador += compra.getPrecio();
                        lblTotal.setText(Double.toString(contador));
                        lblLabel.setText("Compra realizada con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay sillas disponibles");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad de entradas debe ser entre 1 y 4");
                }

            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtCantidad.setText("");
                cbPelicula.setSelectedIndex(0);
            }
        });
    }
}