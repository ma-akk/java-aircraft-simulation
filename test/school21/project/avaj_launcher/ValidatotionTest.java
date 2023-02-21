package school21.project.avaj_launcher;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ValidatotionTest {

    String path = "test/resources/";

    String filename;

    int[] correctNumbers = {5, 20, 15, 10, 5, 5};

    @Test
    @DisplayName("Некорректное количество симуляций")
    void testNumberOfSimulationsException() {
        for (int i = 1; i < 5; i++) {
            filename = "test" + i + ".txt";
            String finalFilename = filename;
            Throwable thrown = assertThrows(RuntimeException.class, () -> {
                Validator.validateInputFile(path + finalFilename);
            });
        }
    }

    @Test
    @DisplayName("Корректное количество симуляций")
    void testNumberOfSimulationsSuccess() {
        for (int i = 0; i < 6; i++) {
            filename = "test" + (i + 5) + ".txt";
            String finalFilename = filename;
            Validator.validateInputFile(path + finalFilename);
            assertEquals(Validator.getNumberOfSimulations(), correctNumbers[i]);
        }
    }

    @Test
    @DisplayName("Проверка невалидного файла сценария")
    void validateInputFileFail() {
        String finalFilename;
        for (int i = 5; i < 10; i++) {
            filename = "test" + i + ".txt";
            finalFilename = filename;
            assertFalse(Validator.validateInputFile(path + finalFilename));
        }
    }

    @Test
    @DisplayName("Проверка валидного файла сценария")
    void validateInputFileSuccess() {
        String finalFilename;
        for (int i = 10; i < 12; i++) {
            filename = "test" + i + ".txt";
            finalFilename = filename;
            assertTrue(Validator.validateInputFile(path + finalFilename));
        }
    }
}