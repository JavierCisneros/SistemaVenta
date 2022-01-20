/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.CompraDB;
import modelo.VentaDB;

/**
 *
 * @author yopri
 */
public class DetalleVenta extends javax.swing.JFrame {

    /**
     * Creates new form DetalleVenta
     */
    DefaultTableModel modelo = new DefaultTableModel();
    VentaDB vdb = new VentaDB();
    CompraDB cdb = new CompraDB();
    public DetalleVenta(String id, String fecha, String total,String vendedor, int tipo) {
        initComponents();
        lblVenta.setText(id);
        lblFecha.setText(fecha);
        lblTotal.setText(total);
        lblVendedor.setText(vendedor);
        setSize(900, 450);
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        setLocation((d.width-getSize().width)/2,(d.height-getSize().height)/2);
         setIconImage(new ImageIcon(getClass().getResource("/img/candy16.png")).getImage());
        if(tipo==0){
         ListarVenta(id);
        }
        if(tipo==1){
        ListarCompra(id);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblVenta = new javax.swing.JTextField();
        lblFecha = new javax.swing.JTextField();
        lblTotal = new javax.swing.JTextField();
        lblVendedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Venta numero:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtVentas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 810, 280));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnMenu.setText("Regresar");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Vendedor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        lblVenta.setEditable(false);
        getContentPane().add(lblVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

        lblFecha.setEditable(false);
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 170, -1));

        lblTotal.setEditable(false);
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 170, -1));

        lblVendedor.setEditable(false);
        getContentPane().add(lblVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleVenta(null,null,null,null,0).setVisible(true);
            }
        });
    }
    private void ListarVenta(String id){
        ArrayList<modelo.DetalleVenta> ListaDV = vdb.BuscarDV(id);
     modelo = (DefaultTableModel) jtVentas.getModel();
    Object[] ob = new Object[5];
        for (int i = 0; i < ListaDV.size(); i++) {

            ob[0] = ListaDV.get(i).getCdproducto();
            ob[1] = ListaDV.get(i).getNombre();
            ob[2] = ListaDV.get(i).getCantidad();
            ob[3] = ListaDV.get(i).getPrecio();
            ob[4] = ListaDV.get(i).getSubtotal();
            modelo.addRow(ob);
        }
        jtVentas.setModel(modelo);
    }
        private void ListarCompra(String id){
        ArrayList<modelo.DetalleCompra> ListaDV = cdb.BuscarDC(id);
     modelo = (DefaultTableModel) jtVentas.getModel();
    Object[] ob = new Object[5];
        for (int i = 0; i < ListaDV.size(); i++) {

            ob[0] = ListaDV.get(i).getCdproducto();
            ob[1] = ListaDV.get(i).getNombre();
            ob[2] = ListaDV.get(i).getCantidad();
            ob[3] = ListaDV.get(i).getPrecio();
            ob[4] = ListaDV.get(i).getSubtotal();
            modelo.addRow(ob);
        }
        jtVentas.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtVentas;
    private javax.swing.JTextField lblFecha;
    private javax.swing.JTextField lblTotal;
    private javax.swing.JTextField lblVendedor;
    private javax.swing.JTextField lblVenta;
    // End of variables declaration//GEN-END:variables
}
