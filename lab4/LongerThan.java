/**
 * A boolean condition with parameter x that can be applied to
 * a string.  Returns true if the string is longer than x; false
 * otherwise.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai (Lab 14J)
 */
public class LongerThan implements BooleanCondition<String> {
  private int limit;

  public LongerThan(int limit) {
    this.limit = limit;
  }

  @Override
  public boolean test(String str) {
    int strLength = str.length();
    if (strLength > this.limit) {
      return true;
    } else {
      return false;
    }
  }
}
