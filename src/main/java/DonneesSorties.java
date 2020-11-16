import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

// Classe qui se charge de générer les données du fichier de sortie
public class DonneesSorties {

    // Represente ce que contiendra la liste du fichier de sortie
    static String contenir (ArrayList<InterventionsPolicieres> listeInterventions) {
        // Declaration des variables
        int nombreInterventions;
        int nombreParcs;
        // Declaration et initialisation de la variable
        String motsSorties = "";
        // Declaration d'une nouvelle liste
        ArrayList<String> tab = new ArrayList<>();
        for (int j = 0; j < listeInterventions.size(); j++) {
            if (!tab.contains(listeInterventions.get(j).getArrondissement())) {
                // Ajoute à la nouvelle liste les arrondissements
                tab.add(listeInterventions.get(j).getArrondissement());
                // Trie la liste d'arrondissements en ordre alphabétique
                Collections.sort(tab);
            }
        }
        for (int j = 0; j < tab.size(); j++) {
            // Initialisation des variables
            nombreInterventions = 0;
            nombreParcs = 0;
            // Élimine les doublons
            HashSet listeParcs = new HashSet();
            for (int i = 0; i < listeInterventions.size(); i++) {
                if (tab.get(j).equals(listeInterventions.get(i).getArrondissement())) {
                    nombreInterventions += 1;
                    listeParcs.add(listeInterventions.get(i).getParc());
                }
            }
            nombreParcs = listeParcs.size();
            /* Prend les noms d'arrondissements, ajoute une virgule,
            suivi du nombre d'interventions, ajoute une virgule,
            suivi du nombre de parcs et ajoute un saut à la ligne */
            motsSorties += tab.get(j) + "," + nombreInterventions + "," + nombreParcs + "\n";
        }
        return motsSorties; // Retourne une chaine de caracteres avec tout ce qu'il contient
    }

    static void creerFichier(ArrayList<InterventionsPolicieres> listeInterventions, String fichierSortie) throws IOException {
        /* Déclaration d'une chaine de caracteres,
         avec les elements representant l'entête, et saut de ligne */
        String motsSorties = "Arrondissement,Nombre d'interventions,Nombre de parcs\n";
        // Appelle le contenu et concatène le contenu à la chaine de caracteres
        motsSorties += contenir(listeInterventions);
        // Appel de la methode saveStringIntoFile
        Utf8File.saveStringIntoFile(fichierSortie, motsSorties);
    }
}
