import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Silviu
 */
public class Instanta implements Comparable<Instanta> {
    private final String nume;
    private final LinkedHashMap<String, Atribut> atr;
    private Atribut cheie;
    private long timeStamp;
  
    /**
     *
     * @param nume - numele instantei
     */
    public Instanta(String nume) {
        this.nume = nume;
        atr = new LinkedHashMap();
        setTimeStamp();
    }
  
    /**
     * seteaza noul timeStamp
     */
    public void setTimeStamp() {
        timeStamp = System.nanoTime();
    }
  
    /**
     *
     * @param timeStamp - seteaza noul timeStamp la unul precizat
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
  
    /**
     *
     * @param tipCheie - cheia corespunzatoare
     * @param tipAtr - tipul atributului : Float/Integer/String
     * @param val - valoarea precizata
     */
    public void setAtr(String tipCheie, String tipAtr, String val) {
        Atribut at;
        switch (tipAtr) {
            case "Integer":
                at = new AtrInt(tipAtr, val);
                break;
            case "Float":
                at = new AtrFloat(tipAtr, val);
                break;
            default:
                at = new AtrString(tipAtr, val);
                break;
        }
        if (cheie == null)
            cheie = at;
        atr.put(tipCheie, at);
    }
  
    /**
     *
     * @param atribut - atributul ce trebuie schimbat
     * @param val - noua valoare
     */
    public void updateAtr(String atribut, String val) {
        Atribut at = (Atribut)atr.get(atribut); 
        at.update(val);
    }
    
    /**
     *
     * @param eminescu - fisierul de output si cel mai mare poet roman
     * se considera ca munca lui a fost furata de catre Einstein
     * link : https://www.youtube.com/watch?v=M5b04SGziGU
     */  
    void print(Writer eminescu) {
        String str = nume; 
        for (Map.Entry intrare : atr.entrySet())
            str = str + " " + (String)intrare.getKey() + ":" + 
                 ((Atribut)intrare.getValue()).toString();
        eminescu.writeLine(str);
  }
  
    /**
     *
     * @return = cheia instantei
     */
    public Atribut getCheie() {
        return cheie;
    }
  
    /**
     *
     * @return = numele instantei
     */
    public String getNume() {
        return nume;
    }
  
    /**
     *
     * @return = timeStamp-ul instantei
     */
    public long getTimeStamp() {
        return timeStamp;
    }
  
    @Override
    public int compareTo(Instanta ins) {
        if (timeStamp > ins.getTimeStamp())
            return -1;
        if (timeStamp < ins.getTimeStamp())
            return 1;
        return 0;
    }
}
