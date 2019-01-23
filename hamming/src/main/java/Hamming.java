class Hamming {
    String leftStrand;
    String rightStrand;
    int distance = 0;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        for (int i = 0; i < this.leftStrand.length(); i++){
          if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)){
            this.distance = this.distance + 1;
          }
        }
        return this.distance;

    }

}
