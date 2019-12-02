package collections;

import java.util.Objects;

public class MyLinkedList implements MyCollection {

  private class Node {
    Comparable element;
    Node next;
    Node prev;

    public Node(Comparable element) {
      this(element, null, null);
    }

    public Node(Comparable element, Node next, Node prev) {
      this.element = element;
      this.next = next;
      this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
      Node node = (Node) o;
      return Objects.equals(element, node.element);
    }

    @Override
    public int hashCode() {
      return Objects.hash(element);
    }
  }

  private Node head;
  private Node tail;
  private int size;

  @Override
  public void add(Comparable element) {
    add(size, element);
  }

  private void checkIndexes(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Les indices dépassent les bornes possibles !");
    }
  }

  @Override
  public void add(int index, Comparable element) {
    checkIndexes(index);
    if (isEmpty()) {
      Node head = new Node(element);
      this.head = head;
    } else if (index == 0) {
      Node node = new Node(element, head, null);
      head.prev = node;
      if (size == 1) {
        this.tail = this.head;
      }
      this.head = node;
    } else if (index == size) {
      if (size == 1) {
        this.tail = new Node(element, null, this.head);
        this.head.next = tail;
      } else {
        Node node = new Node(element, null, tail);
        tail.next = node;
        tail = node;
      }
    } else {
      Node currentNode = getNode(index);

      Node newNode = new Node(element);

      currentNode.prev.next = newNode;
      newNode.prev = currentNode.prev;

      currentNode.prev = newNode;
      newNode.next = currentNode;

    }
    size++;

  }

  private Node getNode(int index) {
    checkIndexes(index);
    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  @Override
  public Comparable get(int index) {
    checkIndexes(index);
    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node.element;
  }

  @Override
  public void set(int index, Comparable element) {
    checkIndexes(index);
    Node node = getNode(index);
    node.element = element;
  }

  @Override
  public void remove(Comparable element) {
    int index = indexOf(element);
    if (index == -1) return;
    remove(index);
  }

  @Override
  public void remove(int index) {
    if (size == 1) {
      clear();
    } else if (index == 0) {
      this.head.next.prev = null;
      this.head = this.head.next;
    } else if (index == size - 1) {
      this.tail.prev.next = null;
      this.tail = this.tail.prev;
    } else {
      Node current = getNode(index);
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }
    size--;
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public boolean contains(Comparable element) {
    return indexOf(element) != -1;
  }

  @Override
  public int indexOf(Comparable element) {
    int index = 0;

    Node current = head;

    while (current != null) {
      if (current.element.equals(element)) {
        return index;
      }
      index++;
      current = current.next;
    }

    return -1;
  }

  @Override
  public void insertionSort() {
    Node i = this.head.next;

    while (i != null) {

      Comparable key = i.element;

      Node j = i.prev;
      Node before = null;
      while (j != null && key.compareTo(j.element) < 0) {

        j.next.element = j.element;
        before = j;
        j = j.prev;
      }
      if (before != null)
        before.element = key;
      i = i.next;
    }

  }

  @Override
  public void fusionSort() {
    MyLinkedList linkedList = mergeSort(this);
    this.head = linkedList.head;
    this.tail = linkedList.tail;
  }

  private MyLinkedList mergeSort(MyLinkedList list) {

    if(list.size() <= 1) {
      return list;
    }

    MyLinkedList left  = new MyLinkedList();
    MyLinkedList right  = new MyLinkedList();

    int middle = list.size() / 2;

    int added = 0;
    Node current = list.head;
    while (current != null){
      if(added++ < middle)
        left.add(current.element);
      else
        right.add(current.element);

      current = current.next;
    }

    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right);
  }

  private MyLinkedList merge(MyLinkedList left, MyLinkedList right) {
    MyLinkedList result = new MyLinkedList();
    while(!left.isEmpty() && !right.isEmpty()) {
      if(left.get(0).compareTo(right.get(0)) < 0) {
        Comparable element = left.get(0);
        left.remove(0);
        result.add(element);
      } else {
        Comparable element = right.get(0);
        right.remove(0);
        result.add(element);
      }
    }

    if(!left.isEmpty()) {
      Node current = left.head;
      while (current != null) {
        result.add(current.element);
        current = current.next;
      }
    } else {
      Node current = right.head;
      while (current != null) {
        result.add(current.element);
        current = current.next;
      }
    }
    return result;
  }


  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();

    Node current = this.head;

    while (current != null) {
      string.append(current.element.toString());
      current = current.next;
    }
    return string.toString();
  }



}
