package core.truthtable;

import core.boolfunction.PrimitiveBooleanFunction;

/**
 * Interface for operation with the instances like
 * tables of truth.
 *
 * @see    FinalTruthTableForFixedBooleanFunction
 * @author Iliya Zakharchenia
 */
public interface TruthTable extends PrimitiveBooleanFunction {

    String getNameOfParamByIndex(int param);

    String getNameOfResult();

    int getParametersSize();
}
