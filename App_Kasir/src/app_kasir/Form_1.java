/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app_kasir;


/**
 *
 * @author ariya
 */
public class Form_1 extends javax.swing.JFrame {

    /**
     * Creates new form Form_1
     */
    public Form_1() {
        initComponents();
 
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
        Logo = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        InputUsername = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        InputPassword = new javax.swing.JPasswordField();
        Image2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon("D:\\Koding-Tugas-Kampus\\App_Kasir\\src\\img\\2.png")); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 52, -1, -1));

        Username.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setText("Username");
        Username.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 311, 90, -1));

        InputUsername.setForeground(new java.awt.Color(102, 102, 102));
        InputUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InputUsername.setText(" Enter Username");
        InputUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InputUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InputUsernameFocusGained(evt);
            }
        });
        InputUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(InputUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 340, 240, 30));

        Password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password");
        Password.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 390, 90, -1));

        InputPassword.setText("jPasswordField1");
        InputPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InputPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InputPasswordFocusGained(evt);
            }
        });
        jPanel1.add(InputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 418, 240, 30));

        Image2.setIcon(new javax.swing.ImageIcon("D:\\Koding-Tugas-Kampus\\App_Kasir\\src\\img\\menu.png")); // NOI18N
        jPanel1.add(Image2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon("D:\\Koding-Tugas-Kampus\\App_Kasir\\src\\img\\1.png")); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUsernameActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_InputUsernameActionPerformed

    private void InputUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputUsernameFocusGained
        // TODO add your handling code here:
        InputUsername.setText("");
    }//GEN-LAST:event_InputUsernameFocusGained

    private void InputPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputPasswordFocusGained
        // TODO add your handling code here:
        InputPassword.setText("");
    }//GEN-LAST:event_InputPasswordFocusGained

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
            java.util.logging.Logger.getLogger(Form_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Image2;
    private javax.swing.JPasswordField InputPassword;
    private javax.swing.JTextField InputUsername;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
