package core.boolfunction;

import core.bit.Bit;
import core.bit.BitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BooleanFunctionUtilsTest {

    @Test
    void booleanFunctionShouldReturnObjectsWithCorrectStatements() {
        // not(xor(bits))
        BooleanFunction function1 = bits -> new Bit(BitUtils.not(new Bit(BitUtils.xor(bits))));
        // and(bits)
        BooleanFunction function2 = bits -> new Bit(BitUtils.and(bits));

        Assertions.assertTrue(function1.process(new Bit(true), new Bit(true)).isTrue());
        Assertions.assertTrue(function2.process(
                    new Bit(true), new Bit(true), new Bit(true)
                ).isTrue());
    }

    @Test
    void processUtilsShouldReturnCorrectResult() {
        // not(xor(bits))
        BooleanFunction function = bits -> new Bit(BitUtils.not(new Bit(BitUtils.xor(bits))));
        var answer = BooleanFunctionUtils.process(function, new Bit(true), new Bit(true));

        Assertions.assertTrue(answer.isTrue());
    }

    @Test
    void primitiveProcessShouldReturnCorrectStatement() {
        // nand(bits)
        PrimitiveBooleanFunction function = bits -> BitUtils.not(BitUtils.and(bits));

        Assertions.assertFalse(function.process(true, true, true));
    }
}
