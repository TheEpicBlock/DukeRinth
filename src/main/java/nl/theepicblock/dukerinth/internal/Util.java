package nl.theepicblock.dukerinth.internal;

public class Util {
    public static boolean isOk(int status) {
        return status >= 200 && status <= 299;
    }
}
