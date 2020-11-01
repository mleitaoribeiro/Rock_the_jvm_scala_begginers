package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("5")+4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1. A function which takes 2 strings and concatenates them
    2. transform MyPredicate and MyTransformer into function types
    3.
       define a function which takes an argument (int) and returns another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */

  //1.
  val aFunction: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  //2. In MyList - high-order function

  //3.

  //Function1[Int, Function[Int, Int]]
  val superAdder: Function1[Int, Function[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) //curried function, multi parameter list, receives one parameter and a function as another parameter

  //superAdder with lambdas
  val specialAdder = (v1: Int) => (v2:Int) => v1 + v2

  println(specialAdder(3)(7))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
