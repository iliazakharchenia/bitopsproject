package core.truthtable;

import core.bit.BitUtils;
import core.boolfunction.ArgumentsNamesSetWrapper;
import core.boolfunction.FixedParamsBooleanFunction;
import core.boolfunction.PrimitiveBooleanFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FinalTruthTableForFixedBooleanFunctionTest {

    @ParameterizedTest
    @CsvSource({"10000", "10001", "10010", "10011", "10100", "10101", "10110",
            "10111", "11000", "11001", "11010", "11011", "11100", "11101",
            "11110", "11111"})
    void processMethodShouldReturnCorrectAnswers(String input) {
        boolean[] bits = extractBitArrayFromInputString(input);
        PrimitiveBooleanFunction function = bitSequence -> BitUtils.not(BitUtils.and(bitSequence));
        var truthTable = new FinalTruthTableForFixedBooleanFunction(
                new FixedParamsBooleanFunction(
                        new ArgumentsNamesSetWrapper("INPUT_1", "INPUT_2", "INPUT_3", "INPUT_4", "INPUT_5"),
                        function
                ),
                "OUT", "Truth table of 5-AND-NO");

        Assertions.assertEquals(function.process(bits), truthTable.process(bits));
    }

    @Test
    void toStringTest() {
        PrimitiveBooleanFunction function = bitSequence -> BitUtils.not(BitUtils.and(bitSequence));
        var truthTable = new FinalTruthTableForFixedBooleanFunction(
                new FixedParamsBooleanFunction(
                        new ArgumentsNamesSetWrapper("A_1", "A_2", "B_INPUT_1", "B_INPUT_2", "C_1"),
                        function
                ),
                "OUT", "Truth table of 5-AND-NO");

        System.out.println(truthTable);
    }

    @Test
    void getParametersSize() {
    }

    @Test
    void getNameOfParamByIndex() {
    }

    @Test
    void getNameOfResult() {
    }

    private int fromBoolStatement(boolean bit) {
        if (bit) return 1;
        else return 0;
    }

    private boolean[] extractBitArrayFromInputString(String input) {
        char[] inputArray = input.toCharArray();
        boolean[] bits = new boolean[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == '1') {
                bits[i] = true;
            } else {
                bits[i] = false;
            }
        }

        return bits;
    }
}
