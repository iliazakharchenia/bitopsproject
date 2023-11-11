package core.bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class BitUtilsTest {

    @Test
    void notShouldReturnInvertedResult() {
        Bit bit = new Bit(true);
        Assertions.assertFalse(BitUtils.not(bit));

        bit.invert();
        Assertions.assertTrue(BitUtils.not(bit));
    }

    @ParameterizedTest
    @CsvSource({"00", "01", "10", "11", "000", "001", "010", "011", "100", "101", "110", "111"})
    void andShouldReturnTrueWhenAndOnlyWhenAllBitsAreTrue(String input) {
        Bit[] bitArray = extractBitArrayFromInputString(input);
        boolean hasFalse = Arrays.stream(bitArray).anyMatch(Bit::isFalse);

        if (hasFalse) {
            Assertions.assertFalse(BitUtils.and(bitArray));
        } else Assertions.assertTrue(BitUtils.and(bitArray));
    }

    @ParameterizedTest
    @CsvSource({"00", "01", "10", "11", "000", "001", "010", "011", "100", "101", "110", "111"})
    void orShouldReturnFalseOnlyWhenAllArgsAreFalseAndTrueInAllOtherCases(String input) {
        Bit[] bitArray = extractBitArrayFromInputString(input);
        boolean allFalse = Arrays.stream(bitArray).allMatch(Bit::isFalse);

        if (allFalse) {
            Assertions.assertFalse(BitUtils.or(bitArray));
        } else Assertions.assertTrue(BitUtils.or(bitArray));
    }

    @ParameterizedTest
    @CsvSource({"00", "01", "10", "11", "000", "001", "010", "011", "100", "101", "110", "111"})
    void xorShouldReturnFalseWhenAllArgsAreFalseOrWhenAllArgsAreTrueAndTrueInAllOtherCases(String input) {
        Bit[] bitArray = extractBitArrayFromInputString(input);
        boolean allFalse = Arrays.stream(bitArray).allMatch(Bit::isFalse);
        boolean allTrue = Arrays.stream(bitArray).allMatch(Bit::isTrue);

        if (allFalse) {
            Assertions.assertFalse(BitUtils.xor(bitArray));
        } else {
            if (allTrue) {
                Assertions.assertFalse(BitUtils.xor(bitArray));
            } else Assertions.assertTrue(BitUtils.xor(bitArray));
        }
    }

    private Bit[] extractBitArrayFromInputString(String input) {
        char[] inputArray = input.toCharArray();
        Bit[] bitArray = new Bit[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == '1') {
                bitArray[i] = new Bit(true);
            } else {
                bitArray[i] = new Bit(false);
            }
        }

        return bitArray;
    }

}