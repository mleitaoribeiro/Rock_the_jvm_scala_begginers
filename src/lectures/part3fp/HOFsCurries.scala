package lectures.part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean) => Int) => (Int => Int)) = null
  // higher order function (HOF)
  // e.g. are map, flatMap, filter in MyList

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x))
  // nTimes(f, n. x) = f(f(......f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // ntb(f,n) = x => f(f(f......(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne.....(x))
  // val y = increment10(1)
  def nTimesBetter (f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))
  println(nTimesBetter(plusOne,10)(1))

  //curried functions
  val superAdder: Int => (Int => Int) = (v1: Int) => (v2:Int) => v1 + v2
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
    1. Expand MyList
       - foreach method A => Unit, add a foreach method for each element this does a side effect
         [1,2,3].foreach(x => println(x)) numbers printed in each line

       - add a sort function ((A, A) => Int) => MyList, compares two functions, negative if 1st less than 2nd
         [1,2,3].sort((x, y) => y - x) => [3,2,1]

       - zipWith (list, (A, A) => B) => MyList[B]
         [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5 , 3 * 6] = [4, 10, 18]

       - fold(start)(function) => a value
         [1,2,3].fold(0)(x + y) = 6

     2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
        fromCurry(f: (Int => Int => Int) =< (Int, Int) => Int

     3. compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))
   */

  //2.
  def toCurry(f: (Int, Int) => Int): Int => Int => Int =
    x => y => f(x,y)

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def superAdder2: Int => Int => Int = toCurry(_ + _)
  println(superAdder2(4)(17))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4, 17))

  //3. Documentation for functionX - have these 2 functions
  def compose[A,B,T](f: A => B, g: T => A): (T => B) =
    x => f(g(x))

  def andThen[A,B,T](f: A => B, g: B => T): (A => T) =
    x => g(f(x))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add3, times3)
  val ordered = andThen(add3, times3)

  println(composed(4))
  println(ordered(4))

}
