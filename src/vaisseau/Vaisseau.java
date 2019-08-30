package vaisseau;

import objet.*;
import planete.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Vaisseau implements Serializable {

    int carburant, ptsVie;
    ArrayList<Object> inventaire = new ArrayList<>();
    Stack<String> parcours = new Stack<>();


    public Vaisseau() {
        carburant = 100;
        ptsVie = 200;
        parcours.push("Terre");
    }

    public void afficherStats() {

        System.out.println("Quantité carburant ----> " + carburant);
        System.out.println("Planète courante ----> " + parcours.peek());
        System.out.println("Points de vie ----> " + ptsVie);
        System.out.print("Inventaire ----> ");
        this.afficherInventaire();


    }

    public void reparer(int num) {
        Objet objet = (Objet) inventaire.get(num - 1);
        objet.utiliser(this);
        inventaire.remove(num - 1);
    }

    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }

    public void prendreDegats(int degats) {
        ptsVie = this.ptsVie - degats;
    }

    public void setPtsVie(int ptsVie) {
        this.ptsVie = ptsVie;
    }

    public void setInventaire(Objet objet) {
        this.inventaire.add(objet);
    }

    public int getCarburant() {
        return carburant;
    }

    public int getPtsVie() {
        return ptsVie;
    }

    public boolean afficherInventaire() {
        boolean vide=false;
        if (!inventaire.isEmpty()) {
            for (int i = 0; i < inventaire.size(); i++) {
                Objet objet = (Objet) inventaire.get(i);
                System.out.println(objet.getNom());

            }
        } else {
            vide=true;
            System.out.println("Vide");
        }
        return vide;
    }

    public boolean checkGaz() {
        boolean vide = false;
        if (carburant <= 0) {
            vide = true;
        }
        return vide;
    }

    public boolean checkEnVie() {
        boolean mort = false;
        if (carburant <= 0) {
            mort = true;
        }
        return mort;
    }

    public void annulerParcours() {
        if (parcours.peek()!="Terre") {
            carburant = carburant - 15;
            System.out.println("Vous avez consommé 15 points d'essence pour revenir");
            System.out.println( "Voyage sur " + parcours.pop() + " annulé");
            System.out.println(" Vous êtes de retour sur la planète" + parcours.peek());
        } else System.out.println("Vous ne pouvez reculer plus loin que la terre");
    }

    public void afficherParcours() {

        while (!parcours.empty()){
            System.out.print( "--" + parcours.pop() + "--");
        }
    }

    public Vaisseau explorer() {
        ArrayList<Planete> liste = new ArrayList<>();
        liste.add(new Emma());
        liste.add(new IronMan());
        liste.add(new Poutine());
        liste.add(new SoniaShampoo());
        Collections.shuffle(liste);
        parcours.add(liste.get(1).getNom());
        return liste.get(1).explorer(this);

    }

    public void planeteExplore() {
        System.out.println("Vous avez exploré la planete " + parcours.peek());
    }
}
