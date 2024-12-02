package core.boolfunction;

import core.bit.Bit;

/**
 * This utils class in used for
 * from int value.
 * <br>
 * Example: boolean[] x = BitUtils.bitSequenceFromNumber(5);
 * <br>
 * // x == [true, false, true] ('101' in 2ns)
 *
 */
public abstract class BooleanFunctionUtils {

    public static Bit process(BooleanFunction function, Bit...bits) {
        return function.process(bits);
    }

    public static boolean process(PrimitiveBooleanFunction function, boolean...bits) {
        return function.process(bits);
    }
}
