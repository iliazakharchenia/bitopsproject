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

    @ParameterizedTest
    @CsvSource({"00", "01", "10", "11", "000", "001", "010", "011", "100", "101", "110", "111"})
    void numberFromBitSequenceShouldReturnCorrectResults(String input) {
        Bit[] bitArray = extractBitArrayFromInputString(input);
        boolean[] bits = new boolean[bitArray.length];
        int index = 0;
        for (Bit bit: bitArray) {
            bits[index] = bit.isTrue();
            index++;
        }

        if (input.length() == 2) Assertions.assertEquals(
                BitUtils.numberFromBitSequence(bits),
                fromBoolStatement(bits[1]) + fromBoolStatement(bits[0])*2);
        if (input.length() == 3) Assertions.assertEquals(
                BitUtils.numberFromBitSequence(bits),
                fromBoolStatement(bits[2]) + fromBoolStatement(bits[1])*2 + fromBoolStatement(bits[0])*4);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "10", "11", "100", "101", "110", "111"})
    void bitSequenceFromNumberShouldReturnCorrectData(String input) {
        Bit[] bitArray = extractBitArrayFromInputString(input);
        boolean[] bits = new boolean[bitArray.length];
        int index = 0;
        for (Bit bit: bitArray) {
            bits[index] = bit.isTrue();
            index++;
        }

        boolean[] sequence = BitUtils.bitSequenceFromNumber(BitUtils.numberFromBitSequence(bits));

        Assertions.assertArrayEquals(bits, sequence);
    }

    private int fromBoolStatement(boolean bit) {
        if (bit) return 1;
        else return 0;
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
