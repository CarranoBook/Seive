/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeseive;

import java.time.Instant;

/**
 *
 * @author nbleier
 */
public class PrimeSeive {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Instant b = Instant.now();
        
        Sieve test = new Sieve(100);
        int[] p = test.toArray();
        int s = test.getSemiPrimePair();
        Instant e = Instant.now();
        
        System.out.println(s);
        long d = e.toEpochMilli() -b.toEpochMilli();
        System.out.println(d);
        
        
        
    }
    
}
