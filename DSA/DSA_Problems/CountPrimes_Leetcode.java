class Solution {
    public int countPrimes(int n) {

        //Algorithm: Sieve of Eratosthenes
        if(n<=1){
            return 0;
        }

        boolean composites[] = new boolean[n];
        //default value of every cell is false meaning every number is prime

        //we iterate over those i, who have their square value less than n
        for(int i = 2; i*i < n; i++){
            //first value to be changed is square of i
            //j increments as a multiple of i
            for(int j = i*i; j < n; j=j+i){
                composites[j] = true;
            }
        }

        //no. of primes
        int primes = 0;

        for(int i = 2; i < n; i++){
            //all values with false are prime numbers
            if(composites[i] == false){
                primes++;
            }
        }

        return primes;
    }
}