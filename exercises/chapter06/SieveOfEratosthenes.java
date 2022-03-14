package exercises.chapter06;

import exercises.Exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
  * SieveOfEratosthenes
  **/
public class SieveOfEratosthenes extends Exercise {

  public SieveOfEratosthenes(String[] args) {
    super(args);
  } 

  public List<Integer> getPrimes(int max) {
    boolean[] flags = new boolean[max+1];
    Arrays.fill(flags, true);
    
    List<Integer> primes = new ArrayList<>();
    int prime = 2;
    while (prime < flags.length) {
      primes.add(prime);
      crossOff(flags, prime);
      prime = nextPrime(flags, prime);      
    }
    return primes;   
  }

  private int nextPrime(boolean[] flags, int prime) {
    int i = prime + 1;
    for (; i < flags.length && !flags[i]; i++);
    return i;
  }

  private void crossOff(boolean[] flags, int prime) {
    for(int i = prime * prime; i < flags.length; i += prime) {
      flags[i] = false;
    }
  }
  
  public void compute(String[] args) {
    List<Integer> primes = getPrimes(1021);
    System.out.println(primes);
  }

}