package lectures.basics

object Functions extends App {

  // Function syntax
  def aFunction(a: String, b: Int): String = {
    s"$a $b"
  }

  println(aFunction("Hello", 3));

  def aParameterLessFunction(): Int = 3
  println(aParameterLessFunction())

  def aRepeatedFunction(a: String, n: Int): String = {
    if (n == 1) a
    else a + " " + aRepeatedFunction(a, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))


  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = {
      a + b
    }

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(5))

  /**
   * A greeting function (name, age) => s"Hi, my name is $name and I am $age years old."
   *
   * Factorial function 1 * 2 * 3 * n
   *
   * Fibonacci Numbers f(1) = 1
   *                   f(2) = 1
   *                   f(3) = 2
   *                   f (4) = 3
   *
   *
   * Function that tests if a number is prime.
   */

  // TASK 1
  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }
  println(greeting("Oliver", 33))


  // TASK 2
  def factorialTailRec(n: Int): BigInt = {
    @scala.annotation.tailrec
    def go(x: Int, acc: BigInt): BigInt = {
      if (x <= 0) acc
      else go(x - 1, x * acc)
    }

    go(n, 1)
  }

  println("Factorial Tail Recursive:")
  println(factorialTailRec(4))


  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(n)
      n * factorial(n - 1)
    }
  }

  println("Factorial Naive")
  println(factorial(4))

  // TASK 3
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(8))

  // 1 1 2 3 5 8 13 21

  def fibonacciTailRec(n: Int): BigInt = {
    @scala.annotation.tailrec
    def go(x: Int, acc1: BigInt, acc2: BigInt): BigInt = {
      if (x <= 0) acc2
      else go(x - 1, acc2, acc1 + acc2)
    }

    go(n, 1, 0)
  }

  println(fibonacciTailRec(200))

  def isPrime(n: Int): Boolean = {
    // NEEDS AUXILIARY FUNCTION
    @scala.annotation.tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(5))
}
