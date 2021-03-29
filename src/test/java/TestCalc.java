import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalc {
    TestCalc calc = new TestCalc();

    @Test
    public void testMonthlyPayment() {
        int sum = 1500000;
        float percent = (float) 0.19;
        int creditPeriod = 48;
        float rate = percent / 12;
        double pow = (Math.pow((1 + rate), creditPeriod));
        double coefficient = (rate * pow / (pow - 1));
        int testMonthlyPayment = (int) (coefficient * sum);
        int monthlyPayment = calc.payment(sum, percent, creditPeriod);
        assertEquals(testMonthlyPayment, monthlyPayment);
    }

    @Test
    public void testTotalAmountCredit() {
        int sum = 1500000;
        float percent = (float) 0.19;
        int creditPeriod = 48;
        float rate = percent / 12;
        double pow = (Math.pow((1 + rate), creditPeriod));
        double coefficient = (rate * pow / (pow - 1));
        int testMonthlyPayment = (int) (coefficient * sum);
        int testTotal = (int) (testMonthlyPayment * creditPeriod);
        int total = calc.sumPays(sum, percent, creditPeriod);
        assertEquals(testTotal, total);
    }

    @Test
    public void testOverPayment () {
        int sum = 1500000;
        float percent = (float) 0.19;
        int creditPeriod = 48;
        float rate = percent / 12;
        double pow = (Math.pow((1 + rate), creditPeriod));
        double coefficient = (rate * pow / (pow - 1));
        int testMonthlyPayment = (int) (coefficient * sum);
        int testTotal = (int) (testMonthlyPayment * creditPeriod);
        int testOverPayment  = testTotal - sum;
        int overPayment = calc.overPay(sum, percent, creditPeriod);
        assertEquals(testOverPayment, overPayment);
    }

}
