import java.util.ArrayList;

/**
 *
 * @author Silviu
 */
public class DBManager {
    private final ArrayList<String[]> comenzi;
    private final Writer creanga;
    private DB db;
  
    /**
     *
     * @param comenzi - comenzile de rulat
     * @param nica - numele fisierului de output si personajul principal din
     * "Amintiri din copilarie"
     */
    public DBManager(ArrayList<String[]> comenzi, String nica) {
        this.comenzi = comenzi;
        this.creanga = new Writer(nica);
    }
  
    /**
     * ruleaza comenzile date ca input
     */
    public void ruleaza() {
        for (int i = 0; i < comenzi.size(); i++) {
            String[] info = (String[])comenzi.get(i);
      
            switch (info[0]) {
                case "CREATEDB":
                    db = new DB(info[1], Integer.parseInt(info[2]),
                            Integer.parseInt(info[3]));
                    break;
                case "CREATE":
                    db.createEntitate(info);
                    break;
                case "INSERT":
                    db.insertInstanta(info);
                    break;
                case "GET":
                    db.getInstanta(info[1], info[2], creanga);
                    break;
                case "UPDATE":
                    db.updateInstante(info);
                    break;
                case "DELETE":
                    db.deleteInstante(info, creanga);
                    break;
                case "SNAPSHOTDB":
                    db.snapshotDB(creanga);
                    break;
                case "CLEANUP":
                    db.cleanDB(info[1], Long.parseLong(info[2]));
                    break;
                default:
                    break;
            }
        }
        creanga.close();
    }
}
