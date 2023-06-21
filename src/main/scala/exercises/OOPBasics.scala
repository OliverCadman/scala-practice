package exercises

/**
 *
 * Create two classes:
 *  - Writer(firstName, lastName, yearOfBirth)
 *      Methods - fullName => string concat
 *
 *  - Novel(title, yearOfRelease, author)
 *      Methods - authorAge, isWrittenBy, copy => new instance of novel with new year of release
 *
 *
 * Create counter class
 *  Receives an integer
 *    Methods
 *      currentCount =>
 *      increment(count) => return new Counter
 *      decrement(count) => return new Counter
 *      increment() => return new Counter
 *      decrement() => return new Counter
 */

class Writer(firstName: String, lastName: String, val yearOfBirth: Int) {
    def fullName(): String = {
      s"$firstName $lastName"
    }
}

class Novel(title: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): String = {
    s"The age of the author is ${yearOfRelease - author.yearOfBirth}"
  }

  def isWrittenBy(author: String): Boolean = {
    author == this.author.fullName()
  }

  def copy(newYearOfRelease: Int): Novel = {
    new Novel(this.title, newYearOfRelease, this.author)
  }
}

class Counter(val count: Int) {
  def currentCount(): Unit = {
    println(s"The current count is $count")
  }

  def increment(): Counter = {
    println("Incrementing")
    val newCount = count + 1
    new Counter(newCount)
  }

  def decrement(): Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def increment(count: Int): Counter = {
    if (count <= 0) this
    else increment().increment(count - 1)
  }

  def decrement(count: Int): Counter = {
    if (count <= 0) this
    else decrement().decrement(count - 1)
  }
}

object OOPBasics extends App {


  var counter = new Counter(1)
  counter.increment().currentCount()
  counter.increment(5).currentCount()


  val jrrTolkien = new Writer("J.R.R", "Tolkien", 1892)
  val theHobbit = new Novel("The Hobbit", 1937, jrrTolkien)

  println(theHobbit.authorAge())
  println(theHobbit.isWrittenBy("J.R.R Tolkien"))
}
