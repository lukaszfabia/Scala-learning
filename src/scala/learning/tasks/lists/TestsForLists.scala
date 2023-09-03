package scala.learning.tasks.lists

class TestsForLists {

  def runTests(): Unit = {
    testForMergeList()
    testForCountElement()
    testForMaxValue()
    testForFilterOddNumbers()
    testForFibonacciSequence()
    testForInsert()
    testForRemoveNthElement()
    testForReverseFourElements()
    testForSet()
    testForIsSortedIncreasing()
    testForListLength()
    testForPalindrome()
    testForReplicate()
    testForReverseList()
    testForRemoveDuplicates()
    testForSubstitute()
    testForSqrtList()
    testForFib()
  }

  private def testForCountElement(): Unit = {
    println("Tests for countElement")
    assert(Lists.countElement(4, List(1, 1, 1, 2, 2)) == 0)
    assert(Lists.countElement(1, List(1, 1, 1, 2, 2)) == 3)
    assert(Lists.countElement(2, List(1, 1, 1, 2, 2)) == 2)
    println()
  }

  private def testForMaxValue(): Unit = {
    println("Tests for maxValue")
    assert(Lists.findMaxValue(List(1, 2, 3, 4, 5)) == 5)
    assert(Lists.findMaxValue(List(5, 4, 3, 2, 1)) == 5)
    assert(Lists.findMaxValue(List(1, 2, 3, 4, 5, 4, 3, 2, 1)) == 5)
    println()
  }

  private def testForFilterOddNumbers(): Unit = {
    println("Tests for filterOddNumbers")
    assert(Lists.filterOddNumbers(List(1, 2, 3, 4, 5, 6, 7, 8)) == List(2, 4, 6, 8))
    assert(Lists.filterOddNumbers(List(1, 3, 5, 7)) == List())
    assert(Lists.filterOddNumbers(List(2, 4, 6, 8)) == List(2, 4, 6, 8))
    println()
  }

  private def testForFibonacciSequence(): Unit = {
    println("Tests for fibonacciSequence")
    assert(Lists.fibonacciSequence(4) == List(0, 1, 1, 2))
    assert(Lists.fibonacciSequence(0) == List())
    assert(Lists.fibonacciSequence(1) == List(0))
    println()
  }

  private def testForInsert(): Unit = {
    assert(Lists.insert(List("to", "jest", "kon"), 0, "kot") == List("kot", "to", "jest", "kon"))
    assert(Lists.insert(List(), 0, "kot") == List("kot"))
    assert(Lists.insert(List("to", "jest", "kon"), 1, "kot") == List("to", "kot", "jest", "kon"))
  }

  private def testForMergeList(): Unit = {
    println("Tests for mergeList")
    assert(Lists.mergeList(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))) == List(1, 2, 3, 4, 5, 6, 7, 8, 9))
    assert(Lists.mergeList(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9), List())) == List(1, 2, 3, 4, 5, 6, 7, 8, 9))
    assert(Lists.mergeList(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9), List(), List(1, 2, 3))) == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3))
    println()
  }

  private def testForRemoveNthElement(): Unit = {
    println("Tests for removeNthElement")
    assert(Lists.remove(List(1, 2, 3, 4, 5), 1) == List(1, 3, 4, 5))
    println()
  }

  private def testForReverseFourElements(): Unit = {
    println("Tests for reverseFourElements")
    assert(Lists.reverseFourElements(1, 2, 3, 4) == (4, 3, 2, 1))
    assert(Lists.reverseFourElements(true, false, "ABC", 'd') == ('d', "ABC", false, true))
    println()
  }

  private def testForSet(): Unit = {
    println("Tests for set")
    assert(Lists.set(List(1, 2, 3, 4, 5), 0, 99) == List(99, 2, 3, 4, 5))
    assert(Lists.set(List("to", "jest", "kot"), 2, "pies") == List("to", "jest", "pies"))
    println()
  }

  private def testForIsSortedIncreasing(): Unit = {
    println("Tests for isSortedIncreasing")
    assert(Lists.isSortedIncreasing(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    assert(!Lists.isSortedIncreasing(List(1, 2, 3, 4, 5, 1, 7, 8, 9, 10)))
    assert(Lists.isSortedIncreasing(List(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    println()
  }

  private def testForListLength(): Unit = {
    println("Tests for listLength")
    assert(Lists.listLength(List(1, 2, 12, 1, 2, 32, 1, 3, 13, 12, 312)) == 11)
    assert(Lists.listLength(List()) == 0)
    assert(Lists.listLength(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) == 10)
    println()
  }

  private def testForPalindrome(): Unit = {
    println("Tests for palindrome")
    assert(Lists.palindrome(List(true, false, false, true)))
    assert(!Lists.palindrome(List(true, false, false, false)))
    assert(Lists.palindrome(List()))
    println()
  }

  private def testForReplicate(): Unit = {
    println("Tests for replicate")
    assert(Lists.replicate("Yes", 3) == List("Yes", "Yes", "Yes"))
    assert(Lists.replicate(false, 0) == List())
    assert(Lists.replicate(2003, 1) == List(2003))
    println()
  }

  private def testForReverseList(): Unit = {
    println("Tests for reverseList")
    assert(Lists.reverseList(List(1, 2, 3)) == List(3, 2, 1))
    assert(Lists.reverseList(List()) == List())
    assert(Lists.reverseList(List(1)) == List(1))
    println()
  }

  private def testForRemoveDuplicates(): Unit = {
    println("Tests for removeDuplicates")
    assert(Lists.removeDuplicates(List(1, 2, 32, 3, 1, 123, 3, 1)) == List(2, 32, 123, 3, 1))
    assert(Lists.removeDuplicates(List()) == List())
    assert(Lists.removeDuplicates(List(1, 1, 1, 1, 1, 1, 1, 1, 1)) == List(1))
    println()
  }

  private def testForSubstitute(): Unit = {
    println("Tests for substitute")
    assert(Lists.substitute(List(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 1, 1, 1), 2, 99) == List(1, 1, 1, 1, 1, 1, 99, 99, 99, 99, 3, 1, 1, 1))
    assert(Lists.substitute(List(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 1, 1, 1), 1, 99) == List(99, 99, 99, 99, 99, 99, 2, 2, 2, 2, 3, 99, 99, 99))
    assert(Lists.substitute(List(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 1, 1, 1), 3, 99) == List(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 99, 1, 1, 1))
    println()
  }

  private def testForSqrtList(): Unit = {
    println("Tests for sqrtList")
    assert(Lists.sqrtList(List(1, 2, 3, 4, 5)) == List(1, 4, 9, 16, 25))
    assert(Lists.sqrtList(List()) == List())
    assert(Lists.sqrtList(List(1)) == List(1))
    println()
  }

  private def testForFib(): Unit = {
    println("Tests for fib")
    assert(Lists.fib(0) == 0)
    assert(Lists.fib(1) == 1)
    assert(Lists.fib(2) == 1)
    assert(Lists.fib(3) == 2)
    assert(Lists.fib(4) == 3)
    assert(Lists.fib(5) == 5)
  }
}
