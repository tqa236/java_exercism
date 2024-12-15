class Hamming {
  private String leftStrand;
  private String rightStrand;
  private int hammingDistance;

  Hamming(String leftStrand, String rightStrand) {
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("strands must be of equal length");
    }
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
    this.hammingDistance = calculateHammingDistance();
  }

  private int calculateHammingDistance() {
    int distance = 0;
    for (int i = 0; i < leftStrand.length(); i++) {
      if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
        distance++;
      }
    }
    return distance;
  }

  public int getHammingDistance() {
    return hammingDistance;
  }
}
