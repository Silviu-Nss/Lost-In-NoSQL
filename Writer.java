import java.io.*;

/**
 *
 * @author Silviu
 */
public class Writer
{
  private BufferedWriter bw;
  
    /**
     *
     * @param output - numele fisierului de output
     */
    public Writer(String output)
  {
    try {
      bw = new BufferedWriter(new FileWriter(new File(output)));
    }
    catch (IOException ex) {
        System.err.println("Nu se poate deschide bufferul");
        System.exit(1);
        
    }
  }
  
    /**
     *
     * @param info - informatia ce trebuie scrisa
     */
    public void write(String info) {
    try {
      bw.write(info);
    }
    catch (IOException ex) {
        System.err.println("Nu se poate scrie in buffer");
        System.exit(1);
    }
  }
  
    /**
     *
     * @param info - informatia ce trebuie scrisa
     */
    public void writeLine(String info)
  {
    write(info);
    try {
      bw.newLine();
    }
    catch (IOException ex) {
        System.err.println("Nu se poate scrie in buffer");
        System.exit(1);
    }
  }
  
    /**
     * inchide bufferul
     */
    public void close() {
    try {
      bw.close();
    }
    catch (IOException ex) {
        System.err.println("Nu se poate inchide bufferul");
        System.exit(1);
    }
  }
}
