package core.boolfunction;

import core.bit.Bit;

/**
 * Functional interface for lambda type creation
 * of PrimitiveBooleanFunction anonymous classes with only
 * boolean process(Bit...bits) method.
 * <p>
 * Example: PrimitiveBooleanFunction function = bits -> BitUtils.and(bits);
 *          boolean answer = function.process(true, true); // equals true
 *
 * @see    BooleanFunctionUtils
 * @see    BooleanFunction
 * @see    core.bit.BitUtils
 * @author Iliya Zakharchenia
 */
@FunctionalInterface
public interface PrimitiveBooleanFunction {

    /**
     * Return a boolean statement from boolean varargs.
     *
     * @param  bits  the boolean type varargs (bit1, bit2, bit3...)
     */
    boolean process(boolean...bits);
}
