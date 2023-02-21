package school21.project.avaj_launcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    String[] incorrectNullArgs = {};

    String[] incorrectArgs = {"filename", "one-more-param"};

    @Test
    void mainNullArgTestFail() {
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            Application.main(incorrectNullArgs);
        });
    }

    @Test
    void mainCountArgTestFail() {
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            Application.main(incorrectArgs);
        });
    }
}