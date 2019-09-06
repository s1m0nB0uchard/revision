
import exception.Exceptions;
import personnages.Astronaute;
import personnages.Mecanicien;
import personnages.Medecin;
import personnages.Perso;
import vaisseau.Vaisseau;
import sauvegardes.Saves;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class main {

    static void afficherMenuPerso() {
        System.out.printf("1- Astronaute retraité" + "%n" + "2- Mécanicien du dimanche" + "%n" + "3- Médecin pour chevaux" + "%n");
    }

    static void afficherMenu() {
        System.out.printf("1- Examiner l'état du vaisseau" + "%n" + "2- Explorer une planète" + "%n" +
                "3- Utiliser un objet dans l'inventaire" + "%n" + "4- Annuler le dernier déplacement" + "%n" + "5- Sauvegarder" +
                "%n" + "6- Charger une sauvegarde" + "%n" + "7- Redémarrer" + "%n");
    }

    public static void main(String[] args)  {

        Exceptions exceptions = new Exceptions();


        String nomDossier = "./Saves";
        Path path1 = Paths.get(nomDossier);
        Path path3 = Paths.get("./Saves/Vaisseau");
        Path path2 = Paths.get("./Saves/Personnage");
        File dossier = new File(nomDossier);
        try {
            if (!dossier.exists()) {
                Files.createDirectory(path1);
                Files.createDirectory(path2);
                Files.createDirectory(path3);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }


        boolean essence = true, enVie = true;
        Perso perso = new Perso();
        Vaisseau vaisseau = new Vaisseau();
        int nb=0;
        Scanner scan = new Scanner(System.in);

        boolean redem = true;


        while (essence && enVie) {

            if (redem == true) {
                redem = false;
                afficherMenuPerso();
                int choice = scan.nextInt();
                if (choice == 1) {
                    perso = new Astronaute();
                } else if (choice == 2) {
                    perso = new Mecanicien();
                } else perso = new Medecin();

                perso.afficherCatchPhrase();
            }
            System.out.println();
            afficherMenu();
            int choix = scan.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("VOTRE POSTE: " + perso.getNom());
                    vaisseau.afficherStats();
                    break;

                case 2:
                    vaisseau.explorer(perso);
                    vaisseau.planeteExplore();
                    break;

                case 3:
                    try {
                        if (!vaisseau.afficherInventaire()) {
                            nb = scan.nextInt();
                            if (!exceptions.tryNumber(nb)){
                                vaisseau.reparer(nb);}
                            }

                    }
                    catch (Exceptions.numeroInvalide ex){
                        System.out.println(ex.toString());
                    }
                    catch (IndexOutOfBoundsException ex){
                        System.out.println(ex.toString());
                    }


                    break;

                case 4:
                    vaisseau.annulerParcours();
                    break;
                case 5:
                    System.out.print("Donnez un nom à votre sauvegarde:  ");
                    String nom = scan.next();
                    try {
                        Saves.sauvegarderVaisseau(vaisseau, nom);
                        Saves.sauvegarderPerso(perso, nom);
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }

                    break;

                case 6:
                    if (Saves.afficherSauvegardes()) {
                    } else {
                        System.out.print("Entrez le nom de la sauvegarde: ");
                        String saveName = scan.next();
                        vaisseau = Saves.readVaisseau(saveName);
                        perso = Saves.readPerso(saveName);

                    }
                    break;

                case 7:
                    redem = true;
                    break;

                default:
                    System.out.println("Try again");
            }


            if (vaisseau.checkGaz()) {
                essence = false;
                System.out.println("Plus de carburant");
            } else if (vaisseau.checkEnVie()) {
                enVie = false;
                System.out.println("Le vaisseau a subit trop de dégat et il EXPLOSE");
            }
        }
        System.out.println("Votre parcours: ");
        vaisseau.afficherParcours();


    }
}
