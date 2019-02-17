import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class HandshakeCalculator {
  private static final HashMap<Integer, Signal> values =
      new HashMap<Integer, Signal>() {
        {
          put(4, Signal.WINK);
          put(3, Signal.DOUBLE_BLINK);
          put(2, Signal.CLOSE_YOUR_EYES);
          put(1, Signal.JUMP);
        }
      };

  List<Signal> calculateHandshake(int number) {
    List<Signal> signal = new ArrayList<Signal>();
    String binary = Integer.toBinaryString(number % 32);
    int missing_length = 5 - binary.length();

    for (int i = 0; i < missing_length; i = i + 1) {
      binary = "0" + binary;
    }

    for (Integer i = 4; i > 0; i = i - 1) {
      if (binary.charAt(i) == '1') {
        signal.add(values.get(i));
      }
    }

    if (binary.charAt(0) == '1') {
      Collections.reverse(signal);
    }

    return signal;
  }
}
