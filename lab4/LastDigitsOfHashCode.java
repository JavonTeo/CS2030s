/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai (Lab 14J)
 */
public class LastDigitsOfHashCode implements Transformer<Object, Integer> {
  private int k;

  public LastDigitsOfHashCode(int k) {
    this.k = k;
  }

  @Override
  public Integer transform(Object o) {
    int value = o.hashCode();
    String valueInStr = String.format("%d", value);
    int lenString = valueInStr.length();
    String subStr = valueInStr.substring(lenString - this.k);
    return Integer.parseInt(subStr);
  }
}
