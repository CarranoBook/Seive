/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeseive;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author nbleier
 */
public class Sieve {
    int n;
    int[] p;
        
    public Sieve(int n) {
        this.n = n;
        p = executeSieve();
    }
    
    public int[] toArray() {
        return p;
    }
    
    public int[] getSemiPrimes() {
        int[] s = new int[(n-1)*(n-2)];
        int counter = 0;
        
        
        for ( int i = 1; i < n; i++ ) {
            for ( int j = i+1; j < n; j++ ) {
                s[counter++] = p[i] * p[j];
            }
        }
        return s;
    }
    
    public int getSemiPrimePair() {
        int[] s = getSemiPrimes();
        ArrayList<Integer> possibles = new ArrayList<>();
        ArrayList<Integer> all = new ArrayList<>();
        
        
        for (int i = 0; i<s.length;i++) {
            all.add(s[i]);
            
            if (s[i] % 6 == 5) 
                possibles.add(s[i]);  
        }
        all.sort(null);
        possibles.sort(null);
        
        for (Integer x : possibles) {
            if (all.contains(x + 2))
                return x;
        }
        return -1;
    }
    
    private int[] executeSieve() {
        int[] primes = new int[n];
        primes[0] = 2;
        primes[1] = 3;
        primes[n-1] = -1;
        int counter = 2;
        int i = 5;
        
        while (counter < n) {
            boolean prime1 = true;
            boolean prime2 = true;
            for(int j = 0; j < counter; j++) {
                if (prime1 && i % primes[j] == 0)
                    prime1 = false;
                
                if (prime2 && (i+2) % primes[j] == 0)
                    prime2 = false;
                
                if (!(prime1 || prime2))
                    j = counter;
            }
            
            if (prime1) 
                primes[counter++] = i;
            
            if (prime2 && counter + 2 < n)
                primes[counter++] = i+2;

            i += 6;
        }
        return primes;
    }
    
    
}
