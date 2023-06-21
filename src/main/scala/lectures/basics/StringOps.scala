package lectures.basics

object StringOps extends App {

  val myString: String = "Hello, I am learning Scala."

  println(myString.charAt(2))
  println(myString.substring(7, 11))
  println(myString.split(" ").toList)
  println(myString.startsWith("Hello"))
  println(myString.replace(" ", "-"))
  println(myString.toUpperCase())
  println(myString.toLowerCase())
  println(myString.length)

  val aNumberString = "42"
  val anotherNumberString = "2"
  println(aNumberString.toInt)

  println("a" +: aNumberString)
  println('a' +: anotherNumberString :+ 'z')


  println(myString.reverse)
  println(myString.take(4))

  // SCALA SPECIFIC STRING INTERPOLATORS

  // s-interpolators
  // Work in a similar way to template literals (JS)

  val name = "Oliver"
  val age = 33
  val greeting = s"Hi, my name is $name and I am $age years old."

  // s-interpolators can also evaluate complex expressions
  val anotherGreeting = s"I will be turning ${age + 1} next year."

  println(greeting)
  println(anotherGreeting)


  // f-interpolators
  // Similar to s-interpolators, but they can also format decimal numbers.

  val speed = 111.2f
  // The %2.2f is an f-like formatter.
  // 2.2 - The first 2 denotes two characters total minimum. The second 2 denotes 2 decimal place precision.
  val myth = f"Dave can eat $speed%2.2f burgers per minute."

  val pi = f"${Math.PI}%1.5f"
  println(myth)
  println(pi)

  // raw interpolators
  // Raw interpolators can print characters literally.

  val rawString = raw"This is a \n new line"
  val string = "This is a \n new line"

  println(rawString)
  println(string)
  println(raw"$string")
}
