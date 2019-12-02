import collections.MyArrayList;
import collections.MyLinkedList;
import collections.MyCollection;
import outils.FileToStr;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;

public class Main {


  public static void main(String[] args) throws ParseException {
    FileToStr fileToStr = new FileToStr();
    System.out.println("Loading ArrayList");
    MyArrayList al = fileToStr.loadIntoArrayList("irishtimes-date-text.csv", 100000);
    System.out.println("Loading DoublyLinkedList");
    MyLinkedList dl = fileToStr.loadIntoDoublyLinkedList("irishtimes-date-text.csv", 100000);
    System.out.println("\nTesting a MyArrayList");
    testing(al);
    System.out.println("\nTesting a doublylinked");
    testing(dl);
//    System.out.println(dl);
  }

  private static void testing(MyCollection list) {
    Instant start, end;
    Duration timeElapsed;

    start = Instant.now();
//    list.insertionSort();
    end = Instant.now();

    timeElapsed = Duration.between(start, end);

    System.out.println("Sorted insertion in :" + timeElapsed.toMillis() + " milliseconds");
    System.out.println("Sorted insertion in :" + timeElapsed.toMinutes() + " minutes ");

    start = Instant.now();
//    list.fusionSort();
    end = Instant.now();

    timeElapsed = Duration.between(start, end);

    System.out.println("Sorted merge in :" + timeElapsed.toMillis() + " milliseconds");
    System.out.println("Sorted merge in :" + timeElapsed.toMinutes() + " minutes ");

//    System.out.println(list);
    System.out.println(list.size());
  }

}
