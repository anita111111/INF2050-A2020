import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;

//  Classe qui effectue la lecture des fichiers JSON
public class JsonParser {

    /* Méthode qui fait la liaison entre la liste d'arrondissements et le fichier d'entrée
       Retourne une liste d'arrondissements */
    public static ArrayList<String> lierJsonFileToArrondissements (String fichierArrondissementJson) throws IOException {

        ArrayList<String> arrondissements = new ArrayList<>();
        String jsonString = Utf8File.loadFileIntoString(fichierArrondissementJson);
        // Crée un JSONObject à partir d'une chaine de caracteres et appelle la méthode toJSON
        JSONObject objet = (JSONObject) JSONSerializer.toJSON(jsonString);
        // Récupère la clé pour la valeur arrondissements
        JSONArray arrondissementData = objet.getJSONArray("arrondissements");

        for (int i = 0; i < arrondissementData.size(); i++) {
            arrondissements.add(arrondissementData.getString(i));
        }
            return arrondissements;
        }

    /* Méthode qui fait la liaison entre la liste d'interventions et le fichier d'entrée
       Retourne une liste d'interventions policieres */
    public static ArrayList<String> lierJsonFileToInterventions (String fichierInterventionJson) throws IOException {

        ArrayList<String> interventionsPolieres = new ArrayList<>();
        String jsonString = Utf8File.loadFileIntoString(fichierInterventionJson);
        // Crée un JSONObject à partir d'une chaine de caracteres et appelle de la méthode toJSON
        JSONObject objet = (JSONObject) JSONSerializer.toJSON(jsonString);
        // Récupère la clé pour la valeur intervention_policiere
        JSONArray interventionData = objet.getJSONArray("intervention_policiere");

        for (int i = 0; i < interventionData.size(); i++) {
            interventionsPolieres.add(interventionData.getString(i));
        }
        return interventionsPolieres;
    }

    /* Methode qui récupère le contenu du fichier json et
       retourne une chaine de caracteres avec son contenu */
    public static String loadFileIntoString(String filePath) throws IOException {
        return IOUtils.toString(Utf8File.class.getResourceAsStream(filePath), "UTF-8");
    }
}




