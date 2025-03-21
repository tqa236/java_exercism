import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
    private Map<Integer, String> dialingCodesMap;

    public DialingCodes() {
        this.dialingCodesMap = new HashMap<>();
    }

    public Map<Integer, String> getCodes() {
        return new HashMap<>(dialingCodesMap);
    }

    public void setDialingCode(Integer code, String country) {
        dialingCodesMap.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialingCodesMap.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!dialingCodesMap.containsKey(code) && !dialingCodesMap.containsValue(country)) {
            dialingCodesMap.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : dialingCodesMap.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer newCode, String country) {
        Integer oldCode = findDialingCode(country);
        if (oldCode != null) {
            dialingCodesMap.remove(oldCode);
            dialingCodesMap.put(newCode, country);
        }
    }
}
