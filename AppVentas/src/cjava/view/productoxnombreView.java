/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cjava.view;

import cjava.controller.ProductoBLL;
import cjava.entity.ProductoTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class productoxnombreView extends javax.swing.JInternalFrame {

  /**
   * Creates new form productoxnombreView
   */
  public productoxnombreView() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txtnombre = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblProducto = new javax.swing.JTable();
    btnCerrar = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    lblTotal = new javax.swing.JLabel();

    setTitle("CONSULTA DE PRODUCTOS POR NOMBRE");

    jLabel1.setText("Nomnbre Producto");

    txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        txtnombreKeyReleased(evt);
      }
    });

    tblProducto.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Codigo", "Nombre", "Categoria", "Precio", "Stock"
      }
    ));
    jScrollPane1.setViewportView(tblProducto);
    if (tblProducto.getColumnModel().getColumnCount() > 0) {
      tblProducto.getColumnModel().getColumn(0).setPreferredWidth(50);
      tblProducto.getColumnModel().getColumn(1).setPreferredWidth(200);
      tblProducto.getColumnModel().getColumn(2).setPreferredWidth(60);
      tblProducto.getColumnModel().getColumn(3).setPreferredWidth(50);
      tblProducto.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    btnCerrar.setText("Cerrar");
    btnCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCerrarActionPerformed(evt);
      }
    });

    jLabel2.setText("Total de Productos");

    lblTotal.setText("0");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(btnCerrar)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(lblTotal)))
        .addContainerGap(51, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

 private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
   this.dispose();
 }//GEN-LAST:event_btnCerrarActionPerformed

 private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
   listaProductos();
 }//GEN-LAST:event_txtnombreKeyReleased
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCerrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblTotal;
  private javax.swing.JTable tblProducto;
  private javax.swing.JTextField txtnombre;
  // End of variables declaration//GEN-END:variables
   // instanciar objeto de la clase ProductoBLL
  ProductoBLL obj = new ProductoBLL();

  private void listaProductos() {
    try {
      if (!"".equals(txtnombre.getText())) {
        List<ProductoTO> lista = obj.ProductoListar(txtnombre.getText(), 1);
        if (!lista.isEmpty()) {
          lblTotal.setText(lista.size() + "");
          verProductos(lista);
        } else {
          lblTotal.setText("0");
        }
      } else {
        DefaultTableModel tabla = (DefaultTableModel) tblProducto.getModel();
        tabla.setRowCount(0);
        lblTotal.setText("0");
      }
    } catch (Exception e) {
    }
  }

  private void verProductos(List<ProductoTO> lista) {
    // variabvle de tipo tabla
    DefaultTableModel tabla = (DefaultTableModel) tblProducto.getModel();
    tabla.setRowCount(0);
    for (ProductoTO x : lista) {
      Object[] pro = {x.getIdproducto(), x.getDescripcion(), x.getIdcategoria(), x.getPrecioventa(), x.getStock()};
      tabla.addRow(pro);//adiciona al control tabla
    }
  }

}
