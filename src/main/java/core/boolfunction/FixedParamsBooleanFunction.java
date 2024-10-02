package core.boolfunction;

public class FixedParamsBooleanFunction implements PrimitiveBooleanFunction {
    private final ArgumentsNamesSetWrapper namesSet;
    private final PrimitiveBooleanFunction function;

    public FixedParamsBooleanFunction(ArgumentsNamesSetWrapper namesSet, PrimitiveBooleanFunction function) {
        this.namesSet = namesSet;
        this.function = function;
    }

    public int size() {
        return this.namesSet.size();
    }

    @Override
    public boolean process(boolean... bits) {
        if (bits.length != namesSet.size())
            throw new IllegalArgumentException("Arguments length should be the same with a function");

        return this.function.process(bits);
    }
}
