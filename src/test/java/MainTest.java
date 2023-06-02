import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MainTest {
    @Disabled
    @Test
    @Timeout(value = 22)
    void invokeMethodMainFailsIfExecutionTimeExceeds22Seconds() throws Exception {
        Main.main(new String[0]);
    }
}