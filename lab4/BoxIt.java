/**
 * Takes an item and return the item in a box.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai (Lab 14J)
 */
public class BoxIt<T> implements Transformer<T, Box<T>> {
  @Override
  public Box<T> transform(T o) {
      return Box.ofNullable(o);
  }
}
