package exercices

abstract class Maybe[+A] {

  def map[B](f: A => B): Maybe[B]
  def flatMap[B](f: A => Maybe[B]): Maybe[B]
  def filter(p: A => Boolean): Maybe[A]

}

case object MaybeNot extends Maybe[Nothing] {

  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot

}

case class Just[+A](value: A) extends Maybe[A] {


  def map[B](f: A => B): Maybe[B] = {
    new Just[B](f(value))
  }

  def filter(p: A => Boolean): Maybe[A] = {
    if(p(value)) this
    else MaybeNot
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    f(value)
  }

}

object maybeTest extends App {

  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter((_ % 2 == 0)))

}
