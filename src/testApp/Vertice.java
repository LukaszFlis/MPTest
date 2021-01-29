package testApp;

/**
 *
 * @author Luk
 */
public class Vertice {

    private int w1;
    private int w2;
    private int w3;

    public Vertice(int w1, int w2, int w3) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
    }

    public int getW1() {
        return w1;
    }

    public int getW2() {
        return w2;
    }

    public int getW3() {
        return w3;
    }
    
    public int[] getCoordinates() {
        int[] k = {w1, w2, w3};
        return k;
    }

    public void setW1(int w1) {
        this.w1 = w1;
    }

    public void setW2(int w2) {
        this.w2 = w2;
    }

    public void setW3(int w3) {
        this.w3 = w3;
    }

    @Override
    public String toString() {
        return "[" + w1 + ", " + w2 + ", " + w3 + "]";
    }
}
