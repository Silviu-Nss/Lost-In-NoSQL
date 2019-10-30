/**
 *
 * @author Silviu
 */
public abstract class Atribut {
  private final String tip;
  
    /**
     *
     * @param tip - tipul de atribut
     */
    public Atribut(String tip) {
    this.tip = tip;
  }
  
    /**
     * scrie valoarea
     */
    public abstract void print();
  
    /**
     *
     * @param val - valoarea atributului
     */
    public abstract void update(String val);
  
  @Override
  public abstract String toString();
}
