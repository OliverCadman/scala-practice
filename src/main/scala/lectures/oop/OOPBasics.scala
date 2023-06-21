package lectures.oop

object OOPBasics extends App {

  val person = new Person("Oliver", 33)
  println(person.age)
  println(person.name)

  val behaviouralPerson = new PersonWithBehaviour("Person with Behaviour", 33)
  println(behaviouralPerson.x)

  behaviouralPerson.greet("Daniel")
  behaviouralPerson.greet()
}

class Person(val name: String, val age: Int)

// CLASS PARAMETERS ARE NOT FIELDS ^^^^^^
// You need to add a val or var keyword before your parameter if you want
// it to behave like a class field, and access it using dot notation on an instance of that class.

class PersonWithBehaviour(val name: String, val age: Int) {
  // Body
  // You can do anything inside of a class body that you would in a
  // code block expression.

  val x: Int = 2

  // Method
  def greet(name: String): Unit = {
    println(s"Hey $name, I am ${this.name}")
  }
  def greet(firstName: String, secondName: String): Unit = {}

  def greet(another: Int): Unit = {}

  def greet(andAnother: Boolean): Unit = {}

  // Overloading
  def greet(): Unit = {
    println(s"Hey, my name is $name")
  }

  // Multiple Constructors!
  def this(name: String) = this(name, 0)
}

