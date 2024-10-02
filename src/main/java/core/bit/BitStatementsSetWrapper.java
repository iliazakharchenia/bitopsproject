package core.bit;

import java.util.LinkedHashSet;
import java.util.UUID;

public class BitStatementsSetWrapper {
    private final LinkedHashSet<FinalBit> set;
    private final UUID uuid = UUID.randomUUID();

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitStatementsSetWrapper that)) return false;

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

    public BitStatementsSetWrapper(FinalBit...bits) {
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
