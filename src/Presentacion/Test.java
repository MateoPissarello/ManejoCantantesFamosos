package Presentacion;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

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

        modificarButton.addActionListener(this);
        eliminarButton.addActionListener(this);
        agregarButton.addActionListener(this);
        ordenarButton.addActionListener(this);
        mainTbl.getSelectionModel().addListSelectionListener(this);
    }
}
