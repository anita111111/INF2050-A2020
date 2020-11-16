import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjetTest {

    @Test
    public void testValiderNombreArguments() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Projet.validerNombreArguments(3));
    }

    @Test
    public void testValiderNombreArguments2() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Projet.validerNombreArguments(0));
    }

}