package outils;

import collections.MyArrayList;
import collections.MyLinkedList;
import collections.MyCollection;
import domaine.Headline;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class FileToStr {

  private String read(String fileName) {
    try {
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
      StringBuilder b = new StringBuilder(in.available());

      for (int c = in.read(); c != -1; c = in.read()) {
        b.append((char) c);
      }
      in.close();
      return b.toString();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return "";
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  private MyCollection load(MyCollection list, String filename, int number_lines) throws ParseException {
    String file = read(filename);

    StringTokenizer st = new StringTokenizer(file, "\n\r");
    st.nextToken();
    int lines_read = 0;
    while (st.hasMoreTokens() && lines_read < number_lines) {
      String line = st.nextToken();
      StringTokenizer stLine = new StringTokenizer(line, ",");
      SimpleDateFormat formatter = new SimpleDateFormat("yyyymmdd");
      Date date = formatter.parse(stLine.nextToken());

      String type = stLine.nextToken();
      String headline = stLine.nextToken();

      list.add(new Headline(date, type, headline.substring(1, headline.length() - 1)));

      lines_read++;
    }

    return list;
  }

  /**
   * Charger un fichier et ajouter les éléments dans une DoublyLinkedList
   *
   * @param filename Nom du fichier à charger
   * @return Une instance de MyLinkedList
   * @throws ParseException Lance une exception si le format du fichier n'est pas valide
   */
  public MyLinkedList loadIntoDoublyLinkedList(String filename) throws ParseException {
    MyLinkedList list = new MyLinkedList();
    return (MyLinkedList) load(list, filename, Integer.MAX_VALUE);
  }

  /**
   * Charger un fichier et ajouter les éléments dans une DoublyLinkedList
   *
   * @param filename Nom du fichier à charger
   * @param number_lines Nombre de lignes à charger
   * @return Une instance de MyLinkedList
   * @throws ParseException Lance une exception si le format du fichier n'est pas valide
   * @throws IllegalArgumentException Si le nombre de lignes n'est pas supérieur à 0
   */
  public MyLinkedList loadIntoDoublyLinkedList(String filename, int number_lines) throws ParseException {
    if (number_lines <= 0)
      throw new IllegalArgumentException("Le nombre de lignes ne doit pas être plus petit ou égal à 0");
    MyLinkedList list = new MyLinkedList();
    return (MyLinkedList) load(list, filename, number_lines);
  }

  /**
   * Charger un fichier et ajouter les éléments dans une MyArrayList
   *
   * @param filename Nom du fichier à charger
   * @return Une instance de MyArrayList
   * @throws ParseException Lance une exception si le format du fichier n'est pas valide
   */
  public MyArrayList loadIntoArrayList(String filename) throws ParseException {
    MyArrayList list = new MyArrayList();
    return (MyArrayList) load(list, filename, Integer.MAX_VALUE);
  }

  /**
   * Charger un fichier et ajouter les éléments dans une MyArrayList
   *
   * @param filename Nom du fichier à charger
   * @param number_lines Nombre de lignes à charger
   * @return Une instance de MyArrayList
   * @throws ParseException Lance une exception si le format du fichier n'est pas valide
   * @throws IllegalArgumentException Si le nombre de lignes n'est pas supérieur à 0
   */
  public MyArrayList loadIntoArrayList(String filename, int number_lines) throws ParseException {
    if (number_lines <= 0)
      throw new IllegalArgumentException("Le nombre de lignes ne doit pas être plus petit ou égal à 0");
    MyArrayList list = new MyArrayList();
    return (MyArrayList) load(list, filename, number_lines);
  }
}
