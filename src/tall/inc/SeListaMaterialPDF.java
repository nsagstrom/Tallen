/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tall.inc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author noahjarvback
 */
public class SeListaMaterialPDF {
   
    
    public SeListaMaterialPDF(){
   
   
   }


    
private void skrivUtMaterialLista(){
String query = "Select BestID from Bestallning\n" +
"where Status = 'Öppen' or Status = 'Pågående'";
ArrayList<String> bestIDLista = SqlFragor.getEnKolumn(query);

for(String bestID : bestIDLista){
String query2 = "select Beskrivning, Tyg, Farg from Hatt\n" +
"join Tyg on Tyg.TygID = Hatt.TygID\n" +
"join Farg on Farg.FargID = Hatt.FargID\n" +
"join Orderrad on Orderrad.HattID = Hatt.HattID\n" +
"where BestID = '" + bestID + "'";
ArrayList<HashMap<String, String>> hattLista = SqlFragor.getFleraRader(query2);
for(HashMap<String,String> hattar : hattLista){
    hattar.get("Beskrivning");
    hattar.get("Tyg");
    hattar.get("Farg");
    
}

}



}
   
   } 
