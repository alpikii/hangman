import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class Sanalista {
    private List<String> sanalista;
    //constructor
    public Sanalista(String tiedosto) {
        try (BufferedReader teksti = new BufferedReader ( new FileReader(tiedosto))) {
            String rivi;
            this.sanalista = new ArrayList<String>();
            while ((rivi = teksti.readLine()) != null) {
                this.sanalista.add(rivi);
              } 
          } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    //getteri
    public List<String> annaSanat(){
        return this.sanalista;
    }
    //setteri
    public void setSanalista(List<String> sanalista){
        this.sanalista = sanalista;
    }
}
