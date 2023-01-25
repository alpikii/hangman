import java.util.List;
import java.util.Random;
import java.util.ArrayList;
public class Hirsipuu {
    private List<String> sanalista;
    private int arvaus_lkm;
    private String sana;
    private List<Character> arvaukset;
    private char[] tilanne;
    //constructor
    public Hirsipuu(Sanalista lista, int arvaus_lkm) {
        this.sanalista = lista.annaSanat();
        this.arvaus_lkm = arvaus_lkm;
        this.arvaukset = new ArrayList<Character>();
        Random rand = new Random(System.currentTimeMillis());
        this.sana = sanalista.get(rand.nextInt(sanalista.size()));
        this.tilanne = new char[sana.length()];
        for (int i = 0; i < sana.length(); i++){
            tilanne[i] = '_';
        }
    }

    public boolean arvaa(Character merkki){
        arvaukset.add(merkki);
        if (sana.indexOf(merkki) == -1){
            this.arvaus_lkm -= 1;
            return false;
        }else{
            char[] vertailu = new char[sana.length()];
            sana.getChars(0, sana.length(), vertailu, 0);
            for(int i=0; i < sana.length(); i++){
                if (merkki.charValue() == vertailu[i]){
                    tilanne[i] = merkki.charValue();
                }
            }
            return true;
        }
    }

    public boolean onLoppu(){
        String a = new String(tilanne);
        if (this.sana.equals(a)){
            System.out.println("Voitit pelin!");
            System.out.println("Sana oli "+this.sana);
            return true;
        }else{
            return false;
        }
        }


    //setteri
    public void setSanalista(List<String> sanalista){
        this.sanalista = sanalista;
    }
    public void setArvaukset(int arvaus_lkm) {
        this.arvaus_lkm = arvaus_lkm;
    }
    public void setSana(String sana){
        this.sana = sana;
    }
    //getteri
    public List<Character> arvaukset(){
        return this.arvaukset;
    }
    public int arvauksiaOnJaljella(){
        return this.arvaus_lkm;
    }
    public String sana(){
        return this.sana;
    }
    public List<String> getSanalista() {
        return this.sanalista;
    }
    public char[] getTilanne() {
        return this.tilanne;
    }
}
