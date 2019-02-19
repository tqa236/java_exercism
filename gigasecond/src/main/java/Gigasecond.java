import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
  private LocalDateTime birthDateTime;
  private static final int GIGASECOND = 1000000000;

  public Gigasecond(LocalDate birthDate) {
    birthDateTime = birthDate.atStartOfDay();
  }

  public Gigasecond(LocalDateTime birthDateTime) {
    this.birthDateTime = birthDateTime;
  }

  public LocalDateTime getDateTime() {
    return birthDateTime.plusSeconds(GIGASECOND);
  }
}
