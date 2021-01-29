package testApp;

import java.util.Objects;

/**
 *
 * @author Luk
 */
public class Pairs {
    int a;
    int b;

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
