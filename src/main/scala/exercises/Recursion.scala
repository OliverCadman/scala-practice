package exercises

object Recursion extends App {
  /**
   * 1. String concatenator - Tail Recursive
   *  Concatenate a string n times tail recursively.
   *
   *  2. Fibonacci Tail Recursive
   *
   *  3. isPrime Tail Recursive

   *  */


  def stringConcat(str: String, n: Int): String = {
    @scala.annotation.tailrec
    def go(x: Int, acc: String): String = {
      if (x <= 0) acc
      else go(x - 1, acc + str)
    }

    go(n, "")
  }

  println(stringConcat("Hello ", 5))


  def fibonacci(n: Int): BigInt = {
    @scala.annotation.tailrec
    def go(x: Int, acc1: BigInt, acc2: BigInt): BigInt = {
      if (x >= n) acc1
      else go(x + 1, acc1 + acc2, acc1)
    }

    if (n < 1) 0
    else go(2, 1, 1)
  }
  // 0 1 1 2 3 5
  println(fibonacci(5))
  (0 to 6).foreach(x => println(fibonacci(x)))

  @scala.annotation.tailrec
  def isPrime(n: Int, x: Int): Boolean = {
    if (x > n / 2) true
    else if (n % x == 0) false
    else isPrime(n, x + 1)
  }

  def isPrimeAlternative(n: Int): Boolean = {
    @scala.annotation.tailrec
    def go(x: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (x <= 1) true
      else go(x - 1, n % x !=0)
    }

    go(n / 2, true)
  }

  (1 to 10).foreach(x => println(s"Is $x a prime number? " + isPrime(x, 2)))

  println()
  println()

  (1 to 10).foreach(x => println(s"Is $x a prime number alternative? " + isPrimeAlternative(x)))

  println(isPrime(2003, 2)) // True
  println(isPrime(629, 2)) // False
}
