package pl.sda.tddtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroOnEmptyString(){
        String data = "";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(0,result);
    }

    @Test
    void shouldReturnNumberOnNumber() {
        String data = "1";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(1,result);
    }

    @Test
    void shouldReturnZeroOnBlank() {
        String data = " ";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(0,result);
    }

    @Test
    void shouldReturnNumberOnNumberWithWhiteSpace() {
        String data = "1 ";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(1,result);
    }

    @Test
    void shouldReturnSumOnTwoNumbers() {
        String data = "1,2";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(3,result);
    }

    @Test
    void shouldReturnNumberWhenSecondNumberIsMissing() {
        String data = "1,";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(1,result);
    }

    @Test
    void shouldReturnSumOfThreeNumbers() {
        String data = "1,2, 8";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(11,result);
    }

    @Test
    void shouldReturnSumOfNumbersWithNewLines() {
        String data = "1,2, 8\n 1,2";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(14,result);
    }

    @Test
    void shouldReturnSumOfNumbersWithCustomDelimitter() {
        String data = "//;\n1;2";

        int result = StringCalculator.adding(data);

        Assertions.assertEquals(3,result);
    }

}