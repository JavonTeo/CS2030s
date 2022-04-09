/**
 * CS2030S Lab 5 * AY20/21 Semester 2
 *
 * @author A0233706J (Lab 14J)
 */

package cs2030s.fp;

import java.util.NoSuchElementException;

public abstract class Maybe<T> {
  private static final None n = new None();

  public static class None extends Maybe<Object> {
    @Override
    public String toString() {
      String s = String.format("[]");
      return s;
    }

    @Override
    protected Object get() throws NoSuchElementException {
      throw new NoSuchElementException();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof None && this == obj) {
        return true;
      } else {
        return false;
      }
    }

    @Override
    public Maybe<Object> filter(BooleanCondition<? super Object> bC) {
      return Maybe.none();
    }

    @Override
    public <S> Maybe<S> map(Transformer<? super Object, ? extends S> tr) {
      return Maybe.none();
    }

    @Override
    public <U> Maybe<U> flatMap(Transformer<? super Object, ? extends Maybe<? extends U>> tr) {
      return Maybe.none();
    }

    @Override
    public Object orElse(Object o) {
      return o;
    }

    @Override
    public <S extends Object> S orElseGet(Producer<S> p) {
      return p.produce();
    }
  }

  public static final class Some<T> extends Maybe<T> {
    private T value;

    public Some(T value) {
      this.value = value;
    }

    @Override
    public String toString() {
      String s;
      if (this.value == null) {
        s = String.format("[null]");
      } else {
        s = String.format("[%s]", this.value);
      }
      return s;
    }

    @Override
    protected T get() {
      return this.value;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if (obj instanceof Some<?>) {
        Some<?> s = (Some<?>) obj;
        if (this.value == null) {
          return s.value == null;
        } else if (s.value == null) {
          return this.value == null;
        }
        return this.value.equals(s.value);
      } else {
        return false;
      }
    }

    @Override
    public Maybe<T> filter(BooleanCondition<? super T> bC) {
      if (this.value != null && !bC.test(this.value)) {
        return Maybe.none();
      } else {
        return this;
      }
    }

    @Override
    public <S> Maybe<S> map(Transformer<? super T, ? extends S> tr) {
      return Maybe.some(tr.transform(this.value));
    }

    @Override
    public <U> Maybe<U> flatMap(Transformer<? super T, ? extends Maybe<? extends U>> tr) {
      if (this.get() == null) {
        return Maybe.none();
      }
      @SuppressWarnings("unchecked")
      Maybe<U> m = (Maybe<U>) tr.transform(this.get());
      return m;
    }

    @Override
    public T orElse(T t) {
      return this.get();
    }

    @Override
    public <S extends T> T orElseGet(Producer<S> p) {
      return this.get();
    }
  }

  public static <T> Maybe<T> none() {
    @SuppressWarnings("unchecked")
    Maybe<T> m = (Maybe<T>) Maybe.n;
    return m;
  }

  public static <T> Some<T> some(T t) {
    return new Some<T>(t);
  }

  public static <T> Maybe<T> of(T t) {
    if (t == null) {
      Maybe<T> m = Maybe.none();
      return m;
    } else {
      return Maybe.some(t);
    }
  }

  protected abstract T get();

  public abstract Maybe<T> filter(BooleanCondition<? super T> bC);

  public abstract <S> Maybe<S> map(Transformer<? super T, ? extends S> tr);

  public abstract <U> Maybe<U> flatMap(Transformer<? super T, ? extends Maybe<? extends U>> tr);

  public abstract T orElse(T t);

  public abstract <S extends T> T orElseGet(Producer<S> p);
}
