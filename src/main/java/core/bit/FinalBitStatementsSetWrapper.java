package core.bit;

import core.boolfunction.BooleanFunction;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * This class provides a functionality to encapsulate
 * the FinalBit values to the set and can perform an
 * actions over them using the forEach method. It also
 * can perform a function and return a result of the
 * execution of it using a perform method with a name
 * of the future FinalBit result as name in the method
 * parameters.
 *
 */
public class FinalBitStatementsSetWrapper {
    private final Set<FinalBit> set;
    private final UUID uuid = UUID.randomUUID();

    public final void forEach(Consumer<? super FinalBit> action) {
        for (FinalBit bit: this.set) {
            action.accept(bit);
        }
    }

    public final FinalBit perform(BooleanFunction function, String name) {
        Bit[] arr = new Bit[set.size()];
        set.toArray(arr);
        return new FinalBit(function.process(arr).isTrue(), name);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinalBitStatementsSetWrapper that)) return false;

        return uuid.equals(that.uuid);
    }

    @Override
    public String toString() {
        var sb = new StringBuffer();
        set.forEach(finalBit -> {
            sb.append(finalBit.toString()).append(',').append(' ');
        });
        return "BitStatementsSetWrapper{" + sb + "}";
    }

    public FinalBitStatementsSetWrapper(FinalBit...bits) {
        this.set = new LinkedHashSet<>();
        for (FinalBit bit: bits) {
            boolean isAdded = this.set.add(bit);
            if (!isAdded)
                throw new RuntimeException("Final bit object can't be added to the collection!");

            // check if name is unique in the set
            this.set.forEach(el -> {
                if (el != bit) {
                    if (el.name().equals(bit.name()))
                        throw new RuntimeException("Final bit object name is already exists in the collection!");
                }
            });
        }
    }
}
