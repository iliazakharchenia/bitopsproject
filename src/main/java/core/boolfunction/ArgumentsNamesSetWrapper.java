package core.boolfunction;

import java.util.LinkedHashSet;
import java.util.UUID;

/**
 * That class is used for encapsulate the names of the
 * params of the fixed params functions wrappers.
 *
 * @see FixedParamsBooleanFunction
 */
public class ArgumentsNamesSetWrapper {
    private final LinkedHashSet<String> set;
    private final UUID uuid = UUID.randomUUID();

    public String getNameOfParam(int paramNumber) {
        if (paramNumber >= set.size() || paramNumber < 0)
            throw new IllegalArgumentException("Parameter number should be >= 0 and <= size of arguments set!");

        int index = 0;
        for (String name: set) {
            if (index == paramNumber) return name;
            index++;
        }

        throw new IllegalArgumentException("Parameter with such number isn't exists!");
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
