package core.boolfunction;

import core.bit.Bit;

/**
 * Functional interface for lambda type creation
 * of BooleanFunction anonymous classes with only
 * Bit process(Bit...bits) method.
 * <p>
 * Example: BooleanFunction function = bits -> new Bit(BitUtils.and(bits));
 *          Bit answer = function.process(new Bit(true), new Bit(true)); // equals (new Bit(true))
 *
 * @see    Bit
 * @see    BooleanFunctionUtils
 * @author Iliya Zakharchenia
 */
@FunctionalInterface
public interface BooleanFunction {

    /**
     * Return a Bit object with a bool statement.
     *
     * @param  bits  the Bit type varargs (bit1, bit2, bit3...)
     * @see    Bit
     */
    Bit process(Bit...bits);
}
