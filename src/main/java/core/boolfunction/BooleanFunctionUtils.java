package core.boolfunction;

import core.bit.Bit;

public abstract class BooleanFunctionUtils {

    public static Bit process(BooleanFunction function, Bit...bits) {
        return function.process(bits);
    }

    public static boolean process(PrimitiveBooleanFunction function, boolean...bits) {
        return function.process(bits);
    }
}
