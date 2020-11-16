import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Classe qui se charge de récupérer les données
public class DonneesEntrees {

    // Déclaration et définition de la constante
    public static final int TAILLE_ELEMENTS = 5;

    /* Méthode qui retourne une liste lignes
    Affiche un message d'erreur si le fichierEntree
    n'existe pas et mets fin au programme */
    static ArrayList<String> lireFichier(String fichierEntree) throws FileNotFoundException {
        // Declare une nouvelle liste lignes
        ArrayList<String> lignes = new ArrayList<>();
        try {
            // Crée un nouveau Scanner qui prend en parametre le fichierEntree
            Scanner sc = new Scanner(new File(fichierEntree));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lignes.add(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas!");
            System.exit(0);
        }
        return lignes;
    }

    /* Méthode qui retourne une liste d'interventions,
    et prend en parametre une liste de chaine de caracteres.
     Affiche un message d'erreur avec le numéro de ligne
     et le champ de l'erreur et mets fin au programme. */
    static ArrayList<InterventionsPolicieres> interventions(ArrayList<String> lignes, ArrayList<String> listeArrondissements, ArrayList<String> listeInterventions) {
        // Déclaration d'une nouvelle liste
        ArrayList<InterventionsPolicieres> i = new ArrayList<>();
        for (int j = 0; j < lignes.size() - 1; j++) {
            // Declaration et initialisation de la variable
            int numeroLigne = j + 1;
            // Tableau dont les elements sont séparés par des virgules
            List<String> elements = Arrays.asList(lignes.get(j).split(","));
            if (elements.size() != TAILLE_ELEMENTS) {
                System.out.println("Erreur dans le fichier 'entree.csv' à la ligne " + numeroLigne + ": le champ '" + elements.get(j) + "' est manquant.");
                System.exit(0);
            /* Verifie que l'arrondissement du fichier entre.csv
            existe ou pas dans la liste json des arrondissements*/
            } else if (j != 0 && !listeArrondissements.contains(elements.get(3))) {
                System.out.println("Erreur dans le fichier 'entree.csv' à la ligne " + numeroLigne + ": l'arrondissement '" + elements.get(3) + "' est manquant.");
                System.exit(0);
             /* Verifie que l'intervention du fichier entree.csv
              existe ou pas, dans la liste json des interventions */
            } else if (j != 0 && !listeInterventions.contains(elements.get(4))) {
                System.out.println("Erreur dans le fichier 'entree.csv' à la ligne " + numeroLigne + ": la description '" + elements.get(4) + "' est manquante.");
                System.exit(0);
            } else {
                if (j > 0) {
                    i.add(new InterventionsPolicieres(elements));
                }
            }
        }
        return i;
    }
}

