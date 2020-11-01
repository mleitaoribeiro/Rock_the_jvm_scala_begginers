package lectures.part3fp

object AnonymousFunctions extends App {

  //instantiating a function the normal way, with oop
  /*val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }*/

  //scala functional programming - uses anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2 //function1
  // or val doubler: Int => Int = ...

  // multiple parameters in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no parameter lambda
  val just = () => 3 // or
  val just2: () => Int = () => 5

  //careful
  println(just) // function itself
  println(just()) // function call with the result

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
    1. MyList: replace all functionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

}
