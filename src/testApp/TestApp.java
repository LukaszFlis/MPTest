package testApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Luk
 */
public class TestApp {

    private static final Scanner sc = new Scanner(System.in);
    //array mapping  for LU graf
    private static final int[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, 0}};
    //space function
    private static final int[][] fs = new int[2][3];
    //time function
    private static final int[] ft = new int[3];
    //coordinates of vertex
    private static ArrayList<Vertice> k = new ArrayList<Vertice>();
    //list of CPU clocks
    private static ArrayList<Integer> t = new ArrayList<>();
    // list of EP vertex coordinates
    private static ArrayList<Pairs> fsK = new ArrayList<>();
    // list of EP[coordinates, T]
    private static ArrayList<EP> ep = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initFs(fs);
        System.out.println("Został spełniony warunek lokalnośći : " + isFsGood(fs, d));
        printFs(fs);
        initFt(ft);
        System.out.println("Został spełniony warunek przyczynowości " + isFtGood(ft, d));
        printFt(ft);
        //initK();// main thread zatrzymuje się na tej metodzie/ metoda nie jest wykonywana ?! 
        k.add(new Vertice(1, 2, 1));
        k.add(new Vertice(1, 2, 2));
        k.add(new Vertice(1, 2, 3));
        k.add(new Vertice(1, 2, 4));
        k.add(new Vertice(1, 3, 1));
        k.add(new Vertice(1, 3, 2));
        k.add(new Vertice(1, 3, 3));
        k.add(new Vertice(1, 3, 4));
        k.add(new Vertice(1, 4, 1));
        k.add(new Vertice(1, 4, 2));
        k.add(new Vertice(1, 4, 3));
        k.add(new Vertice(1, 4, 4));
        k.add(new Vertice(2, 3, 2));
        k.add(new Vertice(2, 3, 3));
        k.add(new Vertice(2, 3, 4));
        k.add(new Vertice(2, 4, 2));
        k.add(new Vertice(2, 4, 3));
        k.add(new Vertice(2, 4, 4));
        k.add(new Vertice(3, 4, 3));
        k.add(new Vertice(3, 4, 4));
        printK();
        setFsK();
        setFtK();
        setEP();
        System.out.println("Macierz EP spełnia warunki:" + isEpGood());
        printEP();
    }
    
   //static Comparator<EP> compareById = (EP o1, EP o2) -> o1.getId().compareTo( o2.getId() );

    /**
     * Initialize elements of the Fs array
     *
     * @param a 2d array
     */
    public static void initFs(int[][] a) {
        var nr = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("Podaj " + nr + " element macierzy Fs: ");
                a[i][j] = sc.nextInt();
                nr++;
            }
        }
    }

    /**
     * Initialize elements of the Ft array
     *
     * @param a array
     */
    public static void initFt(int[] a) {
        System.out.println("");
        var nr = 1;
        for (int i = 0; i < a.length; i++) {
            System.out.print("Podaj " + nr + " element macierzy Ft: ");
            a[i] = sc.nextInt();
            nr++;
        }
    }

    /**
     * Initialize elements of the Vertice list
     */
    public static void initK() { //ta metoda nie odpala się
        System.out.println("");
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int nr = 1;
        for (int i = 0; i < 20; i++) {
            System.out.print("Podaj w1 " + nr + " wierzchołka: ");
            w1 = sc.nextInt();
            System.out.print("Podaj w2 " + nr + " wierzchołka: ");
            w2 = sc.nextInt();
            System.out.print("Podaj w3 " + nr + " wierzchołka: ");
            w3 = sc.nextInt();
            k.add(new Vertice(w1, w2, w3));
            nr++;
        }
    }

    /**
     * Check condition of causality Ft*dj >= 1
     *
     * @param ft vector Ft
     * @param d Graph mapping array
     * @return true if the condition is met
     */
    public static boolean isFtGood(int[] ft, int[][] d) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i < d[0].length; i++) {
            for (int j = 0; j < d.length; j++) {
                sum += ft[j] * d[j][i];
            }
            if (sum < 1) {
                test = false;
                break;
            }
        }
        return test;
    }

    /**
     * Check connection locality condition Fs*dj = -1 v 0 v 1
     *
     * @param f array Fs
     * @param d Graph mapping array
     * @return true if the condition is met
     */
    public static boolean isFsGood(int[][] f, int[][] d) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i < d[0].length; i++) {
            for (int j = 0; j < d.length; j++) {
                sum += f[0][j] * d[j][i];
            }
            if (sum < -1 || sum > 1) {
                test = false;
                break;
            }
            for (int j = 0; j < d.length; j++) {
                sum += f[1][j] * d[j][i];
            }
            if (sum < -1 || sum > 1) {
                test = false;
                break;
            }
        }
        return test;
    }
    public static boolean isEpGood(){
        Collections.sort(ep,new SortComparator());// comparato, który nie działa
        boolean test = false;
        for (int i = 0; i < 20; i++) {
            if (ep.get(i+1).getId().equals(ep.get(i).getId()) && ep.get(i+1).getT() != ep.get(i).getT()) {
                test = true;
            } else {
                test = false;
                break;
            }
        }
        
        return test;
    }

    /**
     * Multiply matrix ft with vertice K
     *
     */
    public static void setFtK() {
        var sum = 0;
        for (int i = 0; i < 20; i++) {
            sum = ft[0] * k.get(i).getW1() + ft[1] * k.get(i).getW2() + ft[2] * k.get(i).getW3();
            t.add(sum);
        }
    }

    /**
     * Set list of MP processing element's veritces (fs * k)
     */
    public static void setFsK() {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < 20; i++) {
            sumA = fs[0][0] * k.get(i).getW1() + fs[0][1] * k.get(i).getW2() + fs[0][2] * k.get(i).getW3();
            sumB = (fs[1][0] * k.get(i).getW1() + fs[1][1] * k.get(i).getW2() + fs[1][2] * k.get(i).getW3());
            fsK.add(new Pairs(sumA, sumB));
        }
    }

    /**
     * Set list of MP processing element's (ep id + cpu clock)
     */
    public static void setEP() {
        for (int i = 0; i < 20; i++) {
            ep.add(new EP(fsK.get(i), t.get(i)));
        }
    }

    /**
     * Print in preety format matrix Fs to console
     *
     * @param a 2D array
     */
    public static void printFs(int[][] a) {
        System.out.println("");
        System.out.println("Macierz Fs");
        for (int i = 0; i < a.length; i++) {
            System.out.print("|");
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    /**
     * Print in preety format matrix Ft to console
     *
     * @param a 2D array
     */
    public static void printFt(int[] a) {
        System.out.println("");
        System.out.println("Macierz Ft");
        System.out.print("|");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.print("|\n");
    }

    /**
     * Print in preety format list of veritices to console
     */
    public static void printK() {
        System.out.println("");
        System.out.println("Lista wierzchołków grafu");
        for (int i = 0; i < k.size(); i++) {
            System.out.println( (i + 1) + ". " + Arrays.toString(k.get(i).getCoordinates()));
        }
    }

    /**
     * Print in preety format list of veritices to console
     */
    public static void printEP() {
        System.out.println("Macierz elementów przetwarzających");
        for (int i = 0; i < ep.size(); i++) {
            System.out.println("{[" + ep.get(i).getId() + "], " + ep.get(i).getT() + "}");
        }
    }
}
