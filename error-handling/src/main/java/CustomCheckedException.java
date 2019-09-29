class CustomCheckedException extends Exception {

  CustomCheckedException() {
    throw new UnsupportedOperationException("This is the detail message.");
  }

  CustomCheckedException(String message) {
    throw new UnsupportedOperationException("This is the detail message.");
  }
}
