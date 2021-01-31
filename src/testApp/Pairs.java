package testApp;

import java.util.Objects;

/**
 *
 * @author Luk
 */
public class Pairs {
    //first coordinate of EP
    Integer a;
    //second coordinate of EP
    Integer b;
    
    /**
     *initialization Constructor
     * @param a first coordinate of EP
     * @param b second coordinate of EP
     */
    public Pairs(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
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
        return Objects.equals(a, that.a)
                && Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
