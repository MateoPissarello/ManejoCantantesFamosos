package Presentacion;

import Dominio.CantanteFamoso;
import Dominio.ListaCantantesFamosos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test extends JFrame implements ActionListener, ListSelectionListener {
    private JTable mainTbl;
    private JTextField nombreTxt;
    private JPanel tablePnl;
    private JLabel cantantesLbl;
    private JPanel nombreTxtPanel;
    private JPanel discoMasVendidoTxtPanel;
    private JTextField discoTxt;
    private JPanel mainPnl;
    private JPanel inputsPnl;
    private JPanel buttonsPnl;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JPanel ventasPnl;
    private JTextField ventasTxt;
    private ListaCantantesFamosos listaCantantesFamosos = new ListaCantantesFamosos();

    public Test() {
        setContentPane(mainPnl);
        setSize(500, 500);
        setLocationRelativeTo(null);
        this.setTitle("Cantantes Famosos");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        modificarButton.setEnabled(false);
        eliminarButton.setEnabled(false);
        agregarButton.setEnabled(false);
        ordenarButton.setEnabled(false);
        modificarButton.addActionListener(this);
        eliminarButton.addActionListener(this);
        agregarButton.addActionListener(this);
        ordenarButton.addActionListener(this);
        mainTbl.getSelectionModel().addListSelectionListener(this);
        load();
        createTable();
        loadTable();
        addCantanteFamoso();
    }

    public void addCantanteFamoso() {
        boolean seguir = true;
        while (seguir) {
            int option = JOptionPane.showConfirmDialog(null, "¿Desea agregar un cantante famoso?", "Agregar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cantante famoso");
                String disco = JOptionPane.showInputDialog("Ingrese el disco más vendido del cantante famoso");
                int ventas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de ventas del disco"));
                CantanteFamoso cantanteFamoso = new CantanteFamoso(nombre, disco, ventas);
                listaCantantesFamosos.agregarCantanteFamoso(cantanteFamoso);
                loadTable();
            } else {
                seguir = false;
            }

        }
        if (listaCantantesFamosos.getListaCantantesFamosos().size() > 0) {
            ordenarButton.setEnabled(true);
        }
        if (agregarButton.isEnabled() == false) {
            agregarButton.setEnabled(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            addCantanteFamoso();
        }
        if (e.getSource() == modificarButton) {
            String nombre = nombreTxt.getText();
            String disco = discoTxt.getText();
            int ventas = Integer.parseInt(ventasTxt.getText());
            listaCantantesFamosos.modificarCantanteFamoso(nombre, disco, ventas);
            loadTable();
        }
        if (e.getSource() == ordenarButton){
            ordenar();
        }
        if (e.getSource() == eliminarButton) {
            String nombre = nombreTxt.getText();
            listaCantantesFamosos.eliminarCantanteFamoso(nombre);
            loadTable();
        }


    }
    private void ordenar() {
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.setRowCount(0);

        List<CantanteFamoso> cantantes = new ArrayList<>(listaCantantesFamosos.getListaCantantesFamosos());

        // Ordenar la lista de cantantes por número de ventas del disco
        cantantes.sort(Comparator.comparingInt(CantanteFamoso::getVentas).reversed());

        for (CantanteFamoso cantanteFamoso : cantantes) {
            model.addRow(new Object[]{cantanteFamoso.getNombre(), cantanteFamoso.getDiscoConMasVentas(), cantanteFamoso.getVentas()});
        }
    }

    private void createTable() {
        DefaultTableModel model = new DefaultTableModel(null, new String[]{"Cantante", "Disco Más Vendido", "Ventas"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        mainTbl.setModel(model);
    }

    public void loadTable() {
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.setRowCount(0);

        Iterator<CantanteFamoso> iterator = listaCantantesFamosos.getListaCantantesFamosos().iterator();
        while(iterator.hasNext()) {
            CantanteFamoso cantanteFamoso = iterator.next();
            model.addRow(new Object[]{cantanteFamoso.getNombre(), cantanteFamoso.getDiscoConMasVentas(), cantanteFamoso.getVentas()});
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (mainTbl.getSelectedRow() != -1) {
                nombreTxt.setText(mainTbl.getValueAt(mainTbl.getSelectedRow(), 0).toString());
                discoTxt.setText(mainTbl.getValueAt(mainTbl.getSelectedRow(), 1).toString());
                ventasTxt.setText(mainTbl.getValueAt(mainTbl.getSelectedRow(), 2).toString());
                modificarButton.setEnabled(true);
                eliminarButton.setEnabled(true);
            } else {
                modificarButton.setEnabled(false);
                eliminarButton.setEnabled(false);
            }
        }

    }
    public void load(){
        CantanteFamoso cantanteFamoso1 = new CantanteFamoso("Michael Jackson", "Thriller", 110000000);
        listaCantantesFamosos.agregarCantanteFamoso(cantanteFamoso1);
        CantanteFamoso cantanteFamoso2 = new CantanteFamoso("Madonna", "The Immaculate Collection", 64000000);
        listaCantantesFamosos.agregarCantanteFamoso(cantanteFamoso2);
    }
}
