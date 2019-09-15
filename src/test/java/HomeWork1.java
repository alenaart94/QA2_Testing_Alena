import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWork1 {

    private Integer percentage(Integer num, Integer percentage) {
        return num * percentage / 100;
    }

    private Double fuelConsumption(Double v, Double s) {
        return v * 100 / s;
    }

    public Integer charCount(String ch, String word) {
       return StringUtils.countMatches(word, ch);
    }

    @Test
    public void showPercentage() {
        Integer percentageResult;

        percentageResult = percentage(50, 20);

        Assertions.assertEquals(10, percentageResult, "Percentage value is incorrect");
    }

    @Test
    public void showFuelConsumption() {
        Double fuelConsumptionResult;

        fuelConsumptionResult = fuelConsumption(64.0, 1000.0);

        Assertions.assertEquals(6.4, fuelConsumptionResult, "Fuel consumption value is incorrect");
    }

    @Test
    public void showCharCount() {
        Integer charCountResult;

        charCountResult = charCount("a", "caramelle");

        Assertions.assertEquals(2, charCountResult, "char count is incorrect");
    }
}

