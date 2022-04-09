package cs2030s.fp;

/**
 * A wrapper containing a lazy value, stored in
 * a Maybe wrapper, which is not evaluated until
 * the value is needed.
 *
 * @author A0233706J (Lab 14J)
 * @version CS2030S AY 21/22 Sem 2
 */
public class Lazy<T> {
  /** The producer that produces the value when needed. */
  private Producer<? extends T> producer;

  /** The Maybe wrapper containing the value to be evaluated. */
  private Maybe<T> value;

  /**
   * A private constructor to intialize the Maybe wrapper
   * with the given value.
   *
   * @param value The given value to wrap around.
   */
  private Lazy(T value) {
    this.value = Maybe.some(value);
  }

  /**
   * A private constructor to intialize the producer
   * with the given one.
   *
   * @param producer The given producer to initialize.
   */
  private Lazy(Producer<? extends T> producer) {
    this.producer = producer;
    this.value = Maybe.none();
  }

  /**
   * A factory method to create an instance of the Lazy
   * object with the given value.
   *
   * @param <T> The type of the value to initialize the Lazy object with.
   * @param v The given value to initialize.
   * @return The Lazy object created.
   */
  public static <T> Lazy<T> of(T v) {
    return new Lazy<T>(v);
  }

  /**
   * A factory method to create an instance of the Lazy
   * object with the given value.
   *
   * @param <T> The type of the value produced by the Producer.
   * @param s The given producer to initialize.
   * @return The Lazy object created.
   */
  public static <T> Lazy<T> of(Producer<? extends T> s) {
    return new Lazy<T>(s);
  }

  /**
   * Evaluates the value if the value is not already available
   * in the Maybe wrapper value, else, returns the value
   * contained in the wrapper.
   *
   * @return The evaluated value.
   */
  public T get() {
    T t = this.value.orElseGet(producer);
    this.value = Maybe.some(t);
    return t;
  }

  /**
   * Return "?" if the value is not yet available,
   * else, return the string representation of the value.
   *
   * @return The string representation of the value.
   */
  public String toString() {
    return this.value.map(x -> String.valueOf(x)).orElse("?");
  }

  /**
   * Lazily creates a new Lazy object with the value transformed by
   * the given transformer.
   *
   * @param <S> The type of the transformed value.
   * @param transformer The transformer for transforming the value.
   * @return The created Lazy object with the transformed value.
   */
  public <S> Lazy<S> map(Transformer<? super T, ? extends S> transformer) {
    return Lazy.<S>of(() -> transformer.transform(this.get()));
  }

  /**
   * Lazily creates a new Lazy object with the value transformed by
   * the given transformer, flattened by 1 level.
   *
   * @param <U> The type of the transformed value.
   * @param transformer The transformer for transforming the value.
   * @return The created Lazy object flattened with the transformed value.
   */
  public <U> Lazy<U> flatMap(Transformer<? super T, ? extends Lazy<? extends U>> transformer) {
    return Lazy.<U>of(() -> transformer.transform(this.get()).get());
  }

  /**
   * Lazily tests if the value passes the test given by
   * the given BooleanCondition.
   *
   * @param bC The BooleanCondition to test with.
   * @return The Lazy object containing the boolean value.
   */
  public Lazy<Boolean> filter(BooleanCondition<? super T> bC) {
    return Lazy.<Boolean>of(() -> bC.test(this.get()));
  }

  /**
   * Eagerly compares the this object with the given object.
   *
   * @param obj The given object to compare with.
   * @return The boolean indicating if the two objects are equal.
   */
  @Override
  public boolean equals(Object obj) {
    T t = this.get();
    if (obj instanceof Lazy<?>) {
      Lazy<?> lazy = (Lazy<?>) obj;
      return t.equals(lazy.get());
    } else {
      return false;
    }
  }

  /**
   * Combine this value with the given value to create a
   * Lazy object with the combined result.
   *
   * @param <S> The type of the value in another.
   * @param <R> The type of the combined result.
   * @param another The Lazy object.
   * @param combiner The interface comtaining the combine method.
   * @return The Lazy object with the combined result.
   */
  public <S, R> Lazy<R> combine(Lazy<S> another, 
      Combiner<? super T, ? super S, ? extends R> combiner) {
    return Lazy.<R>of(() -> combiner.combine(this.get(), another.get()));
  }
}
