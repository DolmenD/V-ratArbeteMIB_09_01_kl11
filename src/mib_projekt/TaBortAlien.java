/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib_projekt;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author David
 */
public class TaBortAlien extends javax.swing.JFrame {
    private InfDB idb;
    /**
     * Creates new form TaBortAlien
     */
    public TaBortAlien(InfDB idb) {
        this.idb = idb;
        initComponents();
        AlienNamnScroll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cbtnAlienNamn = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTillbaka2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Ta bort Alien");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Välj Alien nedan:");

        jLabel2.setText("Ta bort Alien ur Systemet ");

        btnTillbaka2.setText("Tillbaka");
        btnTillbaka2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbaka2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbtnAlienNamn, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(btnTillbaka2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnTillbaka2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbtnAlienNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        //cb som hämtar alla aliens namn och deras id
       private void AlienNamnScroll(){
        try {
            String fraga = "SELECT Alien_ID, Namn FROM alien;";
            var resultat = idb.fetchRows(fraga);

            for (HashMap<String, String> rad : resultat) {
                String AlienIdStr = rad.get("Alien_ID");
                String AlienNamn = rad.get("Namn");

                if (AlienIdStr != null) {
                    // Lägger till alien namnet i dropdown-menyn
                    cbtnAlienNamn.addItem(AlienNamn);
                }
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String valtAlienNamn = (String) cbtnAlienNamn.getSelectedItem();
        try {
            String fraga = "SELECT Alien_ID FROM Alien WHERE Namn = '" + valtAlienNamn + "'";
            var alienID = idb.fetchSingle(fraga);
            
            if (alienID != null) {
                idb.delete("DELETE FROM Squid WHERE Alien_ID = " +  alienID);
                idb.delete("DELETE FROM Worm WHERE Alien_ID = " +  alienID);
                idb.delete("DELETE FROM Boglodite WHERE Alien_ID = " +  alienID);
                idb.delete("DELETE FROM Alien WHERE Alien_ID = " +  alienID);
                JOptionPane.showMessageDialog(null, valtAlienNamn + " har tagits bort");
            
            } else {
            JOptionPane.showMessageDialog(null,"Något gick fel");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Något gick fel med SQL-frågan!");
        System.out.println("Internt felmeddelande: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTillbaka2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbaka2ActionPerformed
        // TODO add your handling code here:
        EfterInloggAdmin nytt = new EfterInloggAdmin();
        TaBortAlien.this.setVisible(false);
        nytt.setVisible(true);
    }//GEN-LAST:event_btnTillbaka2ActionPerformed

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
            java.util.logging.Logger.getLogger(TaBortAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaBortAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaBortAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaBortAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

try{
            InfDB idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            TaBortAlien TaBortAlienFrame = new TaBortAlien(idb); 
            
        
            TaBortAlienFrame.setSize(551, 301);
            TaBortAlienFrame.setVisible(true);
        } catch (InfException Fel) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande: " + Fel.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTillbaka2;
    private javax.swing.JComboBox<String> cbtnAlienNamn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
