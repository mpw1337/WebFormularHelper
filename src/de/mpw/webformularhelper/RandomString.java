package de.mpw.webformularhelper;

import java.util.Random;

/**
 * Created by Markus on 30.07.2014.
 */
class RandomString {

    private static final char[] symbols;
    private static final char[] alpha;

    static {
        StringBuilder tmp = new StringBuilder(10);
        StringBuilder tmp2 = new StringBuilder(10);
        for (char ch = '0'; ch <= '9'; ++ch)
            tmp.append(ch);
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            tmp.append(ch);
            tmp2.append(ch);
        }

        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            tmp.append(ch);
            tmp2.append(ch);
        }
        symbols = tmp.toString().toCharArray();
        alpha = tmp2.toString().toCharArray();
    }

    private final Random random = new Random();

    private final char[] buf;

    public RandomString(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }

    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = alpha[random.nextInt(alpha.length)];
        return new String(buf);
    }

}
