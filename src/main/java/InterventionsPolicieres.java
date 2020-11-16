import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/* Classe qui traite toutes les vaiables sur les
statistiques des interventions policières */
public class InterventionsPolicieres {

    // Declaration des 5 variables
    String dates;
    String heure;
    String parc;
    String arrondissement;
    String description;

    // Les Getters et les Setters des 5 variables
    public String getDates() {

        return dates;
    }

    public void setDates(String dates) {

        fromStringToDate(dates);
        this.dates = dates;
    }

    public String getHeure() {

        return heure;
    }

    public void setHeure(String heure) {

        fromStringToTime(heure);
        this.heure = heure;
    }

    public String getParc() {

        return parc;
    }

    public void setParc (String parc) {

        this.parc = parc;
    }

    public String getArrondissement() {

        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {

        this.arrondissement = arrondissement;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    /* Création d'un constructeur qui mets les differents
    elements dans un tableau avec une position definit */
    public InterventionsPolicieres (List<String>element) {

        this.setDates(element.get(0)); // Appel du setter
        this.setHeure(element.get(1)); // Appel du setter
        this.parc = element.get(2);
        this.arrondissement = element.get(3);
        this.description = element.get(4);
    }

    /* Methode qui retourne la date selon le format définit.
    Si la date ne respecte pas le format yyyy-MM-dd,
    affiche un message d'erreur et mets fin au programme. */
    public LocalDate fromStringToDate (String date) {

        // Declaration de la variable
        DateTimeFormatter formatter;
        // Declaration et initialisation de la variable
        LocalDate localDate = null;

        try {
            // Définit le format que doit respecter la date
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Transforme la chaine de caracteres en localDate sous le Pattern yyyy-MM-dd
            localDate = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            System.out.println("Erreur! Une ou plusieurs lignes contiennent une date avec un format invalide!");
            System.exit(0);
        }
        return localDate;
    }

    /* Methode qui retourne l'heure selon le format définit.
    Si l'heure ne respecte pas le format H:mm,
    affiche un message d'erreur et mets fin au programme. */
    public static LocalTime fromStringToTime (String time) {

        // Declaration de la variable
        DateTimeFormatter formatter;
        // Declaration et initialisation de la variable
        LocalTime localTime = null;

        try {
            // Définit le format que doit respecter l'heure
            formatter = DateTimeFormatter.ofPattern("H:mm");
            // Transforme la chaine de caracteres en localTime sous le Pattern H:mm
            localTime = LocalTime.parse(time, formatter);
        } catch (Exception e) {
            System.out.println("Erreur! Une ou plusieurs lignes contiennent une heure avec un format invalide!");
            System.exit(0);
        }
        return localTime;
    }
}



