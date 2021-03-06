/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sehs.INTERFACES;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sehs.DAO.UsuarioDAO;
import sehs.DTO.UsuarioTO;
import sehs.UTIL.CifradoMD5;
/**
 *
 * @author SEHS - TI
 */
public class LoginF extends javax.swing.JFrame {

    /**
     * Creates new form LoginBD
     */
    public LoginF() {
        initComponents();
        setLocationRelativeTo(null);
        Image icon3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagenes/logo_sehs.png"));
        setIconImage(icon3);
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
        jtextUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        JTextPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtextUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtextUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtextUsuarioFocusLost(evt);
            }
        });
        jtextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextUsuarioKeyPressed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        btnAceptar.setText("Ingresar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        JTextPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTextPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextPassFocusLost(evt);
            }
        });
        JTextPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTextPassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(190, 190, 190))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAceptar)
                                .addComponent(JTextPass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(444, Short.MAX_VALUE)
                    .addComponent(jtextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTextPass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jtextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(289, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            btnAceptar.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_jtextUsuarioKeyPressed

    private void JTextPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextPassKeyPressed
        // TODO add your handling code here:
           if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            btnAceptar.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_JTextPassKeyPressed

    private void jtextUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextUsuarioFocusGained
        // TODO add your handling code here:
           if(jtextUsuario.getText().equals("usuario")){
            jtextUsuario.setText("");
        }
    }//GEN-LAST:event_jtextUsuarioFocusGained

    private void JTextPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextPassFocusGained
        // TODO add your handling code here:
        if(new String(JTextPass.getPassword()).equals("clave")){
            jtextUsuario.setText("");
        }
    }//GEN-LAST:event_JTextPassFocusGained

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
          if(jtextUsuario.getText().length()>0 && (new String(JTextPass.getPassword())).length()>0){
              UsuarioDAO  newUser = new UsuarioDAO();
            UsuarioTO user;
            user = newUser.validateUser(jtextUsuario.getText().toLowerCase(), (new String(JTextPass.getPassword())));
            if(!user.getUsuario().equals("")){
               MenuPrincipal nueModi = new MenuPrincipal(this, user);
                this.setVisible(false);
                /*Se envia el objeto login para regresar en caso de cerrar sesión, y se
                envía el objeto usuario, que contiene toda la información del usuario*/
              nueModi.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Rellena todos los campos.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jtextUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextUsuarioFocusLost
      
        if(jtextUsuario.getText().equals("")){
            jtextUsuario.setText("nick");
        }
    }//GEN-LAST:event_jtextUsuarioFocusLost

    private void JTextPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextPassFocusLost
       
         if(new String(JTextPass.getPassword()).equals("")){
            JTextPass.setText("passwd");
        }
    }//GEN-LAST:event_JTextPassFocusLost

    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JTextPass;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtextUsuario;
    // End of variables declaration//GEN-END:variables
}
