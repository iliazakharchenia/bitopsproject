package core.bit;

public abstract class BitUtils {
    public final static String DEFAULT_NAME = "UNNAMED";
    public final static String FALSE_STRING = "0";
    public final static String TRUE_STRING = "1";

    public static boolean not(Bit bit) {
        return !bit.isTrue();
    }

    public static boolean not(boolean bit) {
        return !bit;
    }

    public static boolean and(Bit...bits) {
        for (Bit bit: bits) {
            if (bit.isFalse()) return false;
        }
        return true;
    }

    public static boolean and(boolean...bits) {
        for (boolean bit: bits) {
            if (!bit) return false;
        }
        return true;
    }

    public static boolean or(Bit...bits) {
        for (Bit bit: bits) {
            if (bit.isTrue()) return true;
        }
        return false;
    }

    public static boolean or(boolean...bits) {
        for (boolean bit: bits) {
            if (bit) return true;
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

    public static boolean xor(boolean...bits) {
        boolean containsTrueBit = false;
        boolean containsFalseBit = false;
        for (boolean bit: bits) {
            if (!bit) {
                containsFalseBit = true;
            } else {
                containsTrueBit = true;
            }
            if (containsTrueBit && containsFalseBit) return true;
        }
        return false;
    }

    public static int numberFromBitSequence(boolean... bits) {
        int sum = 0;
        int len = bits.length;

        for (int i = len-1; i > -1; i = i-1) {
            if (bits[i]) sum += Math.pow(2, len-i-1);
        }

        return sum;
    }

    public static boolean[] bitSequenceFromNumber(int number) {
        if (number == 0) return new boolean[]{false};
        if (number == 1) return new boolean[]{true};

        int length = (int) (Math.ceil(Math.log(number+0.1)/Math.log(2)));
        boolean[] sequence = new boolean[length];
        for (int i = length-1; i > -1; i--) {
            if ((number % Math.pow(2, length-i-1)) % 2 == 0) sequence[i] = false;
            else sequence[i] = true;
        }

        return sequence;
    }
}
