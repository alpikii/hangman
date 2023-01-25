import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Anna tiedosto mistä sanat löytyy");
        String tiedosto = skanneri.nextLine();
        Sanalista sanalista = new Sanalista(tiedosto);

        Hirsipuu hirsipuu = new Hirsipuu(sanalista, 8);
        System.out.println("Tervetuloa pelaamaan hirsipuuta arvauksia on 8");
        System.out.println(hirsipuu.getTilanne());
        while (true){
            //kysy merkkiä
            System.out.println("Arvaa joku merkki. Anna vastaus pienenä kirjaimena");
            char arvaus = skanneri.next().charAt(0);
            if (hirsipuu.arvaukset().indexOf(arvaus) != -1){
                System.out.println("Olet arvannut jo annetun merkin");
                System.out.println(hirsipuu.arvaukset());
                continue;
            }
            boolean arvattu = hirsipuu.arvaa(arvaus);
            if(arvattu == true) {
                boolean voittiko = hirsipuu.onLoppu();
                if (voittiko == true) {
                    break;
                }else if (voittiko == false){
                    System.out.println(hirsipuu.getTilanne());
                    System.out.println("Arvatut merkit: " +hirsipuu.arvaukset());
                    continue;
                }  
            }
            else if (arvattu == false) {
                int arvauksia_jaljella= hirsipuu.arvauksiaOnJaljella();
                if (arvauksia_jaljella > 0) {
                    System.out.println("Merkki ei ole sanassa, arvauksia jäljellä "+hirsipuu.arvauksiaOnJaljella());
                    System.out.println(hirsipuu.getTilanne());
                    System.out.println("Arvatut merkit: " +hirsipuu.arvaukset());
                }else if (arvauksia_jaljella == 0) {
                    System.out.println("Hävisit pelin. Kaikki arvaukset kulutettu.");
                    System.out.println("Sana oli "+hirsipuu.sana());
                    break;
                }
            }
        }
        skanneri.close();
    }}