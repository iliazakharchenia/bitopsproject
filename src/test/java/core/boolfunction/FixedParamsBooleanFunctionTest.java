package core.boolfunction;

import core.bit.BitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FixedParamsBooleanFunctionTest {

    @Test
    void sizeMethodShouldReturnCorrectSizeOfTheParamsSet() {
        var params = new ArgumentsNamesSetWrapper("PIN_1", "PIN_2", "PIN_3", "PIN_4");
        var function = new FixedParamsBooleanFunction(params, bits -> {
            var first = bits[0];
            var second = bits[1];
            var third = bits[2];
            var fourth = bits[3];

            return BitUtils.and(BitUtils.or(BitUtils.not(first), second), third, fourth);
        });

        Assertions.assertEquals(function.size(), 4);
    }

    @Test
    void processMethodShouldReturnCorrectResult() {
        var params = new ArgumentsNamesSetWrapper("PIN_1", "PIN_2", "PIN_3", "PIN_4");
        var function = new FixedParamsBooleanFunction(params, bits -> {
            var first = bits[0];
            var second = bits[1];
            var third = bits[2];
            var fourth = bits[3];

            return BitUtils.and(BitUtils.or(BitUtils.not(first), second), third, fourth);
        });

        Assertions.assertFalse(function.process(true, false, true, true));
    }

    @Test
    void processMethodShouldThrowsAnExceptionIfArgumentsLengthIsIncompatible() {
        var params = new ArgumentsNamesSetWrapper("PIN_1", "PIN_2", "PIN_3", "PIN_4");
        var function = new FixedParamsBooleanFunction(params, bits -> {
            var first = bits[0];
            var second = bits[1];
            var third = bits[2];
            var fourth = bits[3];

            return BitUtils.and(BitUtils.or(BitUtils.not(first), second), third, fourth);
        });

        Assertions.assertThrows(RuntimeException.class, () -> function.process(true, false, true, true, true));
        Assertions.assertThrows(RuntimeException.class, () -> function.process(true, false, true));
    }
}
