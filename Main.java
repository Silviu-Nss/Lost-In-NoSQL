import java.util.ArrayList;

/**
 *
 * @author Nastasescu George-Silviu, 321CB
 */
public class Main
{  

    /**
     *
     * @param args - fisierul de input
     */
    public static void main(String[] args) {
        Reader Rd = new Reader(args[0]);
        ArrayList comenzi = Rd.read();
        DBManager DBM = new DBManager(comenzi, args[0] + "_out");
        DBM.ruleaza();
    }
}
