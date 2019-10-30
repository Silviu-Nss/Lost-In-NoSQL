import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Silviu
 */
public class Entitate
{
    private final String nume;
    private final int RF;
    private final int nrAtr;
    private final LinkedHashMap<String, String> atr;
  
    /**
     *
     * @param nume - numele entitatii
     * @param RF - factorul de replicare
     * @param nrAtr - numarul de atribute
     */
    public Entitate(String nume, int RF, int nrAtr)
    {
        this.nume = nume;
        this.RF = RF;
        this.nrAtr = nrAtr;
        atr = new LinkedHashMap();
    }
  
    /**
     *
     * @param tipCheie - cheia corespunzatoare
     * @param tipAtr - tipul atributului : Float/Integer/String
     */
    public void createAtr(String tipCheie, String tipAtr) {
        atr.put(tipCheie, tipAtr);
    }
  
    /**
     *
     * @return = atributele entitatii
     */
    public HashMap<String, String> getAtr() {
        return atr;
    }
  
    /**
     *
     * @return = factorul de replicare
     */
    public int getRF() {
        return RF;
    }
}