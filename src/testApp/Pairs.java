package testApp;

import java.util.Objects;

/**
 *
 * @author Luk
 */
public class Pairs {
    //first coordinate of EP
    int a;
    //second coordinate of EP
    int b;
    
    /**
     *initialization Constructor
     * @param a first coordinate of EP
     * @param b second coordinate of EP
     */
    public Pairs(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pairs that = (Pairs) o;
        return a == that.a
                && b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
