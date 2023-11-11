package core.bit;

public abstract class BitUtils {

    public final static String DEFAULT_NAME = "UNNAMED";

    public final static String FALSE_STRING = "0";

    public final static String TRUE_STRING = "1";

    public static boolean not(Bit bit) {
        return !bit.isTrue();
    }

    public static boolean and(Bit...bits) {
        for (Bit bit: bits) {
            if (bit.isFalse()) return false;
        }
        return true;
    }

    public static boolean or(Bit...bits) {
        for (Bit bit: bits) {
            if (bit.isTrue()) return true;
        }
        return false;
    }

    public static boolean xor(Bit...bits) {
        boolean containsTrueBit = false;
        boolean containsFalseBit = false;
        for (Bit bit: bits) {
            if (bit.isFalse()) {
                containsFalseBit = true;
            } else {
                containsTrueBit = true;
            }
            if (containsTrueBit && containsFalseBit) return true;
        }
        return false;
    }
}
