/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tall.inc;

import java.util.Random;

/**
 *
 * @author timme
 */
public class Varudeklaration {

    public Varudeklaration() {
        skapaVaruDek();

    }

    public static String skapaVaruDek() {
        Random rnd = new Random();
        int nummer = rnd.nextInt(99999999);

        return String.format("%08d", nummer);
    }
    
    //public static void setVaruDek(){
       // Varudeklaration kod = new Varudeklaration();
        
    //}
}
   //if(bestallning == utland){
   // skapaVaruDek();
   // }