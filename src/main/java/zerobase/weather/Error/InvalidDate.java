package zerobase.weather.Error;

public class InvalidDate extends RuntimeException {
  private static final String MESSAGE = "너무 과건 혹은 미래의 날짜입니다.";

  public InvalidDate() {
    super(MESSAGE);
  }
}
