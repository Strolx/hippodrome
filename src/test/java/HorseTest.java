import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class HorseTest {

    private static final String CORRECT_NAME_OF_HORSE = "Horse1";
    private static final double CORRECT_SPEED_OF_HORSE = 5.0;
    private static final double CORRECT_DISTANCE = 10.0;
    private static final double NEGATIVE_SPEED_OF_HORSE = -5.0;
    private static final double NEGATIVE_DISTANCE = -10.0;

    @Test
    public void createInstanceOfHorseWithThreeCorrectParameters() {
        Horse correctInstanceOfHorse = new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);

        assertEquals(correctInstanceOfHorse, new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE));
    }

    @Test
    public void createdInstanceOfHorseWithThreeParametersAndFirstIsNullCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE));
    }

    @Test
    public void createdInstanceOfHorseWithTwoParametersAndFirstIsNullCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, CORRECT_SPEED_OF_HORSE));
    }

    @Test
    public void createdInstanceOfHorseWithThreeParametersAndFirstIsNullCheckMsgOfExceptionCorrect() {
        try {
            new Horse(null, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.NAME_CANNOT_BE_NULL.getMsg(), e.getMessage());
        }
    }

    @Test
    public void createdInstanceOfHorseWithTwoParametersAndFirstIsNullCheckMsgOfExceptionCorrect() {
        try {
            new Horse(null, CORRECT_SPEED_OF_HORSE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.NAME_CANNOT_BE_NULL.getMsg(), e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r"})
    public void createdInstanceOfHorseWithThreeParametersAndFirstIsBlankOrWhitespaceCheckThrowException(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r"})
    public void createdInstanceOfHorseWithTwoParametersAndFirstIsBlankOrWhitespaceCheckThrowException(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, CORRECT_SPEED_OF_HORSE));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r"})
    public void createdInstanceOfHorseWithThreeParametersAndFirstIsBlankOrWhitespaceCheckMsgOfExceptionCorrect(String name) {
        try {
            new Horse(name, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.NAME_CANNOT_BE_BLANK.getMsg(), e.getMessage());
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\r"})
    public void createdInstanceOfHorseWithTwoParametersAndFirstIsBlankOrWhitespaceCheckMsgOfExceptionCorrect(String name) {
        try {
            new Horse(name, CORRECT_SPEED_OF_HORSE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.NAME_CANNOT_BE_BLANK.getMsg(), e.getMessage());
        }
    }

    @Test
    public void createdInstanceOfHorseWithThreeParametersAndSecondIsNegativeCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(CORRECT_NAME_OF_HORSE, NEGATIVE_SPEED_OF_HORSE, CORRECT_DISTANCE));
    }

    @Test
    public void createdInstanceOfHorseWithTwoParametersAndSecondIsNegativeCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(CORRECT_NAME_OF_HORSE, NEGATIVE_SPEED_OF_HORSE));
    }

    @Test
    public void createdInstanceOfHorseWithThreeParametersAndSecondIsNegativeCheckMsgOfExceptionCorrect() {
        try {
            new Horse(CORRECT_NAME_OF_HORSE, NEGATIVE_SPEED_OF_HORSE, CORRECT_DISTANCE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.SPEED_CANNOT_BE_NEGATIVE.getMsg(), e.getMessage());
        }
    }

    @Test
    public void createdInstanceOfHorseWithTwoParametersAndSecondIsNegativeCheckMsgOfExceptionCorrect() {
        try {
            new Horse(CORRECT_NAME_OF_HORSE, NEGATIVE_SPEED_OF_HORSE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.SPEED_CANNOT_BE_NEGATIVE.getMsg(), e.getMessage());
        }
    }

    @Test
    public void createdInstanceOfHorseWithThreeParametersAndThirdIsNegativeCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, NEGATIVE_DISTANCE));
    }

    @Test
    public void createdInstanceOfHorseWithThreeParametersAndThirdIsNegativeCheckMsgOfExceptionCorrect() {
        try {
            new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, NEGATIVE_DISTANCE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Horse.ExceptionMsg.DISTANCE_CANNOT_BE_NEGATIVE.getMsg(), e.getMessage());
        }
    }

    @Test
    public void invokeMethodGetNameCheckReturningValue() {
        Horse horse = new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);

        assertEquals(CORRECT_NAME_OF_HORSE, horse.getName());
    }

    @Test
    public void invokeMethodGetSpeedCheckReturningValue() {
        Horse horse = new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);

        assertEquals(CORRECT_SPEED_OF_HORSE, horse.getSpeed());
    }

    @Test
    public void invokeMethodGetDistanceWhenInstanceOfHorseCreatingWithThreeParametersCheckReturningValue() {
        Horse horse = new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);

        assertEquals(CORRECT_DISTANCE, horse.getDistance());
    }

    @Test
    public void invokeMethodGetDistanceWhenInstanceOfHorseCreatingWithTwoParametersCheckReturningValue() {
        Horse horse = new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE);

        assertEquals(0.0, horse.getDistance());
    }

    @Test
    public void invokeMethodMoveCheckCallMethodGetRandomDouble () {
        try (MockedStatic<Horse> mockedHorse =  Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse(CORRECT_NAME_OF_HORSE, CORRECT_SPEED_OF_HORSE, CORRECT_DISTANCE);

            horse.move();

            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9), times(1));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0.2, 40.0, 0.0",
            "0.3, 50.0, 100.0",
            "0.4, 55.0, 20.0",
            "0.5, 60.0, 50.0",
            "0.6, 65.0, 80.0",
            "0.7, 70.0, 10.0",
            "0.8, 45.0, 0.0",
            "0.9, 32.0, 28.0"
    })
    public void invokeMethodMoveCheckProcessingDistanceCorrect (double pseudoRandomDouble, double speed, double distance) {
        try (MockedStatic<Horse> mockedHorse =  Mockito.mockStatic(Horse.class)) {
            mockedHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(pseudoRandomDouble);
            double expectedDistance = distance + speed * Horse.getRandomDouble(0.2, 0.9);
            Horse horse = new Horse(CORRECT_NAME_OF_HORSE, speed, distance);

            horse.move();

            assertEquals(expectedDistance, horse.getDistance());
        }
    }

}