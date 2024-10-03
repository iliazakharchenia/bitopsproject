package core.truthtable;

import core.bit.BitUtils;
import core.boolfunction.FixedParamsBooleanFunction;

import java.util.LinkedHashMap;
import java.util.Map;

public class FinalTruthTableForFixedBooleanFunction implements TruthTable {
    private final FixedParamsBooleanFunction function;
    private final String nameOfResult;
    private final Map<Integer, Boolean> table = new LinkedHashMap<>();

    public FinalTruthTableForFixedBooleanFunction(FixedParamsBooleanFunction function, String nameOfResult) {
        this.function = function;
        this.nameOfResult = nameOfResult;
        calculateTruthTable(function);
    }

    private void calculateTruthTable(FixedParamsBooleanFunction function) {
        int size = (int) Math.pow(function.size(), 2);
        // todo
    }

    @Override
    public boolean process(boolean... bits) {
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
        return this.getNameOfResult();
    }
}
