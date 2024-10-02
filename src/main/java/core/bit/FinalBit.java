package core.bit;

import core.boolfunction.BooleanFunction;

/**
 * Class which objects are a wrappers for
 * boolean type variables with a specified name.
 * It useful for a bit binary named variables for
 * a high level binary logic implementation.
 * <br><br>
 * That one implements a logic of final statement
 * bit.
 *
 * @see    BitUtils
 * @see    Bit
 * @see    BooleanFunction
 * @author Iliya Zakharchenia
 */
public class FinalBit extends Bit {
    @Override
    public String toString() {
        return "Final" + super.toString();
    }

    @Override
    public synchronized boolean invert() {
        return this.isTrue();
    }

    public FinalBit(boolean statement, String name) {
        super(statement, name);
    }

    public static FinalBit from(Bit bit) {
        if (bit.name().equals(BitUtils.DEFAULT_NAME))
            throw new RuntimeException("Bit object should have a name different then default name '"
                    + BitUtils.DEFAULT_NAME + "'");

        return new FinalBit(bit.isTrue(), bit.name());
    }

    public static FinalBit from(Bit bit, String name) {
        if (name.equals(BitUtils.DEFAULT_NAME))
            throw new RuntimeException("Bit object should have a name different then default name '"
                    + BitUtils.DEFAULT_NAME + "'");

        return new FinalBit(bit.isTrue(), name);
    }
}
