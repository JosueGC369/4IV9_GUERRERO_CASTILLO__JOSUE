/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author demon
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ProductoVista extends JFrame{
    
    /*
    la vista es la responsable de organizar graficamente
    los componentes, como son los campos de texto, botones,
    tablas, etc
    
    la vista no debe de conectarse con BD
    nunca ejecuta la logica de negocio
    */
    
    //tabla
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    
    //campos comunes
    private JTextField txtId, txtNombre, txtPrecio, txtCantidad, txtCategoria;
    private JComboBox<String> cmbTipoProducto;
    
    //botones
    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar, btnLimpiar;
    
    //panel
    private JPanel panelCamposEspecificos;
    private CardLayout cardLayout;
    
    //constructor
    public ProductoVista(){
        setTitle("Crud de Productos");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));
        
        //los elementos del panel
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(39,174, 96));
        
        //le agregamos componentes
        JLabel lblTitulo = new JLabel("Sistema de Gestión de Productos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.white);
        panelTitulo.add(lblTitulo);
        
        add(panelTitulo, BorderLayout.NORTH);
        
        //centremos la tabla de los productos
        modeloTabla = new DefaultTableModel(
                new String[]{
                    "ID", 
                    "Nombre",
                    "Precio",
                    "Cantidad",
                    "Categoria",
                    "Tipo"
                }, 0
        ){
            //tenemos que aplicar otra vez polimorfismo
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }      
        };
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setRowHeight(25);
        
        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.setPreferredSize(new Dimension(950, 250));
        add(scrollTabla, BorderLayout.CENTER);
        
        //el formulario y los botones
        JPanel panelinferior = new JPanel(new BorderLayout(5,5));
        panelinferior.setBorder(
                BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelinferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelinferior.add(crearPanelBotones(), BorderLayout.SOUTH);
        add(panelinferior, BorderLayout.SOUTH);
        
        
    }

    private Component crearPanelFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Component crearPanelBotones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}