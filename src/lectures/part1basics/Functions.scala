package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterFunction(): Int = 42
  println(aParameterFunction())
  println(aParameterFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello",3))

  //WHEN YOU NEED LOOPS, USE RECURSION

  //Always specify the return type of a function because sometimes the compiler doesn't know what is returned e.g.
  // recursive functions

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting function (name, age) =< "Hi, my name is $name and I am $age years old"
    2. Factorial function 1 * 2 * 3 * ... * n - recursive function
    3. A Fibonacci function
       f(1) = 1
       f(2) = 1
       f(n) = f(n - 1) + f(n - 2)
    4. Tests if a number is prime
   */

  //1.

  def aGreetingFunction (name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  println(aGreetingFunction("Marta", 29))

  //2.

  def aFactorialFunction (n: Int): Int = {
    if (n == 1) n
    else n * aFactorialFunction(n-1)
  }
  println(aFactorialFunction(1))
  println(aFactorialFunction(5))

  //3.
  def aFibonacciFunction (n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)
  }
  println(aFibonacciFunction(1))
  println(aFibonacciFunction(2))
  println(aFibonacciFunction(3))
  println(aFibonacciFunction(8))

  //4.
  def isPrimeNumber(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }
  println(isPrimeNumber(37))
  println(isPrimeNumber(2003))
  println(isPrimeNumber(4))
}
