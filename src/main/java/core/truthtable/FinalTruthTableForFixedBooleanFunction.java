package core.truthtable;

import core.bit.BitUtils;
import core.boolfunction.FixedParamsBooleanFunction;

import java.util.LinkedHashMap;
import java.util.Map;

public class FinalTruthTableForFixedBooleanFunction implements TruthTable {
    private final FixedParamsBooleanFunction function;
    private final String nameOfResult;
    private final Map<Integer, Boolean> table = new LinkedHashMap<>();
    private final String tableName;

    public FinalTruthTableForFixedBooleanFunction(FixedParamsBooleanFunction function, String nameOfResult,
                                                  String tableName) {
        this.function = function;
        this.nameOfResult = nameOfResult;
        this.tableName = tableName;
        calculateTruthTable(function);
    }

    private void calculateTruthTable(FixedParamsBooleanFunction function) {
        int size = (int) Math.pow(2, function.size());
        int paramsLength = function.size();

        for (int i = 0; i < size; i++) {
            boolean[] sequence = BitUtils.bitSequenceFromNumber(i);
            this.table.put(i, function.process(
                    BitUtils.withLeadingZeroes(paramsLength - sequence.length, sequence)));
        }
    }

    @Override
    public boolean process(boolean... bits) {
        if (bits.length != this.getParametersSize())
            throw new IllegalArgumentException("Bit sequence length should be same with table parameters size.");

        int number = BitUtils.numberFromBitSequence(bits);
        return table.get(number);
    }

    @Override
    public int getParametersSize() {
        return function.size();
    }

    @Override
    public String getNameOfParamByIndex(int index) {
        return function.getParameterNameByIndex(index);
    }

    @Override
    public String getNameOfResult() {
        return this.nameOfResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tableName).append(" : \n");

        int maxLength = this.nameOfResult.length();
        int parametersSize = this.getParametersSize();
        String[] parameters = new String[parametersSize];
        for (int i = 0; i < parametersSize; i++) {
            parameters[i] = this.getNameOfParamByIndex(i);
            if (parameters[i].length() > maxLength) maxLength = parameters[i].length();
        }

        // header
        horizontalLine(sb, maxLength, parametersSize);
        row(sb, maxLength, parametersSize, parameters, this.getNameOfResult());
        horizontalLine(sb, maxLength, parametersSize);

        String[] bitStrings = new String[parametersSize + 1];
        // value rows
        for (int rowNum = 0; rowNum < Math.pow(2, parametersSize); rowNum++) {
            boolean[] bitValues = BitUtils.bitSequenceFromNumber(rowNum);
            boolean[] bitValuesWithLeadingZeroes = BitUtils.withLeadingZeroes(
                    parametersSize-bitValues.length, bitValues);

            for (int i = 0; i < parametersSize; i++) {
                if (bitValuesWithLeadingZeroes[i]) bitStrings[i] = BitUtils.TRUE_STRING;
                else bitStrings[i] = BitUtils.FALSE_STRING;
            }
            if (this.table.get(rowNum)) bitStrings[bitStrings.length-1] = BitUtils.TRUE_STRING;
            else bitStrings[bitStrings.length-1] = BitUtils.FALSE_STRING;

            row(sb, maxLength, parametersSize, bitStrings, bitStrings[bitStrings.length-1]);
        }

        horizontalLine(sb, maxLength, parametersSize);

        return sb.toString();
    }

    private static void row(StringBuilder sb, int maxLength, int parametersQuantity,
                            String[] parameters, String nameOfResult) {
        for (int i = 0; i < parametersQuantity + 1; i++) {
            if (i == parametersQuantity) {
                sb.append('|');
                int parameterLength = nameOfResult.length();
                for (int j = 0; j < maxLength - parameterLength; j++) {
                    sb.append(' ');
                }
                sb.append(nameOfResult);
                break;
            }

            sb.append('|');
            int parameterLength = parameters[i].length();
            for (int j = 0; j < maxLength - parameterLength; j++) {
                sb.append(' ');
            }
            sb.append(parameters[i]);
        }
        sb.append('|');
        sb.append('\n');
    }

    private static void horizontalLine(StringBuilder sb, int maxLength, int parametersQuantity) {
        for (int i = 0; i < parametersQuantity + 1; i++) {
            for (int j = 0; j < maxLength + 1; j++) sb.append('-');
        }
        sb.append('-');
        sb.append('\n');
    }
}
