package scala.learning.tasks.lists

import scala.annotation.tailrec

object Lists {
  def main(args: Array[String]): Unit = {
    val tests = new TestsForLists()
    tests.runTests()

    val precision = 1000
    //    println(area(0, 1)(x => x * x)(precision))
    //    println(area(0, 1)(x => x * x * x)(precision))
    //    println(area(-2, 1)(x => 2*x-1)(precision))
    //    println(area(2, 3)(x => x*x)(precision))
    //    println(area(Math.PI, 2*Math.PI)(x => Math.sin(x))(precision))
    //    println(area(Math.PI, 2*Math.PI)(x => x/Math.sin(x))(precision))
    //    println(derivative(x => Math.sin(x))(Math.PI))
    //    println(derivative(x => Math.exp(x))(12))
    //    println(derivative(x => Math.sin(x) * Math.cos(x))(Math.PI))
    //    println(derivative(x => x * x)(2))

//    println(split2Rec(List(1,2,3,4,5,6,7,8)))
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
      element :: replicate(element, n - 1)
    } else {
      Nil
    }
  }

  /*
  @param list - lista liczb
   */
  def sqrtList(list: List[Int]): List[Int] = {
    if (list.isEmpty) Nil
    else list.head * list.head :: sqrtList(list.tail)
  }

  def palindrome[T](list: List[T]): Boolean = list.reverse == list

  def listLength[T](list: List[T]): Int = {
    if (list.nonEmpty) {
      1 + listLength(list.tail)
    } else {
      0
    }
  }

  def reverseList[T](list: List[T]): List[T] = {
    @tailrec
    def aux[A](list1: List[A], output: List[A]): List[A] = {
      list1 match {
        case Nil => output
        case head :: tail => aux(tail, head :: output)
      }
    }

    aux(list, Nil)
  }

  def filterOddNumbers(list: List[Int]): List[Int] = {
    list match {
      case head :: tail =>
        if (head % 2 == 0) head :: filterOddNumbers(tail)
        else filterOddNumbers(tail)
      case Nil => Nil
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
        list.head :: removeDuplicates(list.tail)
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
  def find[T](list: List[T], element: T): Boolean = list match {
    case Nil => false
    case head :: _ if head == element => true
    case _ :: tail => find(tail, element)
  }

  def split2Rec[T](list: List[T]): (List[T], List[T]) = {
    def split[A](list: List[A], isEven: Boolean): (List[A], List[A]) = {
      (list, isEven) match {
        case (Nil, _) => (Nil, Nil)
        case (head :: tail, true) =>
          val (even, odd) = split(tail, !isEven)
          (even, head :: odd)
        case (head :: tail, _) =>
          val (even, odd) = split(tail, !isEven)
          (head :: even, odd)
      }
    }

    split(list, false)
  }

  def split2Tail[T](list: List[T]): (List[T], List[T]) = {
    @tailrec
    def split[A](list: List[A], sameAsFirst: List[A], restOfAll: List[A], firstElement: A): (List[A], List[A]) = {
      list match {
        case Nil => (sameAsFirst, restOfAll.reverse)
        case head :: tail if firstElement == list.head => split(tail, head :: sameAsFirst, restOfAll, firstElement)
        case head :: tail => split(tail, sameAsFirst, head :: restOfAll, firstElement)
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
        case Nil => (primes, nonPrimes)
        case head :: tail if isPrime(numbers.head, numbers.head - 1) => split(tail, head :: primes, nonPrimes)
        case head :: tail => split(tail, primes, head :: nonPrimes)
      }
    }

    split(numbers, Nil, Nil)
  }


  def factorial(n: Int): Int = {
    n match {
      case 0 => 1
      case 1 => 1
      case _ => n * factorial(n - 1)
    }
  }

  def power(base: Double, head: Double): Double = {
    head match {
      case 0 => 1
      case _ => base * power(base, head - 1)
    }
  }

  def RPN(expression: List[String]): Double = {
    //1 2 + 3 / = (1+2)/3
    @tailrec
    def run(stack: List[Double], remaining: List[String]): Double = {
      remaining match {
        case Nil => stack.head
        case head :: tail if head.forall(_.isDigit) => run(head.toDouble :: stack, tail)
        case "+" :: tail =>
          val res = stack(1) + stack.head
          run(res :: stack, tail)
        case "-" :: tail =>
          val res = stack(1) - stack.head
          run(res :: stack, tail)
        case "/" :: tail =>
          if (stack.head == 0) {
            throw new IllegalArgumentException("div by 0")
          } else {
            val res = stack(1) / stack.head
            run(res :: stack, tail)
          }
        case "*" :: tail =>
          val res = stack(1) * stack.head
          run(res :: stack, tail)
        case "^" :: tail =>
          val res = power(stack(1), stack.head)
          run(res :: stack, tail)
        case _ => throw new IllegalArgumentException("Wrong expression")
      }
    }

    run(Nil, expression)
  }

  def sumAndProd(xs: List[Int]): (Int, Int) = xs.foldLeft(0, 1)((acc: (Int, Int), h: Int) =>
    (acc._1 + h, acc._2 * h)
  )

  def sumOfEven(xs: List[Int]): Int = xs.foldLeft(0)((acc: Int, number: Int) =>
    if (number % 2 == 0) acc + number else acc
  )

  def mean(xs: List[Int]): Double = xs.foldLeft(0)((acc: Int, number: Int) => acc + number) / xs.length

  def findMinMax(xs: List[Int]): (Int, Int) = xs.foldLeft(Integer.MAX_VALUE, Integer.MIN_VALUE) {
    // troche ulomne ale inczaej narzie nieweim
    (acc, number) => {
      if (number < acc._1) {
        (number, acc._2)
      } else if (number > acc._2) {
        (acc._1, number)
      } else {
        acc
      }
    }
  }

  def insertionSort[A](function: (A, A) => Boolean, list: List[A]): List[A] = {
    def insert(number: A, sortedList: List[A]): List[A] = {
      sortedList match {
        case Nil => List(number)
        case head :: _ if function(number, head) => number :: sortedList // gdy zachodzi to dodajemy liczbe do sortedlist
        case head :: tail => head :: insert(number, tail) // jak nie to zostaiwamy
      }
    }

    list.foldLeft(List.empty[A])((acc, head) => insert(head, acc))
  }

  def value(f: Double => Double)(n: Double): List[Double] = {
    @tailrec
    def calculate(f: Double => Double, n: Double, index: Double, list: List[Double]): List[Double] = {
      if (index < 0) {
        list
      } else {
        calculate(f, n, index - 1, f(index) :: list)
      }
    }

    calculate(f, n, index = n - 1, Nil)
  }

  def revNComp(f: Int => Int)(n: Int)(x: Int): List[Int] = {
    @tailrec
    def innerRevNComp(f: Int => Int, n: Int, x: Int, list: List[Int]): List[Int] = {
      n match {
        case _ if n < 1 => Nil
        case 1 => x :: list
        case _ => innerRevNComp(f, n - 1, f(x), x :: list)
      }
    }

    innerRevNComp(f, n, x, Nil)
  }

  def area(a: Double, b: Double)(f: Double => Double)(n: Int): Double = {
    if (n > 0) {
      val h = (b - a) / n

      def createList(amount: Int): List[Int] = {
        if (amount < n) amount :: createList(amount + 1) else Nil
      }

      val xs = createList(amount = 1)
      val areas = xs.map(x => f(a + h * x) * h)
      areas.foldLeft(0.0)((acc, x) => acc + x)
    } else {
      0
    }
  }

  def derivative(f: Double => Double)(x: Double): Double = {
    val h = 10e-12
    Math.round((f(x + h) - f(x)) / h)
  }

}