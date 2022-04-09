/**
 * The Array for CS2030S 
 *
 * @author Javon Teo (Group 14J) 
 * @version CS2030S AY21/22 Semester 2
 */
class Array<T extends Comparable<T>> { // TODO: Change to bounded type parameter
  private T[] array;
  private int size;

  Array(int size) {
    // TODO
    @SuppressWarnings({"rawtypes", "unchecked"})
    T[] array = (T[]) new Comparable[size];
    this.array = array;
    this.size = size;
  }

  public int getSize() {
    return this.size;
  }

  public void set(int index, T item) {
    // TODO
    this.array[index] = item;
  }

  public T get(int index) {
    // TODO
    return this.array[index];
  }

  public T min() {
    // TODO
    T currentMin = this.array[0];
    for (int i = 1; i < this.size; i++) {
      int comparisonVal = currentMin.compareTo(this.array[i]);
      if (comparisonVal > 0) {
        currentMin = this.array[i];
      }
    }
    return currentMin;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < array.length; i++) {
      s.append(i + ":" + array[i]);
      if (i != array.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
