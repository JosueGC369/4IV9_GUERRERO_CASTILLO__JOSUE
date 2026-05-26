import javax.swing.JFrame;
import javax.swing.*;



public class Ventana {
    
    public static void main(String[] args){

        //vamos a realizar un ejemplo de interfaz

        JFrame ventana = new JFrame();
        //hay que definir el tamaño de la ventana
        ventana.setSize(400, 160);
        //definir las acciones de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //dentro de la ventana
        JPanel panel = new JPanel();
        //el panel es donde uno va incorporando o agregando los componentes
        //tengo que decir que se debe de agregar a la ventana
        ventana.add(panel);

        //vamos a crear un metodo para agregar todos los componentes necesarios a esta ventana
        agregarComponente(panel);

        ventana.setVisible(true);

    }

    private static void agregarComponente(JPanel panel){

        //lo primero que se hace es inicializar el componente
        panel.setLayout(null);//esto significa que el panel se inicializa vacio
        //agregamos una etiqueta
        JLabel userlabel = new JLabel("Nombre de usuario: ");

        //para poderla agregar al panel tenemos que hacer uso de inicializar sus componentes internos, para ello utilizamos el metodo setBounds el cual utiliza 4 parametros x y, para las coordenadas w h para el tamaño
        userlabel.setBounds(10, 10, 120, 50);
        //lo agregamos al panel
        panel.add(userlabel);

        //agregamos un campo de texto
        JTextField usertext = new JTextField(20);
        usertext.setBounds(160, 10, 160, 25);
        panel.add(usertext);
    }
}