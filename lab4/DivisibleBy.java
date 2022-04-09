/**
 * A boolean condition with an integer parameter y that can be 
 * apply to another integer x.  Returns true if x is divisible 
 * by y, false otherwise.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai (Lab 14J)
 */
public class DivisibleBy implements BooleanCondition<Integer> {
  private int divisor;

  public DivisibleBy(int divisor) {
    this.divisor = divisor;
  }

  @Override
  public boolean test(Integer dividend) {
    if (dividend % this.divisor == 0) {
      return true;
    } else {
      return false;
    }
  }
}
