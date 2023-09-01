package scala.learning.tasks.lists

import scala.annotation.tailrec

object Lists {
  def main(args: Array[String]): Unit = {
    println(countElement(4, List(1, 1, 1, 2, 2)))
    println(mergeList(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))))
    println(replicate("Yes", 3))
    println(sqrtList(List(1, 2, 3, 4, 5)))
    println("Palindrome:  " + palindrome(List(true, false, false, true)))
    println(listLength(List(1, 2, 12, 1, 2, 32, 1, 3, 13, 12, 312)))
    println(reverseList(List(1, 2, 3)))
    println("Remove duplicates: " + removeDuplicates(List(1, 2, 32, 3, 1, 123, 3, 1)))
    println(findMaxValue(List(0, 1, 2, 32, 3, 14, 1)))
    println(filterOddNumbers(List(1, 2, 3, 4, 5, 6, 7, 8)))
    println(fibonacciSequence(4))
    println("Insert: " + insert(List("to", "jest", "kon"), 2, "kot"))
    println("Insert do pustej listy: " + insert(List(), 0, "kot"))
    println("Substitute: " + substitute(List("to", "jest", "kon"), "kon", "kot"))
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
  private def sqrtList(list: List[Int]): List[Int] = {
    if (list.nonEmpty) {
      List(list.head * list.head) ::: sqrtList(list.tail)
    } else {
      Nil
    }
  }

  @tailrec
  private def palindrome[T](list: List[T]): Boolean = {
    if (list.length <= 1) {
      true
    } else if (list.head == list.last) {
      palindrome(list.tail.init)
    } else {
      false
    }
  }

  private def listLength[T](list: List[T]): Int = {
    if (list.nonEmpty) {
      1 + listLength(list.tail)
    } else {
      0
    }
  }

  private def reverseList[T](list: List[T]): List[T] = {
    if (list != Nil) {
      reverseList(list.tail) ::: List(list.head)
    } else {
      Nil
    }
  }

  private def filterOddNumbers(list: List[Int]): List[Int] = {
    if (list.nonEmpty) {
      if (list.head % 2 == 0) {
        List(list.head) ::: filterOddNumbers(list.tail)
      } else {
        filterOddNumbers(list.tail)
      }
    } else {
      Nil
    }
  }

  private def findMaxValue(list: List[Int]): Int = {
    // instead of declaring var result = 0 out of function, in object scope
    var result = Integer.MIN_VALUE
    if (list.nonEmpty) {
      @tailrec
      def maxValue(list: List[Int]): Int = {
        if (list.nonEmpty) {
          if (list.head > result) {
            result = list.head
          }
          maxValue(list.tail)
        } else {
          result
        }
      }

      maxValue(list)
    } else {
      result
    }
  }

  private def removeDuplicates[T](list: List[T]): List[T] = {
    if (list.nonEmpty) {
      if (list.tail.contains(list.head)) {
        removeDuplicates(list.tail)
      } else {
        List(list.head) ::: removeDuplicates(list.tail)
      }
    } else {
      Nil
    }
  }


  private def fibonacciSequence(n: Int): List[Int] = {
    if (n > 0) {
      if (n == 1) {
        List(0)
      } else if (n == 2) {
        List(0, 1)
      } else {
        fibonacciSequence(n - 1) ::: List(fibonacciSequence(n - 1).last + fibonacciSequence(n - 2).last)
      }
    } else {
      Nil
    }
  }

  private def reverseFourElements[A, B, C, D](list: (A, B, C, D)): (D, C, B, A) = {
    (list._4, list._3, list._2, list._1)
  }

  private def substitute[T](list: List[T], oldElement: T, newElement: T): List[T] = {
    if (list.nonEmpty) {
      if (list.head == oldElement) {
        newElement :: substitute(list.tail, oldElement, newElement)
      } else {
        list.head :: substitute(list.tail, oldElement, newElement)
      }
    } else {
      Nil
    }
  }

  private def insert[T](list: List[T], index: Int, element: T): List[T] = {
    if (list.nonEmpty) {
      if (index == 0) {
        element :: list
      } else {
        list.head :: insert(list.tail, index - 1, element)
      }
    } else {
      List(element)
    }
  }

  private def set[T](list: List[T], index: Int): List[T] = {
    // TODO
    Nil
  }

  private def removeNthElement[T](list: List[T], n: Int): List[T] = {
    // TODO
    Nil
  }

  private def isSorted(list: List[Int]): Boolean = {
    // TODO
    false
  }
}