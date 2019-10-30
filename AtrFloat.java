import java.text.DecimalFormat;

/**
 *
 * @author Silviu
 */
public class AtrFloat extends Atribut {
    private float val;
    private final DecimalFormat df;
  
    /**
     *
     * @param tip - tipul de atribut
     * @param val - valoarea atributului
     */
    public AtrFloat(String tip, String val) {
        super(tip);
        this.val = Float.parseFloat(val);
        df = new DecimalFormat("#.##");
    }
  
    /**
     * scrie valoarea
     */
    @Override
    public void print() {
        System.out.println(df.format(val));
    }
  
    @Override
    public String toString() {
        return df.format(val);
    }
  
    /**
     *
     * @param val - valoarea atributului
     */
    @Override
    public void update(String val) {
        this.val = Float.parseFloat(val);
    }
}