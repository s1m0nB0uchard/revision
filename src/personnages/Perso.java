package personnages;

import java.io.Serializable;

public class Perso implements Serializable {

    protected String nom;
    protected String catchPhrase;

    public void afficherCatchPhrase(){
        System.out.println(catchPhrase);
    }

    public String getNom() {
        return nom;
    }
}
