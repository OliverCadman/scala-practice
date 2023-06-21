package lectures.basics

/**
 * STACK & TAIL RECURSION
 */

object Recursion extends App {

  def factorialStack(x: Int): Int = {
    if (x <= 1) 1
    else {
      println(s"Computing factorial of $x. First I need the factorial of ${x - 1}")
      val result = x * factorialStack(x - 1)
      println(s"Computed factorial of $x")
      result
    }
  }

  /**
   * In order to run a recursive function, the JVM uses a call stack
   * to keep partial results so it can get to computing the final result.
   *
   * The trouble with this approach is that Java keeps all of these calls
   * in its internal stack, which has limited memory.
   *
   * If the call stack runs out of memory, Java will crash with a Stack Overflow Error.
   *
   * So if we want to do this:
   *
   *    println(factorialStack(5000))
   *
   *  We will get this:
   *
   *    Exception in thread "main" java.lang.StackOverflowError
   *
   *  -----------------------
   *
   *  But we know that in order to loop in Scala, we don't use for loops, we use recursion.
   *  And what if we wanted to use a recursive function 5000 times?
   *
   *  We need to write code in a smarter way.
   *
   *  USE *****TAIL***** RECURSION!
   */


  def factorialTailRecursive(n: Int): Int = {
    @scala.annotation.tailrec
    def go(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else go(x - 1, x * acc)
    }

    go(n, 1)
  }

  println(factorialTailRecursive(10))

  /**
   * ^^^^^^^^^^^^^^^^
   *
   * factorialTailRecursive(10) = go(10, 1)
   *  = go(9, 10 * 1)
   *  = go(8, 9 * 10 * 1)
   *  = go(7, 8 * 9 * 10 * 1)
   *  = go(6, 7 * 8 * 9 * 10 * 1)
   *  = go(5, 6 * 7 * 8 * 9 * 10 * 1)
   *  = go(4, 5 * 6 * 7 * 8 * 9 * 10 * 1)
   *  = go(3, 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
   *  = go(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
   *  = go(1, 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
   *
   *  = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1
   *
   *  This can compute large numbers!
   */

  /**
   * Why does tail recursion work better than stack recursion?
   *
   * The trick here is that with tail recursion, you write the
   * LAST EXPRESSION of the code path. This allows Scala to preserve
   * the same stack frame, and not use additional stack frames
   * for each call.
   *
   * In the previous implementation, Scala needed a recursive
   * call stack frame for the recursive call so that it computes
   * the intermediate result so that it can then multiply it with a number
   * then pass it back from the stack.
   *
   * Tail recursion allows us to use the current s
   */
}
