/**
 * A conditional statement that returns either true of false.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai(Lab 14J)
 */
public interface BooleanCondition<T> {
  public abstract boolean test(T t);
}
