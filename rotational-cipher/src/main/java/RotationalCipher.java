class RotationalCipher {
  int shiftKey;

  RotationalCipher(int shiftKey) {
    this.shiftKey = shiftKey % 26;
  }

  String rotate(String data) {
    return data.chars()
        .map(ch -> convertChar(ch))
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

  int convertChar(int ch) {
    if (ch >= 'A' && ch <= 'Z') {
      return ((ch - 'A' + shiftKey) % 26 + 'A');
    } else if (ch >= 'a' && ch <= 'z') {
      return ((ch - 'a' + shiftKey) % 26 + 'a');
    } else {
      return ch;
    }
  }
}
