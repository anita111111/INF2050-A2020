import java.io.IOException;
import java.util.ArrayList;

/* Classe qui fait le path vers les differents fichiers
 (fichiers json,fichier d'entrée, fichier de sortie) */
public class Projet {

    /* Stocke deux argurments dans des variables,
    pour pouvoir appeler le programme
    Appelle la méthode validerNombreArguments */
    public static void main(String[] args) throws IOException {

        String fichierArrondissementJson = "arrondissements.json";
        String fichierInterventionJson = "intervention_policiere.json";

        validerNombreArguments(args.length);
        ArrayList<String> lignes = DonneesEntrees.lireFichier("./Fichiers/entree.csv");
        ArrayList<String> listeArrondissements = JsonParser.lierJsonFileToArrondissements("./json/arrondissements.json");
        ArrayList<String> listeInterventions = JsonParser.lierJsonFileToInterventions("./json/intervention_policiere.json");
        ArrayList<InterventionsPolicieres> liste = DonneesEntrees.interventions(lignes, listeArrondissements, listeInterventions);
        DonneesSorties.creerFichier(liste, "./Fichiers/sortie.csv");
        // Prend en parametre un tableau de chaine de carateres
        String fichierEntree = args[0];
        String fichierSortie = args[1];
    }

    /* Méthode qui vérifie que le programme a seulement 2 arguments.
    Si le programme n'a pas 2 arguments, affiche les messages d'erreurs
    et mets fin au programme */
    static void validerNombreArguments(int args) throws IllegalArgumentException {

        if (args != 2) {
            throw new IllegalArgumentException("Erreur! Le programme a besoin de 2 arguments!\nusage: java Projet.class <fichier entrée> " + "<fichier de sortie>");
        }
    }
}
