package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // Use cases of pattern matching
  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  // extract values from the class
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }

  println(greeting)

  /*
    1. cases are matched in order
    2. what if no case is matched? MatchError - always use wildcard
    3. type of the PM expression? unified type of all the types in all the cases
    4. PM works really well with case classes
   */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed") // compiler error because is a sealed class and the matching is not finished
  }

  // match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  // or
  val isEvenCond =
    if (x % 2 == 0) true
    else false
  // Why do the PM???? overkill
  // Instead
  val isEvenNormal = x % 2 == 0

  /*
    Exercise
    simple function uses PM
    takes an Expr => human readable form

    Sum(Number(2), Number(3)) => 2 + 3
    Sum(Sum(Number(2), Number(3)), Number (4)) = 2 + 3 + 4
    Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
    Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e3, e4) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeShowParentheses(e3) + " * " + maybeShowParentheses(e4)
    }
    case _ => "error"
  }

  val expr1 = Sum(Number(2), Number(3))
  val expr2 = Sum(Sum(Number(2), Number(3)), Number (4))
  val expr3 = Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))
  val expr4 = Sum(Prod(Number(2), Number(1)), Number(3))
  println(show(expr1))
  println(show(expr2))
  println(show(expr3))
  println(show(expr4))

}
