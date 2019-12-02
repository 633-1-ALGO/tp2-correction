package collections;

import java.util.Arrays;

public class MyArrayList implements MyCollection {

  private Comparable[] elements;
  private int size;

  public MyArrayList() {
    elements = new Comparable[10];
    size = 0;
  }

  private void createBiggerArray() {
    elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);

  }

  private void shiftArrayRight(int start, int finish) {
    for (int i = finish; i > start; i--) {
      elements[i] = elements[i - 1];
    }
  }

  private void shiftArrayLeft(int start, int finish) {
    for (int i = start; i < finish - 1; i++) {
      elements[i] = elements[i + 1];
    }
  }

  @Override
  public void add(Comparable element) {
    add(size, element);
  }

  @Override
  public void add(int index, Comparable element) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (size == elements.length) {
      createBiggerArray();
    }
    if (size != index) {
      shiftArrayRight(index, size);
    }
    elements[index] = element;
    size++;
  }

  @Override
  public Comparable get(int index) {
    return elements[index];
  }

  @Override
  public void set(int index, Comparable element) {
    elements[index] = element;
  }

  @Override
  public void remove(Comparable element) {
    int index = indexOf(element);
    remove(index);
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index >= size) return;
    shiftArrayLeft(index, size);
    size--;
  }

  @Override
  public void clear() {
    elements = new Comparable[10];
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Comparable element) {
    return indexOf(element) != -1;
  }

  @Override
  public int indexOf(Comparable element) {
    for (int i = 0; i < elements.length; i++)
      if (elements[i].equals(element)) {
        return i;
      }
    return -1;
  }

  @Override
  public void insertionSort() {
    for (int i = 0; i < size; i++) {
      Comparable key = get(i);
      int j = i - 1;

      while (j >= 0 && key.compareTo(get(j)) < 0) {
        set(j + 1, get(j));
        j = j - 1;
      }
      set(j + 1, key);
    }
  }

  @Override
  public void fusionSort() {
    mergeSort(0, size - 1);
  }

  private void mergeSort(int p, int r) {
    if (p >= r) return;
    // Trouver la moitié de la liste
    int q = (int) Math.floor((p + r) / 2);

    // Trier la partie de gauche
    mergeSort(p, q);
    // Trie la partie de droite
    mergeSort(q + 1, r);

    // Joindre les deux listes
    merge(p, q, r);
  }

  private void merge(int p, int q, int r) {

    // Calculer la taille de la première liste
    int n1 = q - p + 1;

    // Calculer la taille de la deuxième liste
    int n2 = r - q;

    MyArrayList left = new MyArrayList();
    MyArrayList right = new MyArrayList();

    for (int i = 0; i < n1; i++) {
      left.add(get(p + i));
    }
    for (int i = 0; i < n2; i++) {
      right.add(get(q + 1 + i));
    }

    int i = 0;
    int j = 0;
    int k = p;
    while (k <= r && !(i == left.size) && !(j == right.size)) {
      if (left.get(i).compareTo(right.get(j)) <= 0) {
        set(k, left.get(i));
        i++;
      } else {
        set(k, right.get(j));
        j++;
      }
      k++;
    }
    if (i == left.size) {
      while (j < right.size) {
        set(k, right.get(j));
        j++;
        k++;
      }
    } else {
      while (i < left.size) {
        set(k, left.get(i));
        i++;
        k++;
      }
    }
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < size; i++) {
      builder.append(elements[i]);
    }
    return builder.toString();
  }
}
