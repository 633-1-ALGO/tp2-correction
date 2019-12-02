package collections;

/**
 * Interface qui définit la structure qu'une liste doit avoir
 *
 * @author flavio.barreiro
 */
public interface MyCollection {

  /**
   * Ajoute un élément à la fin de la liste
   *
   * @param element élément à ajouter
   */
  void add(Comparable element);

  /**
   * Ajoute un élément à la liste dans un indice donné
   *
   * @param index indice d'insertion de l'élément
   * @param element élément à insérer
   * @throws IndexOutOfBoundsException lance une exception si l'indice est négatif ou supérieur à la taille de la liste
   */
  void add(int index, Comparable element);

  /**
   * Obtenir un élément
   *
   * @param index indice de l'élément à récupérer
   * @return l'élément voulu
   * @throws IndexOutOfBoundsException lance une exception si l'indice est négatif ou supérieur à la taille de la liste
   */
  Comparable get(int index);

  /**
   * Remplacer un élément par un autre
   *
   * @param index indice de l'élément à remplacer
   * @param element élément à stocker
   * @throws IndexOutOfBoundsException lance une exception si l'indice est négatif ou supérieur à la taille de la liste
   */
  void set(int index, Comparable element);

  /**
   * Supprimer un élément
   *
   * @param element élément à supprimer de la liste
   */
  void remove(Comparable element);

  /**
   * Supprimer un élément
   *
   * @param index indice de l'élément à supprimer
   */
  void remove(int index);

  /**
   * Vider la liste
   */
  void clear();

  /**
   * Obtenir la taille de la liste
   *
   * @return taille de la liste
   */
  int size();

  /**
   * Savoir si la liste est vide
   *
   * @return true si size == 0, si non, retourne false
   */
  boolean isEmpty();

  /**
   * Déterminer si la liste contient un élément
   *
   * @param element élément à chercher
   * @return true si la liste contient l'élément
   */
  boolean contains(Comparable element);

  /**
   * Trouver un élément dans la liste.
   * Si plusieurs fois le même élément, l'indice retourné est celui de la première instance trouvée
   *
   * @param element élément à trouver dans la liste
   * @return indice de l'élément trouvé. Retourne -1 si l'élément n'est pas trouvé.
   */
  int indexOf(Comparable element);

  /**
   * Trier la liste en utilisant l'algorithme de tri "insertion sort"
   */
  void insertionSort();

  /**
   * Trier la liste en utilisant l'algorithme de tri "tri par fusion"
   */
  void fusionSort();

}
