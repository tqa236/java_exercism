import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class HandshakeCalculator {
  private static final HashMap<Integer, Signal> actions = new HashMap<Integer, Signal>();

  static {
    actions.put(1, Signal.WINK);
    actions.put(2, Signal.DOUBLE_BLINK);
    actions.put(4, Signal.CLOSE_YOUR_EYES);
    actions.put(8, Signal.JUMP);
  }

  public List<Signal> calculateHandshake(int number) {
    List<Signal> signal = new ArrayList<Signal>();

    actions.forEach(
        (point, action) -> {
          if ((number & point) == point) {
            signal.add(action);
          }
        });

    if ((number & 16) == 16) {
      Collections.reverse(signal);
    }

    return signal;
  }
}
