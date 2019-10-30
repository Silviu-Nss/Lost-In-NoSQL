/**
 *
 * @author Silviu
 */
public class AtrString extends Atribut {
    private String val;
  
    /**
     *
     * @param tip - tipul de atribut
     * @param val - valoarea atributului
     */
    public AtrString(String tip, String val) {
        super(tip);
        this.val = val;
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
        return val;
    }
  
    /**
     *
     * @param val - valoarea atributului
     */
    @Override
    public void update(String val) {
        this.val = val;
    }
}
