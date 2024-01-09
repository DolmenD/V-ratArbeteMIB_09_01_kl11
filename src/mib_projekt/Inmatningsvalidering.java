/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mib_projekt;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author David, William
 */

//Denna klass är enligt kravspecifikationen fristående och syftar till att validera användarinmatningen.
//Detta är om vi ska använda if(Inmatningsvalidering.vardeInmatat(jtxtAlien)
//                                  try{
// Annars kan vi göra enskilda valideringar för vardera klass, vi får bestämma det
public class Inmatningsvalidering {
     
    // Metoden för att validera om textfältet är tomt
    public static boolean textValidering(JTextField Varde){
        
        //Om sann forsätter metoden
        boolean inmatat1 = true;
        if(Varde.getText().isEmpty()){
            //Om varde inte lagts in visas detta och metoden forsätter inte:
            JOptionPane.showMessageDialog(null, "Någon/några ifyllnings rutor saknar värden");
            Varde.requestFocus();
            inmatat1  = false;
            
        }
        // Returnerar det inmatade värdet.
        return inmatat1;
    }
    //Metod för att validera att det faktiskt är en epost
    public static boolean emailValidering(JTextField Varde){
        boolean inmatat2 = false;
        //Gör om textfältet till en string
        String text = Varde.getText();
        //Kollar först om den är tom
        if(textValidering(Varde)){
            //Kollar ifall man använder sig utav @
            if(text.contains("@")){
               inmatat2 = true; 
            }
            else{
                JOptionPane.showMessageDialog(null, "För att det ska räknas som email behövs ett @");
                Varde.requestFocus();
            }
        }
        System.out.println(inmatat2);
        return inmatat2;        
    }
    
    //Metod för att validera att det är ett telefon nummer
    public static boolean telefonValidering(JTextField Varde){
        boolean inmatat3 = false;
        String text = Varde.getText();
        //Kollar om den är tom
        if(textValidering(Varde)){
            //Kollar så att det endast är minustecken och siffror
          if(text.matches("[0-9-]*")){
              inmatat3 = true;
          }
          else{
              JOptionPane.showMessageDialog(null, "Ett telefonnummer får endast innehålla siffror och -");
          }
        }
        return inmatat3;
    }
    
    
    
    
    
    
}

