package core.bit;

import java.util.Objects;

public class Bit {

    private final String name;

    private boolean statement;

    private synchronized void setStatement(boolean statement) {
        this.statement = statement;
    }

    private synchronized boolean getStatement() {
        return this.statement;
    }

    public String name() {
        return this.name;
    }

    public boolean isTrue() {
        return this.getStatement();
    }

    public boolean isFalse() {
        return !this.getStatement();
    }

    public String statementString() {
        return this.statementToString();
    }

    public synchronized boolean invert() {
        this.setStatement(!this.statement);
        return this.statement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bit bit)) return false;
        return statement == bit.statement && name.equals(bit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, statement);
    }

    @Override
    public String toString() {
        return "Bit{" +
                "name='" + this.name + '\'' +
                ", statement='" + this.statementToString() +
                "'}";
    }

    private String statementToString() {
        if (this.getStatement()) return BitUtils.TRUE_STRING;
        return BitUtils.FALSE_STRING;
    }

    /**
     * Constructs a Bit object with a bool statement and a
     * BitUtils.DEFAULT_NAME name within.
     *
     * @param  statement  the bool statement within
     * @see         BitUtils
     */
    public Bit(boolean statement) {
        this.statement = statement;
        this.name = BitUtils.DEFAULT_NAME;
    }

    /**
     * Constructs a Bit object with a bool statement and a
     * name within.
     *
     * @throws  IllegalArgumentException  when name is null or equals BitUtils.DEFAULT_NAME
     * @param  statement  the bool statement within
     * @param  name  name of Bit object
     * @see         BitUtils
     */
    public Bit(boolean statement, String name) {
        if (name == null) throw new IllegalArgumentException("Argument 'name' should be not null!");
        if (name.equals(BitUtils.DEFAULT_NAME)) throw new IllegalArgumentException(
                "Argument 'name' should be not equal default name which is '"
                        +BitUtils.DEFAULT_NAME+"'!");
        this.statement = statement;
        this.name = name;
    }
}
