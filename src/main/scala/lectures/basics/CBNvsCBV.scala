package lectures.basics

object CBNvsCBV extends App {

  /* The exact value of this expression is computed BEFORE the execution of the function.
  *  The value of x here is the same, wherever it is called/referenced.
  *  */
  def calledByValue(x: Long): Unit = {
    println(s"By value: $x")
    println(s"By value: $x")
  }

  /* The value of this expression is computed at the time it is used.
  *  This means that the value of x (System.nanoTime) will be different
  *  when it is called in either print statement.
  *
  *  */
  def calledByName(x: => Long): Unit = {
    println(s"By name: $x")
    println(s"By name: $x")
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime)


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  printFirst(34, infinite())
}
