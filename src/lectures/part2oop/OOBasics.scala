package lectures.part2oop

object OOBasics extends App {

  val person = new Person ("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()
  println(person.age)

  val writer = new Writer("John", "Sullivan", 1990)
  val imposter = new Writer("John", "Sullivan", 1990)
  val novel = new Novel("Tulips", 2010, writer)
  println(writer.fullname)
  println(novel.authorAge())
  println(novel.isWrittenBy(imposter))


  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

class Person (name: String, val age: Int = 0) {
  // body
  // val and var definitions
  val x = 2

  println(1 + 3)

  def greet (name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet (): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0) // not very useful, we can do it in the primary constructor
  def this() = this("John Doe")
}

  // class parameters are NOT class FIELDS, cannot be called with a dot

  /*
    Novel and a Writer class

    Writer: first name, surname, year of birth
      - method fullname

    Novel: name, year of release, autor
    - authorAge at the year of release
    - isWrittenBy(author)
    - copy (new year of release) = new instance of novel with new year of release

   */

class Writer (val firstName: String, val surname: String, val yearBirth: Int) {

  def fullname (): String = {
    firstName + " " + surname
  }
}

class Novel (val name: String, val yearRelease: Int, val author: Writer) {

  def authorAge(): Int = {
    this.yearRelease - author.yearBirth
  }

  def isWrittenBy(author: Writer) = {
    this.author == author
  }

  def copy (newYearRelease: Int): Novel = {
    new Novel(this.name, newYearRelease, this.author)
  }

}

  /*
    Counter class
      - receives an int value
      - method current count
      - method to increment/decrement the counter by one => new Counter
      - overload int/dec to receive an amount
   */

class Counter (val accumulator: Int = 0) {

  // def currentCount: Int = accumulator - is replaced by the constructor

  def dec: Counter = {
    println("decrementing")
    new Counter(accumulator-1)
  } // immutability
  def inc: Counter = {
    println("incrementing")
    new Counter(accumulator+1)
  }

  //overload
  def dec(amount: Int): Counter = {
    if (amount >= 0) this
    else dec.dec(amount-1)
  }

  def inc(amount: Int): Counter = {
    if (amount <= 0) this
    else inc.inc(amount-1)
  }

  def print: Unit = println(accumulator)
}

