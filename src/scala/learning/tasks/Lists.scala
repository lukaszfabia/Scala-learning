package scala.learning.tasks

object Lists {
  def main(args: Array[String]): Unit = {
    println(countElement(4, List(1, 1, 1, 2, 2)))
    println(mergeList(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))))
    println(replicate("Yes", 3))
    println(sqrtList(List(1, 2, 3, 4, 5)))
    println(palindrome(List(1, 2, 3, 2, 1)))
    println(listLength(List(1, 2, 12, 1, 2, 32, 1, 3, 13, 12, 312)))
  }

  /*
  @param list - lista list
  @return - lista elementow z listy list
   */
  private def mergeList[T](list: List[List[T]]): List[T] = {
    if (list.nonEmpty) {
      list.head ::: mergeList(list.tail)
    }
    else {
      Nil
    }
  }

  /*
  @param element - element do zliczenia
  @param list - lista w ktorej szukamy elementu
   */
  private def countElement[T](element: T, list: List[T]): Int = {
    if (list.nonEmpty) {
      if (list.head == element) {
        // zaczynamy od poczatku i jesli akutaly element jest rowny szukanemu to zwiekszamy licznik
        1 + countElement(element, list.tail)
      }
      else {
        // przechodzimy dalej po lisie
        countElement(element, list.tail)
      }
    } else {
      0
    }
  }

  /*
  @param element - element do powtorzenia
  @param n - ilosc powtorzen
   */
  private def replicate[T](element: T, n: Int): List[T] = {
    if (n > 0) {
      // doklejamy do listy element do listy n razy
      List(element) ::: replicate(element, n - 1)
    } else {
      Nil
    }
  }

  /*
  @param list - lista liczb
   */

  //  :: służy do dodawania elementu na początek listy.
  //  ::: służy do łączenia dwóch list w jedną.
  private def sqrtList(list: List[Int]): List[Int] = {
    if (list.nonEmpty) {
      list.head * list.head :: sqrtList(list.tail)
    } else {
      Nil
    }
  }

  private def palindrome[T](list: List[T]): Boolean = {
    list == list.reverse
  }

  private def listLength[T](list: List[T]): Int = {
    if (list.nonEmpty) {
      1 + listLength(list.tail)
    } else {
      0
    }
  }

}