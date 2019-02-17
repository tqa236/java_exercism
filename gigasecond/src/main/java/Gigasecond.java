import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
  private LocalDateTime birthDateTime;
  private static final int GIGASECOND = 1000000000;

  Gigasecond(LocalDate birthDate) {
    birthDateTime = birthDate.atStartOfDay();
  }

  Gigasecond(LocalDateTime birthDateTime) {
    this.birthDateTime = birthDateTime;
  }

  LocalDateTime getDateTime() {
    return birthDateTime.plusSeconds(GIGASECOND);
  }
}
