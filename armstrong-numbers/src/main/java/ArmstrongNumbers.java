class ArmstrongNumbers {
  boolean isArmstrongNumber(int numberToCheck) {
    int number = numberToCheck;
    int armstrongNumbers = 0;
    int numDigit = (int) Math.ceil(Math.log10(number));
    while (number > 0) {
      armstrongNumbers += (int) Math.pow(number % 10, numDigit);
      number = number / 10;
    }
    return armstrongNumbers == numberToCheck;
  }
}
