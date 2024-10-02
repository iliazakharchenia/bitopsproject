package core.boolfunction;

import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.function.Consumer;

class ArgumentsNamesSetWrapper {
    private final LinkedHashSet<String> set;
    private final UUID uuid = UUID.randomUUID();

    public final void forEach(Consumer<? super String> action) {
        for (String name: this.set) {
            action.accept(name);
        }
    }

    public int size() {
        return this.set.size();
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArgumentsNamesSetWrapper that)) return false;

        return uuid.equals(that.uuid);
    }

    @Override
    public String toString() {
        var sb = new StringBuffer();
        set.forEach(str -> {
            sb.append(str).append(',').append(' ');
        });
        return "ArgumentsNamesSetWrapper{" + sb + "}";
    }

    public ArgumentsNamesSetWrapper(String...names) {
        this.set = new LinkedHashSet<>();
        for (String name : names) {
            boolean isAdded = this.set.add(name);
            if (!isAdded)
                throw new RuntimeException("Name can't be added to the collection!");
        }
    }
}
