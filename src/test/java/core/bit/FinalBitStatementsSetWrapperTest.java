package core.bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FinalBitStatementsSetWrapperTest {

    @Test
    void constructionOfTheBitStatementsWrapperFromCorrectFinalBitsShouldBeExecuted() {
        var first = new FinalBit(true, "INPUT_1");
        var second = new FinalBit(true, "INPUT_2");

        Assertions.assertDoesNotThrow(() -> new FinalBitStatementsSetWrapper(first, second));
    }

    @Test
    void constructionOfTheBitStatementsWrapperFromFinalBitsWithAtLeastOneSameNameFinalBitShouldThrowTheException() {
        var first = new FinalBit(true, "INPUT_1");
        var second = new FinalBit(true, "INPUT_2");
        var third = new FinalBit(true, "INPUT_2");
        var fourth = new FinalBit(true, "INPUT_4");

        Assertions.assertThrows(RuntimeException.class,
                () -> new FinalBitStatementsSetWrapper(first, second, third, fourth));
    }
}
