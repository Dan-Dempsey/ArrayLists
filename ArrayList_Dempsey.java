import java.util.*;

public class ArrayList_Dempsey<E> extends AbstractList<E> implements List<E> {
  private E[] arr;
  private int size;

  ArrayList_Dempsey() {
    arr = (E[]) (new Object[10]);
    size = 0;
  }

  ArrayList_Dempsey(Collection<? extends E> c) {
    arr = (E[]) (new Object[10]);
    this.addAll(c);
    size = c.size();
  }

  ArrayList_Dempsey(int initialCapacity) {
    arr = (E[]) (new Object[initialCapacity]);
    size = 0;
  }

  public E get(int index) {
    if (index >= size || index < 0)
      throw new IndexOutOfBoundsException();
    return arr[index];
  }

  public int size() {
    return size;
  }

  public int indexOf(Object o) {
    for (int i = 0; i < arr.length; i++)
      if (arr[i].equals(o))
        return i;
    return -1;
  }

  public int lastIndexOf(Object o) {
    int last = -1;
    for (int i = 0; i < size; i++)
      if (arr[i].equals(o))
        last = i;
    return last;
  }

  public boolean contains(Object o) {
    if (o == null)
      for (Object x : arr)
        if (x == o)
          return true;
    else for (Object e : arr)
      if (e.equals(o))
        return true;
    return false;
  }

  public boolean add(E e) {
    size++;
    ensureCapacity(size);
    arr[size - 1] = e;
    return true;
  }

  public void add(int index, E e) {
    if (index > size || index < 0)
      throw new IndexOutOfBoundsException();
    size++;
    int counter = 0;
    ensureCapacity(size);
    E[] temp = (E[]) (new Object[size]);
    for (int i = 0; i < size; i++) {
      if (i != index) {
        temp[i] = arr[counter];
        counter++;
      }
    }
    temp[index] = e;
    arr = temp;
  }

  public void clear() {
    arr = (E[]) (new Object[10]);
    size = 0;
  }

  public void ensureCapacity(int minCapacity) {
    if (arr.length < minCapacity) {
      E[] temp = (E[]) (new Object[minCapacity]);
      for (int i = 0; i < arr.length; i++)
        temp[i] = arr[i];
      arr = temp;
    }
  }

  public E remove(int index) {
    if (index >= size || index < 0)
      throw new IndexOutOfBoundsException();
    E x = arr[index];
    int counter = 0;
    size--;
    E[] temp = (E[]) (new Object[size]);
    for (int i = 0; i < size + 1; i++)
      if (i != index) {
        temp[counter] = arr[i];
        counter++;
      }
    arr = temp;
    return x;
  }

  public boolean remove(Object o) {
    if (contains(o)) {
      remove(indexOf(o));
      return true;
    }
      return false;
  }

  public E set(int i, E e) {
    if (i >= size || i < 0)
      throw new IndexOutOfBoundsException();
    E x = arr[i];
    arr[i] = e;
    return x;
  }

  public Object[] toArray() {
    return arr;
  }

  public void trimToSize() {
    if (arr.length != size) {
      E[] temp = (E[]) (new Object[size]);
      for (int i = 0; i < size; i++)
        temp[i] = arr[i];
      arr = temp;
    }
  }

  public List<E> subList(int i, int j) {
    if (i > size || i < 0 || j > size || j < 0)
      throw new IndexOutOfBoundsException();
    if (i > j)
      throw new IllegalArgumentException();
    ArrayList_Dempsey subList = new ArrayList_Dempsey(j-i);
    for (int x = i; x < j; x++) 
      subList.add(arr[x]);
    return subList;
  }

  protected void removeRange(int i, int j) {
    if (i < 0 || i >= size() || j > size() || j < i)
      throw new IndexOutOfBoundsException();
    for (int x = i; x < j; x++)
      remove(i);
  }
}