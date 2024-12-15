class PrimeCalculator {

    public int nth(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Prime number index must be a positive integer.");
        }

        int count = 0;
        int number = 1;
        while (count < n) {
            number++;
            if (isPrime(number)) {
                count++;
            }
        }
        return number;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
