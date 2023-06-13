package lectures.basics

object Expressions extends App {

  val someValue = false
  val aConditionedValue: Any = if (someValue) 42 else "Silly"
  println(aConditionedValue)

  // Code blocks
  val aCodeBlock = {
    val y: Int = 2
    val z: Int = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }
}
