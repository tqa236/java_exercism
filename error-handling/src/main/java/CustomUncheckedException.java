class CustomUncheckedException extends RuntimeException {

  CustomUncheckedException() {
    throw new UnsupportedOperationException("This is the detail message.");
  }

  CustomUncheckedException(String message) {
    throw new UnsupportedOperationException("This is the detail message.");
  }
}
