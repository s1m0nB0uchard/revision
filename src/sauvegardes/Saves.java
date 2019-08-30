package sauvegardes;

import vaisseau.Vaisseau;

import java.io.*;

public class Saves {

    public static void sauvegarderVaisseau(Vaisseau vaisseau, String nomSauvegarde) throws IOException {

        ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./Saves/" + nomSauvegarde + ".dat")));
        output.writeObject(vaisseau);
        output.close();
    }

    public static Vaisseau readList(String nomSauvegarde) {
        Vaisseau sortie = new Vaisseau();
        try {
            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./Saves/" + nomSauvegarde + ".dat")));
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

    public static boolean afficherSauvegardes() {
        File saves = new File("./Saves/");
        boolean vide = false;
        if (saves.exists()) {
            File saveList[] = saves.listFiles();
            if (saveList.length >= 1) {
                for (File file : saveList) {
                    System.out.println(file.getName());
                }
            }else{
                System.out.println("T'as pas de saves moron");
                vide=true;
            }
        }return vide;
    }






}
