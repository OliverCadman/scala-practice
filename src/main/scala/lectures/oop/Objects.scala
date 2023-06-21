package lectures.oop

object Objects {

  object Person {
    val N_EYES = 2;
    def canFly: Boolean = false

    // Factory method! See below for explanation.
    def from(mother: Person, father: Person): Person = new Person("Bobby")

    // The above method can be called 'apply'
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  // We're defining a class Person, which has the same name as the object Person.
  class Person(val name: String) {

  }

  /**
   * Scala doesn't have "static"/"class-level" functionality.
   * It has objects.
   *
   * Objects are singleton instances of a class.
   * By singleton, that means that there is only one
   * version of an instance. Every time we reference an object,
   * we're pointing to the same object.
   */

    def main(args: Array[String]): Unit = {

      val mary = Person
      val john = Person

      println(mary == john) // true, because the Person object being assigned are both referencing the singleton object.

      /**
       * A very common practice in object-oriented programming is the idea of COMPANIONS.
       * A companion is a class or object that has the same name as another class or object either in the same
       * file, or even in the same scope.
       *
       * One of the ways that companions are used; the object will contain 'factory' methods, which serve
       * to build instances of the companion class.
       */


      val mark = new Person("John")
      val jerry = new Person("Jerry")
      val bobbie = Person(mark, jerry)

      println(bobbie.name)

      println(mark == jerry)
    }
}
