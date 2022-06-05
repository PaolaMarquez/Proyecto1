/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import javax.swing.JOptionPane;

/**
 * Esta clase maneja todas las funcionalidades de la ventana 4, que se encarga de tomar los datos del usuario para añadir un nuevo almacén
 * @author abril
 * @author paola
 */
public class Ventana4 extends javax.swing.JFrame {
    
    /**
     * Constructor para la ventana 4
     */
    public Ventana4() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        route2Input = new javax.swing.JTextField();
        nameInput = new javax.swing.JTextField();
        route1Input = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("NUEVO ALMACÉN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Ingrese el segundo camino del almacén: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nombre del almacén (ej. A) ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Ingrese el primer camino del almacén: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        route2Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                route2InputActionPerformed(evt);
            }
        });
        jPanel1.add(route2Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 110, -1));

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });
        jPanel1.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 110, -1));

        route1Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                route1InputActionPerformed(evt);
            }
        });
        jPanel1.add(route1Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 110, -1));

        jLabel5.setText("IMPORTANTE: Los caminos deben ser registrados de la siguiente manera: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 370, 30));

        jLabel6.setText(" (Entrada, Salida, Peso), por ejemplo: (A,B,8)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void route2InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_route2InputActionPerformed
        route2Input.setText(" ");

    }//GEN-LAST:event_route2InputActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        nameInput.setText(" ");;
    }//GEN-LAST:event_nameInputActionPerformed

    private void route1InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_route1InputActionPerformed
        route1Input.setText(" ");
    }//GEN-LAST:event_route1InputActionPerformed

    //
    /**
     * Este botón guarda la informacion del almacén y lo crea si cumple con los requisitos
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = nameInput.getText().toUpperCase();
        String route1 = route1Input.getText();
        String route2 = route2Input.getText();
        
        String[] n = name.split(" ");
        if(Validation.route(route1) && Validation.route(route2)){
            if(!name.isEmpty() && n.length == 1){
                Boolean r1 = Validation.VerifyRoutes(route1, name);
                Boolean r2 = Validation.VerifyRoutes(route2, name);
                if(r1 && r2){
                    List<Product> p = new List();
                    Storage s = new Storage(name, p);
                    Global.getGrafo().addVertice(s, route1, route2);
                    JOptionPane.showMessageDialog(null,"Se agregaron las rutas exitosamente"); 
                }else{
                    JOptionPane.showMessageDialog(null,"Las rutas son incorrectas"); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error! Poner solo el nombre del almacen"); 
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField route1Input;
    private javax.swing.JTextField route2Input;
    // End of variables declaration//GEN-END:variables
}
