import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Silviu
 */
public class Nod
{
    private final int index;
    private final int maxCap;
    private final TreeSet<Instanta> instante;
  
    /**
     *
     * @param index - indexul nodului
     * @param maxCap - capacitatea maxima a nodului
     */
    public Nod(int index, int maxCap) {
        this.index = index;
        this.maxCap = maxCap;
        instante = new TreeSet<Instanta>();
    }
  
    /**
     *
     * @param ins - instanta de adaugat in nod
     */
    public void insertInstanta(Instanta ins) {
        instante.add(ins);
    }
  
    /**
     *
     * @param nume - numele instantei cautate
     * @param cheie - cheia folosita la cautare
     * @return
     */
    public boolean delete(String nume, String cheie) {
        Instanta insCautata = null;
        for (Instanta ins : instante) {
            if ((ins.getNume().equals(nume)) && 
            (ins.getCheie().toString().equals(cheie))) {
                insCautata = ins; 
                break;
            }
        }
        if (insCautata == null)
            return false;
        instante.remove(insCautata);
        return true;
    }
  
    /**
     *
     * @param info - instanta cu noile informatii ale atributelor sale
     * @param timeStamp - noul timeStamp
     */
    public void update(String[] info, long timeStamp) {
        Instanta insCautata = null;
        for (Instanta ins : instante) {
            if ((ins.getNume().equals(info[1])) && 
            (ins.getCheie().toString().equals(info[2]))) {
                insCautata = ins;
                break;
            }
        }
        if (insCautata == null)
            return;
        instante.remove(insCautata);
        for (int i = 3; i < info.length; i += 2)
            insCautata.updateAtr(info[i], info[(i + 1)]);
        insCautata.setTimeStamp(timeStamp);
        instante.add(insCautata);
    }
  
    /**
     *
     * @param timeStamp - timeStamp-ul dupa care se face clean-ul
     */
    public void cleanNod(long timeStamp) {
        ArrayList pseudoNod = new ArrayList<Instanta>();
        Instanta ins;
        for (Iterator itr = instante.iterator(); itr.hasNext();) { 
            ins = (Instanta)itr.next();
            if (ins.getTimeStamp() < timeStamp)
                pseudoNod.add(ins);
        }
        for (Iterator itr = pseudoNod.iterator(); itr.hasNext();) { 
            ins = (Instanta)itr.next();
            instante.remove(ins);
        }
    }
  
    /**
     *
     * @return = indexul nodului
     */
    public int getIndex() {
        return index;
    }
  
    /**
     *
     * @return - numarul de instante din nod
     */
    public int getSize() {
        return instante.size();
  }
    
    /**
     *
     * @param arghezi - fisierul de output si scrie cu unghiile, saracu
     */
    void print(Writer arghezi) {
        arghezi.writeLine("Nod" + index);
        instante.forEach((ins) -> {
            ins.print(arghezi);
        });
    }
    
    /**
     * @param nume - numele instantei
     * @param cheie - cheia specifica instantei
     */
    Instanta getInstanta(String nume, String cheie) {
        for (Instanta ins : instante) {
            if ((ins.getNume().equals(nume)) && 
            (ins.getCheie().toString().equals(cheie)))
                return ins;
        }
        return null;
    }
}
