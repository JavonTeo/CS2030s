/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY21/22 Semester 2
 *
 * @author Javon Teo Tze Kai (Group 14J)
 */
public class Box<T> {
  private final T obj;
  private final static Box<?> EMPTY_BOX = new Box<>(null);

  private Box(T obj) {
    this.obj = obj;
  }

  @Override
  public boolean equals(Object obj2) {
    if (obj2 instanceof Box<?>) {
      Box<?> o2 = (Box<?>) obj2;
      if (!this.isPresent() || !o2.isPresent()) {
        return this.obj == o2.obj;
      }
      if (this.obj.equals(o2.obj)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    if (!this.isPresent()) {
      return "[]";
    } else {
      String str = String.format("[%s]", this.obj);
      return str;
    }
  }

  public static <T> Box<T> of(T o) {
    if (o == null) {
      return null;
    }
    Box<T> box = new Box<T>(o);
    return box;
  }

  public static <T> Box<T> empty() {
    @SuppressWarnings("unchecked")
    Box<T> box = (Box<T>) EMPTY_BOX;
    return box;
  }

  public boolean isPresent() {
    if (this.obj == null) {
      return false;
    } else {
      return true;
    }
  }

  public static <T> Box<T> ofNullable(T o) {
    if (o == null) {
      return Box.empty();
    } else {
      return Box.of(o);
    }
  }

  public Box<T> filter(BooleanCondition<? super T> BC) {
    if (!this.isPresent()) {
      return Box.empty();
    }
    boolean passTest = BC.test(this.obj);
    if (passTest) {
      return this;
    } else {
      return Box.empty();
    }
  }

  public <U> Box<U> map(Transformer<? super T, U> transformer) {
    if (!this.isPresent()) {
      return Box.empty();
    } else {
      U newValue = transformer.transform(this.obj);
      return Box.ofNullable(newValue);
    }
  }
}
