package scala.learning.tasks.lists

import scala.annotation.tailrec

object Lists {
  def main(args: Array[String]): Unit = {
//    val tests = new TestsForLists()
//    tests.runTests()
  }


  /*
  @param list - lista list
  @return - lista elementow z listy list
   */
  def mergeList[T](list: List[List[T]]): List[T] = {
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
  def countElement[T](element: T, list: List[T]): Int = {
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
  def replicate[T](element: T, n: Int): List[T] = {
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
  def sqrtList(list: List[Int]): List[Int] = {
    if (list.nonEmpty) {
      List(list.head * list.head) ::: sqrtList(list.tail)
    } else {
      Nil
    }
  }

  @tailrec
  def palindrome[T](list: List[T]): Boolean = {
    if (list.length <= 1) {
      true
    } else if (list.head == list.last) {
      palindrome(list.tail.init)
    } else {
      false
    }
  }

  def listLength[T](list: List[T]): Int = {
    if (list.nonEmpty) {
      1 + listLength(list.tail)
    } else {
      0
    }
  }

  def reverseList[T](list: List[T]): List[T] = {
    if (list != Nil) {
      reverseList(list.tail) ::: List(list.head)
    } else {
      Nil
    }
  }

  def filterOddNumbers(list: List[Int]): List[Int] = {
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

  def findMaxValue(list: List[Int]): Int = {
    // instead of declaring var result = 0 out of function, in object scope
    var result = Integer.MIN_VALUE

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

    if (list.nonEmpty) {
      maxValue(list)
    } else {
      result
    }
  }

  def removeDuplicates[T](list: List[T]): List[T] = {
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


  def fibonacciSequence(n: Int): List[Int] = {
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

  def reverseFourElements[A, B, C, D](list: (A, B, C, D)): (D, C, B, A) = {
    (list._4, list._3, list._2, list._1)
  }

  def substitute[T](list: List[T], oldElement: T, newElement: T): List[T] = {
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

  def insert[T](list: List[T], index: Int, element: T): List[T] = {
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

  def set[T](list: List[T], index: Int, element: T): List[T] = {
    if (list.nonEmpty) {
      if (index == 0) {
        element :: list.tail
      } else {
        list.head :: set(list.tail, index - 1, element)
      }
    } else {
      List(element)
    }
  }

  def remove[T](list: List[T], index: Int): List[T] = {
    if (list.nonEmpty) {
      if (index == 0) {
        list.tail
      } else {
        list.head :: remove(list.tail, index - 1)
      }
    } else {
      Nil
    }
  }

  @tailrec
  def isSortedIncreasing(list: List[Int]): Boolean = {
    if (list.length > 1) {
      if (list.head <= list.tail.head) {
        isSortedIncreasing(list.tail)
      } else {
        false
      }
    } else {
      true
    }
  }

  @tailrec
  def find[T](list: List[T], element: T): Boolean = {
    if (list.nonEmpty) {
      if (list.head == element) {
        true
      } else {
        find(list.tail, element)
      }
    } else {
      false
    }
  }

  def split2Rec[T](list: List[T]): (List[T], List[T]) = {
    @tailrec
    def split[A](list: List[A], even: List[A], odd: List[A], isEven: Boolean): (List[A], List[A]) = {
      list match {
        case Nil => (even.reverse, odd.reverse)
        case head :: tail =>
          if (isEven) {
            split(tail, even, head :: odd, !isEven)
          } else {
            split(tail, head :: even, odd, !isEven)
          }
      }
    }

    split(list, Nil, Nil, isEven = false)
  }

  def split2Tail[T](list: List[T]): (List[T], List[T]) = {
    @tailrec
    def split[A](list: List[A], sameAsFirst: List[A], restOfAll: List[A], firstElement: A): (List[A], List[A]) = {
      list match {
        case Nil => (sameAsFirst, restOfAll.reverse)
        case head :: tail =>
          if (firstElement == list.head) {
            split(tail, head :: sameAsFirst, restOfAll, firstElement)
          } else {
            split(tail, sameAsFirst, head :: restOfAll, firstElement)
          }
      }
    }
    split(list, Nil, Nil, list.head)
  }

  def fib(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fib(n - 1) + fib(n - 2)
    }
  }
  def split2Primes(numbers: List[Int]): (List[Int], List[Int]) = {
    @tailrec
    def isPrime(number: Int, index: Int): Boolean = {
      if (number < 2) {
        false
      } else {
        if (index >= 2) {
          if (number % index == 0) {
            false
          } else {
            isPrime(number, index - 1)
          }
        } else {
          true
        }
      }
    }

    @tailrec
    def split(numbers: List[Int], primes: List[Int], nonPrimes: List[Int]): (List[Int], List[Int]) = {
      numbers match {
        case Nil => (primes.reverse, nonPrimes.reverse)
        case head :: tail =>
          if (isPrime(numbers.head, numbers.head - 1)) {
            split(tail, head :: primes, nonPrimes)
          } else {
            split(tail, primes, head :: nonPrimes)
          }
      }
    }

    split(numbers, Nil, Nil)
  }
}