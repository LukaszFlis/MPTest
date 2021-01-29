package testApp;

/**
 *
 * @author Luk
 */
public class Vertice {

    //cordinates of graph vertice K
    private int w1;
    private int w2;
    private int w3;
    
    /**
     * initialization Constructor
     * @param w1 first coordinate of vertice K
     * @param w2 second coordinate of vertice K
     * @param w3 third coordinates of vertice K
     */
    public Vertice(int w1, int w2, int w3) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
    }
    
    //list of getters
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

    //list of setters
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
