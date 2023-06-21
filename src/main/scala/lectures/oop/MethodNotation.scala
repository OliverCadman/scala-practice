package lectures.oop

import scala.language.postfixOps

object MethodNotation extends App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String):Boolean = movie == favouriteMovie

    def +(person: Person): String = s"$name is hanging out with ${person.name}"

    def unary_! : String = s"What the heck!"

    def isAlive: Boolean = true

    def apply(): String = s"Hey, my name is $name and I like $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // SYNTACTIC SUGAR

  // Infix notation
  // Only works with methods that only have one parameter.
  println(mary likes "Inception")

  // Operators in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // Prefix notation
  // Another form of syntactic sugar
  // All about unary operators.

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_- // Only works with -, +, ~ and !

  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  // Only available to methods without parameters
  println(mary isAlive)

  // Apply
  println(mary())
  // 
}
