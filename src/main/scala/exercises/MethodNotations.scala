package exercises

import scala.language.postfixOps

/**
 * // INFIX
 * 1. Overload the + method to take a string parameter.
 *      Return a new instance of Person with string concatenated to name
 *
 * // PREFIX
 * 2. Add age to Person class with default 0 value
 *      Add a unary_+ operator that increments the age value and returns a new Person
 *
 *
 * 3. Add learns method in Person class. Receives a string parameter and returns sentence
 *      which says '<person> learns Scala'
 *
 *    Add learnsScala method with no parameters. Calls 'learns' method with Scala as parameter.
 *    Use this in postfix notation.
 *
 * 4. Overload the apply method to receive a number, and return a string.
 *      => mary.apply(2) => 'Mary watched ${favouriteMovie} 2 times.
 */

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String):Boolean = movie == favouriteMovie

    def +(person: Person): String = s"$name is hanging out with ${person.name}"

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favouriteMovie, age)

    def unary_! : String = s"What the heck!"

    def isAlive: Boolean = true

    def apply(): String = s"Hey, my name is $name and I like $favouriteMovie"

    def apply(num: Int): String = s"Hey, my name is $name and I have watched $favouriteMovie $num times."

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def learns(subject: String): String = {
      s"$name learns $subject"
    }

    def learnsScala: String = {
      learns("Scala")
    }
  }

  val mary = new Person("Mary", "Inception")
  val rockstar = mary + "the rockstar"
  println(rockstar())
  println((+rockstar).age)

  println(mary learnsScala)
  println(mary(5))
}
