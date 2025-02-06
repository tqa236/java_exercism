import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    public List<String> encode(List<Long> numbers) {
        List<String> encodedBytes = new ArrayList<>();
        for (long number : numbers) {
            List<Long> bytes = new ArrayList<>();
            if (number == 0) {
                bytes.add(0L);
            } else {
                while (number > 0) {
                    long byteValue = number & 0x7F;
                    number >>>= 7;
                    if (!bytes.isEmpty()) {
                        byteValue |= 0x80;
                    }
                    bytes.add(0, byteValue);
                }
            }
            for (long b : bytes) {
                encodedBytes.add("0x" + Long.toHexString(b));
            }
        }
        return encodedBytes;
    }

    public List<String> decode(List<Long> bytes) {
        List<String> decodedNumbers = new ArrayList<>();
        long number = 0;
        for (long b : bytes) {
            number = (number << 7) | (b & 0x7F);
            if ((b & 0x80) == 0) {
                decodedNumbers.add("0x" + Long.toHexString(number));
                number = 0;
            }
        }
        if (!decodedNumbers.isEmpty()) {
            return decodedNumbers;
        }
        throw new IllegalArgumentException("Invalid variable-length quantity encoding");
    }
}