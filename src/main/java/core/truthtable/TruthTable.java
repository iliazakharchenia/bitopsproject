package core.truthtable;

import core.bit.BitStatementsSetWrapper;
import core.bit.FinalBit;
import core.boolfunction.BooleanFunctionUtils;

import java.util.Map;

/**
 * Functional interface for lambda type creation of
 * table of truth implementation anonymous classes.
 * <br><br>
 * Example:
 *
 * @see    core.bit.FinalBit
 * @see    BooleanFunctionUtils
 * @author Iliya Zakharchenia
 */
@FunctionalInterface
public interface TruthTable {

    Map<BitStatementsSetWrapper, FinalBit> getTruthTable();
}
