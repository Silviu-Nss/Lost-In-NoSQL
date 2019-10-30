/**
 *
 * @author Silviu
 */
public class AtrInt extends Atribut {
    private int val;
  
    /**
     *
     * @param tip - tipul de atribut
     * @param val - valoarea atributului
     */
    public AtrInt(String tip, String val) {
        super(tip);
        this.val = Integer.parseInt(val);
    }
  
    /**
     * scrie valoarea
     */
    @Override
    public void print() {
        System.out.println(val);
    }
  
    @Override
    public String toString() {
        return String.valueOf(val);
    }
  
    /**
     *
     * @param val - valoarea atributului
     */
    @Override
    public void update(String val) {
        this.val = Integer.parseInt(val);
    }
}
