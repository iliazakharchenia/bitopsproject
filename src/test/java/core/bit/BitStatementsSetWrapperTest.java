package core.bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitStatementsSetWrapperTest {

    @Test
    void constructionOfTheBitStatementsWrapperFromCorrectFinalBitsShouldBeExecuted() {
        var first = new FinalBit(true, "INPUT_1");
        var second = new FinalBit(true, "INPUT_2");

        Assertions.assertDoesNotThrow(() -> new BitStatementsSetWrapper(first, second));
    }

    @Test
    void constructionOfTheBitStatementsWrapperFromFinalBitsWithAtLeastOneSameNameFinalBitShouldThrowTheException() {
        var first = new FinalBit(true, "INPUT_1");
        var second = new FinalBit(true, "INPUT_2");
        var third = new FinalBit(true, "INPUT_2");
        var fourth = new FinalBit(true, "INPUT_4");

        Assertions.assertThrows(RuntimeException.class, () -> new BitStatementsSetWrapper(first, second, third, fourth));
    }

    @Test
    void test1() {
        var first = new FinalBit(true, "INPUT_1");
        var second = new FinalBit(true, "INPUT_2");
        var third = new FinalBit(true, "INPUT_3");
        var fourth = new FinalBit(true, "INPUT_4");

        var set = new BitStatementsSetWrapper(first, second, third, fourth);
        System.out.println(set);
    }
}
