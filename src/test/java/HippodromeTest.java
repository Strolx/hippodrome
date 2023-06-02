import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    private static final int NUMBER_OF_HORSES = 30;
    private static final int NUMBER_OF_MOCK_HORSES = 50;
    private static final String NAME_OF_HORSE = "Horse";

    @Test
    public void createInstanceOfHippodromeWithNullParameterCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    public void createInstanceOfHippodromeWithNullParameterCheckMsgOfExceptionCorrect() {
        try {
            new Hippodrome(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Hippodrome.ExceptionMsg.HORSES_CANNOT_BE_NULL.getMsg(), e.getMessage());
        }
    }

    @Test
    public void createInstanceOfHippodromeWithEmptyListParameterCheckThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    public void createInstanceOfHippodromeWithEmptyListParameterCheckMsgOfExceptionCorrect() {
        try {
            new Hippodrome(new ArrayList<>());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(Hippodrome.ExceptionMsg.HORSES_CANNOT_BE_EMPTY.getMsg(), e.getMessage());
        }
    }

    @Test
    public void invokeMethodGetHorsesCheckReturningValue() {
        List<Horse> originalHorses = new ArrayList<>();
        Random random = new Random();
        double speed;
        double distance;
        for (int i = 0; i < NUMBER_OF_HORSES; i++) {
            speed = (random.nextDouble() + 0.1) * 50;
            distance =  (random.nextDouble() + 0.1) * 150;
            originalHorses.add(new Horse(NAME_OF_HORSE + i, speed, distance));
        }
        List<Horse> copyHorses = new ArrayList<>(originalHorses);
        Hippodrome hippodrome = new Hippodrome(copyHorses);

        assertEquals(originalHorses, hippodrome.getHorses());
    }

    @Test
    public void invokeMethodMoveCheckInvokingMethodMoveInside() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_MOCK_HORSES; i++) {
           horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);

        hippodrome.move();

        horses.forEach(mockHorse -> Mockito.verify(mockHorse).move());
    }

    @Test
    public void invokeMethodGetWinnerCheckReturningValue() {
        List<Horse> horses = new ArrayList<>();
        Random random = new Random();
        double speed;
        double distance;
        for (int i = 0; i < NUMBER_OF_HORSES; i++) {
            speed = (random.nextDouble() + 0.1) * 50;
            distance =  (random.nextDouble() + 0.1) * 150;
            horses.add(new Horse(NAME_OF_HORSE + i, speed, distance));
        }
        Horse expectedWinnerHorse = horses.stream().
                                max((horse1, horse2) -> Double.compare(horse1.getDistance(), horse2.getDistance())).
                                get();
        Hippodrome hippodrome = new Hippodrome(horses);

        Horse winnerHorse = hippodrome.getWinner();

        assertEquals(expectedWinnerHorse, winnerHorse);
    }

}