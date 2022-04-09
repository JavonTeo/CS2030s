/**
 * The Transformer interface that can transform a type T
 * to type U.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai (Lab 14J)
 */
public interface Transformer<T, U> {
  public abstract U transform(T t);
}
