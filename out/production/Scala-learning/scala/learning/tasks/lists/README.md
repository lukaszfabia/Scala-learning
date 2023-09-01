# Scala Learning - Zadania na Listach

Ten pakiet zawiera różne zadania dotyczące list w języku programowania Scala. Poniżej znajdziesz opisy i przykłady każdego z tych zadań.

## Zadania

### 1. `countElement`

Funkcja `countElement(element: T, list: List[T]): Int` zlicza ilość wystąpień określonego elementu w liście.

Przykład użycia:

```scala
println(countElement(4, List(1, 1, 1, 2, 2))) // Oczekiwany wynik: 0
```


### 2. `mergeList`

Funkcja `mergeList(list: List[List[T]]): List[T]` łączy listy list w jedną listę.

Przykład użycia:

```scala
println(mergeList(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)))) // Oczekiwany wynik: List(1, 2, 3, 4, 5, 6, 7, 8, 9)
```

### 3. `replicate`

Funkcja `replicate(element: T, n: Int): List[T]` tworzy listę powtórzeń danego elementu.

Przykład użycia:

```scala
println(replicate("Yes", 3)) // Oczekiwany wynik: List("Yes", "Yes", "Yes")
```

### 4. `sqrtList`

Funkcja `sqrtList(list: List[Int]): List[Int]` zwraca listę kwadratów liczb z listy.

Przykład użycia:

```scala
println(sqrtList(List(1, 2, 3, 4, 5))) // Oczekiwany wynik: List(1, 4, 9, 16, 25)
```

### 5. `palindrome`

Funkcja `palindrome(list: List[T]): Boolean` sprawdza, czy lista jest palindromem.

Przykład użycia:

```scala
println("Palindrome: " + palindrome(List(true, false, false, true))) // Oczekiwany wynik: true
```

### 6. `listLength`

Funkcja `listLength(list: List[T]): Int` zwraca długość listy.

Przykład użycia:

```scala
println(listLength(List(1, 2, 12, 1, 2, 32, 1, 3, 13, 12, 312))) // Oczekiwany wynik: 11
```

### 7. `reverseList`

Funkcja `reverseList(list: List[T]): List[T]` odwraca listę.

Przykład użycia:

```scala
println(reverseList(List(1, 2, 3))) // Oczekiwany wynik: List(3, 2, 1)
```

### 8. `removeDuplicates`

Funkcja `removeDuplicates(list: List[T]): List[T]` usuwa z listy duplikaty.

Przykład użycia:

```scala
println("Remove duplicates: " + removeDuplicates(List(1, 2, 32, 3, 1, 123, 3, 1))) // Oczekiwany wynik: List(1, 2, 32, 3, 123)
```

### 9. `findMaxValue`

Funkcja `findMaxValue(list: List[Int]): Int` znajduje maksymalną wartość w liście.

Przykład użycia:

```scala
println(findMaxValue(List(0, 1, 2, 32, 3, 14, 1))) // Oczekiwany wynik: 32
```

### 10. `filterOddNumbers`

Funkcja `filterOddNumbers(list: List[Int]): List[Int]` filtruje nieparzyste liczby z listy.

Przykład użycia:

```scala
println(filterOddNumbers(List(1, 2, 3, 4, 5, 6, 7, 8))) // Oczekiwany wynik: List(2, 4, 6, 8)
```

### 11. `fibonacciSequence`

Funkcja `fibonacciSequence(n: Int): List[Int]` generuje sekwencję Fibonacciego o długości `n`.

Przykład użycia:

```scala
println(fibonacciSequence(4)) // Oczekiwany wynik: List(0, 1, 1, 2)
```

## Wnioski
`::`  służy do dodawania elementu na początek listy.

Przykład użycia: 

```scala
list.head * list.head :: sqrtList(list.tail)
```

`:::` konkatenacja dwóch list.