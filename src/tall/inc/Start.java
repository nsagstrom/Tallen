package tall.inc;


import tall.inc.SqlFragor;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;



/**
 *
 * @author Markus
 */
public class Start {
    
    private static InfDB idb;
    
    public static void main(String[] args) {
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //Anropar metoden i klassen SqlFragor f√∂r att tilldela referensen till databasen
        //Alla v√•ra SQL-fr√•gor behandlas av klassen SqlFragor
        SqlFragor.setDatabas(idb);
        
        //KOD F÷R ATT STARTA F÷NSTER HƒR
        JOptionPane.showMessageDialog(null, "hej");
        
    }
}
