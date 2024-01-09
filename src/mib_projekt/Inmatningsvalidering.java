/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mib_projekt;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author David
 */

//Denna klass är enligt kravspecifikationen fristående och syftar till att validera användarinmatningen.
//Detta är om vi ska använda if(Inmatningsvalidering.vardeInmatat(jtxtAlien)
//                                  try{
// Annars kan vi göra enskilda valideringar för vardera klass, vi får bestämma det
public class Inmatningsvalidering {
    
    // Metoden för att validera om värde inmatats
    public static boolean vardeInmatat(JTextField Varde){
        
        //Om sann forsätter metoden
        boolean inmatat = true;
        if(Varde.getText().isEmpty()){
            System.out.println("funkar hit");
            //Om varde inte lagts in visas detta och metoden forsätter inte:
            JOptionPane.showMessageDialog(null, "Någon/några ifyllnings rutor saknar värden");
            inmatat  = false;
            
        }
        // Returnerar det inmatade värdet.
        return inmatat;
    }
}
