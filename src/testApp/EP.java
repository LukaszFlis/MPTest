package testApp;

/**
 *
 * @author Luk
 */
public class EP {

    //Id EP
    private Pairs id;
    //CPU Clock
    private int t;

    /**
     * initializing constructor
     *
     * @param id coordinates of EP
     * @param t cpu clock
     */
    public EP(Pairs id, int t) {
        this.id = id;
        this.t = t;
    }
    
    //list of getters
    public Pairs getId() {
        return id;
    }

    public int getT() {
        return t;
    }
    
    //list of setters
    public void setId(Pairs id) {
        this.id = id;
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "{[" + id + "]," + t + "}";
    }
}
