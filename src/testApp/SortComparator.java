/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testApp;

import java.util.Comparator;

/**
 *
 * @author Luk
 */
public class SortComparator implements Comparator <Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
    
}
