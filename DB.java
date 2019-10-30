import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Silviu
 */
public class DB
{
    private final String nume;
    private int nrNoduri;
    private final int maxCap;
    private final ArrayList<Nod> noduri;
    private final HashMap<String, Entitate> entitati;
  
    /**
     *
     * @param nume - numele bazei de date
     * @param nrNoduri - numarul de noduri
     * @param maxCap - capacitatea maxima
     */
    public DB(String nume, int nrNoduri, int maxCap) {
        this.nume = nume;
        this.nrNoduri = nrNoduri;
        this.maxCap = maxCap;
        noduri = new ArrayList<Nod>();
        entitati = new HashMap<String, Entitate>();    
        for (int i = 0; i < nrNoduri; i++) {
            noduri.add(new Nod(i + 1, maxCap));
        }
    }
  
    /**
     *
     * @param info - informatiile cu care se creeaza o noua entitate
     */
    public void createEntitate(String[] info) {
        Entitate ent = new Entitate(info[1], Integer.parseInt(info[2]), 
                        Integer.parseInt(info[3]));
        for (int j = 4; j < info.length; j += 2) {
            ent.createAtr(info[j], info[(j + 1)]);
        }
        entitati.put(info[1], ent);
    }
    
    /**
     *
     * @param info - informatiile cu care se creeaza o noua instanta
     */ 
    private Instanta createInstanta(String[] info) {
        Entitate ent = entitati.get(info[1]);
        Instanta ins = new Instanta(info[1]);
        int i = 2;
        for (String str : ent.getAtr().keySet()) {
            ins.setAtr(str, ent.getAtr().get(str),info[i]);
            i++;
        }
        return ins;
    }
  
    /**
     *
     * @param info - informatiile cu care se creeaza o noua instanta
     */
    public void insertInstanta(String[] info) {
        Instanta ins = createInstanta(info);
        int i = (entitati.get(info[1])).getRF();
        for (Nod nod : noduri) {
            // Verificam daca mai avem de introdus instanta in noduri
            if (i == 0)
                break;
            // Verificam daca exista loc de inca o copie a instantei in nod
            if (nod.getSize() < maxCap) {
                nod.insertInstanta(ins);
                i--;
            }
        }
        // Verificam daca nu s-a introdus numarul necesar de copii ale instantei
        // Si adaugam noi noduri daca este nevoie
        if (i > 0) {
            for (int j = 0; j < i; j++) {
                noduri.add(new Nod(nrNoduri + j + 1, maxCap));
                (noduri.get(nrNoduri + j)).insertInstanta(ins);
            }
            nrNoduri += i;
        }
    }
  
    /**
     *
     * @param info - informatiile dupa care se sterge o instanta
     * @param caragiale - fisierul de output si cel mai mare dramaturg roman
     */
    public void deleteInstante(String[] info, Writer caragiale)
    {
        int i = 0;
        for (Nod nod : noduri) {
            if ((nod.getSize() > 0) && 
            (nod.delete(info[1], info[2])))
                i = 1;
        }
        if (i == 0)
            caragiale.writeLine("NO INSTANCE TO DELETE");     
    }
  
    /**
     *
     * @param info - instanta cu noile informatii ale atributelor sale
     */
    public void updateInstante(String[] info) {
        long timeStamp = System.nanoTime();
        noduri.stream().filter((nod) ->
        (nod.getSize() > 0)).forEachOrdered((nod) -> {
            nod.update(info, timeStamp);
        });
    }
  
    /**
     *
     * @param nume - numele bazei de date
     * @param timeStamp - timeStamp-ul dupa care se face clean-ul
     */
    public void cleanDB(String nume, long timeStamp) {
        noduri.stream().filter((nod) ->
        (nod.getSize() > 0)).forEachOrdered((nod) -> {
            nod.cleanNod(timeStamp);
        });
    }
  
    /**
     *
     *@param barbu - fisierul de output si numele sau real era de fapt Barbilian
     */
    public void snapshotDB(Writer barbu) {
        int i = 0;
        for (Nod nod : noduri) {
            if (nod.getSize() > 0)
                nod.print(barbu);
            else
                i++;
        }
        if (i == noduri.size())
            barbu.writeLine("EMPTY DB");
    }

    /**
     * @param nume - numele instantei
     * @param cheie - cheia specifica instantei
     * @param bacovia - fisierul de output si cam depresiv
     */
    void getInstanta(String nume, String cheie, Writer bacovia) {
        Instanta ins;
        Instanta insCautata = null;
        String str = new String();
        for (Nod nod : noduri) {
            ins = nod.getInstanta(nume, cheie);
            if (ins != null) {
                insCautata = ins;
                str = str + "Nod" + nod.getIndex() + " ";
            }
        }
        if (insCautata != null) {
            bacovia.write(str);
            insCautata.print(bacovia);
        }
        else
            bacovia.writeLine("NO INSTANCE FOUND");
    }
}