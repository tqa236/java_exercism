class PhoneNumber {
  private String number;

  PhoneNumber(String number) {
    this.number = isValid(number);
  }

  public String getNumber() {
    return number;
  }

  private String isValid(String number) {
    String illegalCharacters = number.replaceAll("[0-9 ()+\\-\\.]", "");
    if (illegalCharacters.length() > 0) {
      throw new IllegalArgumentException(
          "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.");
    }
    number = number.replaceAll("[^0-9]", "");
    if ((number.length() < 10) || (number.length() > 11)) {
      throw new IllegalArgumentException("Number must be 10 or 11 digits");
    } else if (number.charAt(number.length() - 10) < '2') {
      throw new IllegalArgumentException(
          "Illegal Area Or Exchange Code. Only 2-9 are valid digits");
    } else if (number.charAt(number.length() - 7) < '2') {
      throw new IllegalArgumentException(
          "Illegal Area Or Exchange Code. Only 2-9 are valid digits");
    } else if ((number.length() == 11) && (number.charAt(0) != '1')) {
      throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
    }
    return number.substring(number.length() - 10);
  }
}
