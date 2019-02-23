package vista;
import modelo.Logica;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import modelo.Logica.*;

public class marca extends javax.swing.JFrame {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();
    public marca() {
        initComponents();
        String Titulos[]={"Nª","Marca"};
        dtm.setColumnIdentifiers(Titulos);
        tbmarca.setModel(dtm);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnver = new javax.swing.JButton();
        txtmarca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbmarca = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btngrabar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marca");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 50, 253));
        jLabel1.setText("Autos Premier");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 2, 11)); // NOI18N
        jLabel3.setText("El placer sobre ruedas... ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 480, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Marca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 2, 11), new java.awt.Color(4, 76, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Nimbus Roman No9 L", 3, 11)); // NOI18N
        jLabel6.setText("Código");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, -1));
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 70, -1));

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 70, 20));

        btnver.setText("Ver Lista");
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });
        jPanel1.add(btnver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 80, 20));
        jPanel1.add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 150, -1));

        jLabel7.setFont(new java.awt.Font("Nimbus Roman No9 L", 3, 11)); // NOI18N
        jLabel7.setText("Marca");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 470, 100));

        tbmarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbmarca);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 460, 110));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregar.setText("Agregar");
        jPanel2.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, 20));

        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        jPanel2.add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 20));

        btncancelar.setText("  Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 20));

        btneditar.setText("  Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        jPanel2.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 470, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String b;
        if (btnagregar.isEnabled()) {
            try {
                conn=Logica.Enlace(conn);
                rs=Logica.Enlmarca(rs);
                b=txtid.getText();
                boolean encuentra=false;
                String pos;
                while(rs.next()) {
                    if(b.equals(rs.getString(1))) {
                        txtmarca.setText((String)rs.getString(2));
                        txtid.setEnabled(false);
                        encuentra=true;
                        break;
                    }
                }
                if(encuentra==false) {
                    txtid.setText("No existe");
                    txtid.requestFocus();
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,"Error BD"+ e.getMessage());
            }
        }        // TODO add your handling code here:
}//GEN-LAST:event_btnbuscarActionPerformed

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
        try {
            int f, i;
            conn=Logica.Enlace(conn);
            rs=Logica.Enlmarca(rs);
            String datos[]=new String[2];
            f=dtm.getRowCount();
            if(f>0)
                for(i=0;i<f;i++)
                    dtm.removeRow(0);
            while(rs.next()) {
                datos[0]=(String)rs.getString(1);
                datos[1]=(String)rs.getString(2);
                dtm.addRow(datos);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error en BD "+e.toString());
        }        // TODO add your handling code here:
}//GEN-LAST:event_btnverActionPerformed

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        
             
                                        int resp;
                                        resp = JOptionPane.showConfirmDialog(null, "¿Desea Grabar el Registro?", "Pregunta", 0);
                                        if (resp == 0) {
                                            try {
                                                conn = Logica.Enlace(conn);
                                                st = Logica.sta(st);
                                                rs = Logica.Enlmarca(rs);
                                                String m;
                                                m = txtmarca.getText();

                                                PreparedStatement graba = conn.prepareStatement("{call graba_marca(?)}");

                                                graba.setString(1, m);
                                                graba.executeUpdate();

                                                conn.close();                                                
                                                txtid.setEnabled(true);
                                            } catch (SQLException e) {
                                                JOptionPane.showMessageDialog(null, "Error en BD" + e.toString());
                                            }
                                        }                    // TODO add your handling code here:
                                    
        
}//GEN-LAST:event_btngrabarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        int resp;
        resp=JOptionPane.showConfirmDialog(null,"¿Desea Cancelar el Proceso?","Pregunta", 0);
      /*  if(resp==0) {
            limpiar();
            txtcodigo.setEnabled(true);
            activabotones(true,false,false,false);
            cajastexto(false,false,false,false,false,false,false);
        }*/            // TODO add your handling code here:
}//GEN-LAST:event_btncancelarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        int resp;
        resp=JOptionPane.showConfirmDialog(null,"¿Desea Modificar los Datos?","Pregunta", 0);
        if (resp==0) {
            try {
                conn=Logica.Enlace(conn);
                st=Logica.sta(st);
                rs=Logica.Enlmarca(rs);

                String  mar;
                int cod;
                cod=Integer.parseInt(txtid.getText());
                mar=txtmarca.getText();

                PreparedStatement modifica=conn.prepareStatement("{call edit_marca(?,?)}");
                modifica.setInt(1, cod);
                modifica.setString(2, mar);
                
                modifica.executeUpdate();

                conn.close();
                
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,"Error en BD"+ e.toString());
            }}                      // TODO add your handling code here:
}//GEN-LAST:event_btneditarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new marca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbmarca;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmarca;
    // End of variables declaration//GEN-END:variables

}