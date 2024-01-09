/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib_projekt;

import oru.inf.InfDB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import oru.inf.InfException;


/**
 *
 * @author David
 */
public class InfoAllAlien extends javax.swing.JFrame {
    private InfDB idb;
    private String Tidigare;
    /**
     * Creates new form InfoAllAlien
     */
    public InfoAllAlien(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllAlienNamn();
    }
    public InfoAllAlien(InfDB idb, String Tidigare) {
        initComponents();
        this.idb = idb;
        this.Tidigare = Tidigare;
        fyllAlienNamn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        ListAllInformationAlien = new javax.swing.JList<>();
        jlSokAlien = new javax.swing.JLabel();
        jlSokMedAlienID = new javax.swing.JLabel();
        btnBekraftaSokning = new javax.swing.JButton();
        lblFelmeddelande = new javax.swing.JLabel();
        cbtnAlienNamn = new javax.swing.JComboBox<>();
        btnTillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListAllInformationAlien.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Alien_ID", "Registreringsdatum", "Epost", "Losenord", "Namn", "Telefon", "Plats", "Ansvarig_Agent" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListAllInformationAlien);

        jlSokAlien.setText("Sökfunktion Alien");

        jlSokMedAlienID.setText("Sök med AlienID");

        btnBekraftaSokning.setText("Bekräfta Sökning");
        btnBekraftaSokning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBekraftaSokningActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBekraftaSokning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlSokAlien)
                                .addComponent(jlSokMedAlienID)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnTillbaka)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblFelmeddelande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(cbtnAlienNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlSokAlien)
                        .addGap(18, 18, 18)
                        .addComponent(jlSokMedAlienID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbtnAlienNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBekraftaSokning)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblFelmeddelande))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnTillbaka)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fyllAlienNamn(){
        try {
            String fraga = "SELECT Alien_ID, Namn FROM alien;";
            //Vi använder oss av var variabeln som automatiskt känner av vilken datatyp det är
            var resultat = idb.fetchRows(fraga);

            // Iterera över varje rad i resultatet
            for (HashMap<String, String> rad : resultat) {
                //Hämtar ut namn och id där namnet sedan läggs till i cb
                String AlienIdStr = rad.get("Alien_ID");
                String AlienNamn = rad.get("Namn");

                if (AlienIdStr != null) {
                    cbtnAlienNamn.addItem(AlienNamn);
                }
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    
    private void btnBekraftaSokningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaSokningActionPerformed
        // TODO add your handling code here:
        String valtAlienNamn = (String) cbtnAlienNamn.getSelectedItem();
        
        
        try {
            // SQL-fråga för att hämta Alien_ID baserat på namnet
            String fraga = "SELECT Alien_ID FROM Alien WHERE Namn = '" + valtAlienNamn + "'";
            var resultat = idb.fetchSingle(fraga);

                String Fraga = "SELECT Alien_ID, Registreringsdatum, Epost, Losenord, Namn , Telefon, Plats, Ansvarig_Agent FROM alien WHERE Alien_ID = " + resultat + "";
                
                ArrayList<HashMap<String, String>> alienInfoLista;
                alienInfoLista = idb.fetchRows(Fraga);
                System.out.println("valtAlienNamn: " + valtAlienNamn);
                //Skriver ut all info om alien
                DefaultListModel<String> alientLista = new DefaultListModel<>();
                for (HashMap<String, String> enAlien : alienInfoLista) {
                    alientLista.addElement("Alien_ID: " + enAlien.get("Alien_ID"));
                    alientLista.addElement("Registreringsdatum: " + enAlien.get("Registreringsdatum"));
                    alientLista.addElement("Epost: " + enAlien.get ("Epost"));
                    alientLista.addElement("Losenord: " + enAlien.get("Losenord"));
                    alientLista.addElement("Namn: " + enAlien.get("Namn"));
                    alientLista.addElement("Telefon: " + enAlien.get("Telefon"));
                    alientLista.addElement("Plats: " + enAlien.get("Plats"));
                    alientLista.addElement("Ansvarig_Agent: " + enAlien.get("Ansvarig_Agent"));
                }

                ListAllInformationAlien.setModel(alientLista);
                ListAllInformationAlien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            } catch (InfException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Något gick inte som planerat:" + e.getMessage());
                e.printStackTrace();

            }
    }//GEN-LAST:event_btnBekraftaSokningActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        if(Tidigare.equals("ADMIN")){
            EfterInloggAdmin nytt = new EfterInloggAdmin();
            InfoAllAlien.this.setVisible(false);
            nytt.setVisible(true);
        }
        else{
            EfterInlogg nytt = new EfterInlogg();
            InfoAllAlien.this.setVisible(false);
            nytt.setVisible(true);
        }
    }//GEN-LAST:event_btnTillbakaActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoAllAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        try{
            InfDB idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            InfoAllAlien alienFrame = new InfoAllAlien(idb); 
            
        
            alienFrame.setSize(551, 301);
            alienFrame.setVisible(true);
        } catch (InfException Fel) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande: " + Fel.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListAllInformationAlien;
    private javax.swing.JButton btnBekraftaSokning;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> cbtnAlienNamn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlSokAlien;
    private javax.swing.JLabel jlSokMedAlienID;
    private javax.swing.JLabel lblFelmeddelande;
    // End of variables declaration//GEN-END:variables
}
