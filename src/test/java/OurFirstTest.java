import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OurFirstTest {

    private Integer sum(Integer a, Integer b) {
        return a + b;
    }

    private final Logger LOGGER = LogManager.getLogger(OurFirstTest.class);

    @Test
    public void showSum() {

        LOGGER.info("Making variables");
        Integer c;
        Integer d;

        LOGGER.info("Now we are summing two digits");
        c = sum(15, 5);

        LOGGER.info("And another sum");
        d = sum(25, 15);

//        System.out.println("C is: " + c + " \nand D is: " + d);

       Assertions.assertEquals(20, c, "Match failed");
    }
}
