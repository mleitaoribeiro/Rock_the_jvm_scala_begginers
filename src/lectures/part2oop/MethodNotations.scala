package lectures.part2oop

object MethodNotations extends App {

  class Person(val name:String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie:String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person (this.name + s" ($nickname)", this.favoriteMovie)

    def unary_! : String = s"$name, what the reck?!"

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age+1)

    def isAlive : Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    //overload apply
    def apply(number: Int): String = s"$name watched $favoriteMovie $number times"

    def learns (string: String): String = s"$name learns $string"

    def learnsScala() : String = learns("Scala")
  }

  val mary = new Person("Mary", favoriteMovie = "Inception")
  val tom = new Person("Tom", favoriteMovie = "Fight Club")

  println((mary + "the Rockstar")())
  println((+mary).age)
  println(mary learns("Akka"))
  println(mary learnsScala)
  println(mary(2))

  /*
    1. Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)

    2. Add an age to the Person class with default 0 value
       Add a unary + operator => new person with the age + 1
       +mary => mary with the age incrementer

    3. Add a learns method in the Person class with a String parameter => results in a sentence Mary learns "parameter"
       Add a learnsScala method with no parameter that calls learns method with "Scala" as parameter
       use it in postfix notation

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception n(2) times"
   */

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = "operator" notation - only methods with single parameter
  // this way of writing methods is called syntactic sugar - ways to writing code easier

  // "operators" in Scala
  println(mary + tom)
  // in scala methods can have any name inclunding operators like + - * % & etc
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))
  println(1+2)

  // All operators are methods in scala
  // Akka actors have ! ? has methods

  //prefix notation
  val x = -1 //it's the same was bellow, - is a unary operator - are methods with unary underscore prefix
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation - can only be used without method parameters
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // it's the same as above
  // when we call an object like it was a method, the compiler is going to look for the apply method in the class

}
