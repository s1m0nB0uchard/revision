package sauvegardes;

import personnages.Perso;
import vaisseau.Vaisseau;

import java.io.*;

public class Saves {

    public static void sauvegarderVaisseau(Vaisseau vaisseau, String nomSauvegarde) throws IOException {

        ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./Saves/Vaisseau/" + nomSauvegarde + ".dat")));
        output.writeObject(vaisseau);
        output.close();
    }
    public static void sauvegarderPerso(Perso perso, String nomSauvegarde){
try{
    ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./Saves/Personnage/" + nomSauvegarde + ".dat")));
    output.writeObject(perso);
    output.close();
}
catch (IOException ex){
    System.out.println(ex.toString());
}


    }

    public static Vaisseau readVaisseau(String nomSauvegarde) {
        Vaisseau sortie = new Vaisseau();
        try {
            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./Saves/Vaisseau/" + nomSauvegarde + ".dat")));
            try {
                sortie = (Vaisseau) input.readObject();
            } catch (ClassCastException ex) {
                System.out.println("Exception " + ex.toString() + " Sauvegarde vide.");
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println();
            System.out.println("Exception " + ex.toString() + " Nom de fichier inexistant.");
        } catch (Exception ex) {
            System.out.println("Exception " + ex.toString() + " lancée.");
        }
        return sortie;
    }
    public static Perso readPerso(String nomSauvegarde){
        Perso sortie = new Perso();

        try {
            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./Saves/Personnage/" + nomSauvegarde + ".dat")));
            try {
                sortie = (Perso) input.readObject();
            } catch (ClassCastException ex) {
                System.out.println("Exception " + ex.toString() + " Sauvegarde vide.");
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println();
            System.out.println("Exception " + ex.toString() + " Sauvegarde ne contenant pas de personnage.");
        } catch (Exception ex) {
            System.out.println("Exception " + ex.toString() + " lancée.");
        }
        return sortie;


    }

    public static boolean afficherSauvegardes() {
        File saves = new File("./Saves/Vaisseau/");
        boolean vide = false;
        if (saves.exists()) {
            File saveList[] = saves.listFiles();
            if (saveList.length >= 1) {
                for (File file : saveList) {
                    System.out.println(file.getName());
                }
            }else{
                System.out.println("Aucune sauvegarde");
                vide=true;
            }
        }return vide;
    }






}
