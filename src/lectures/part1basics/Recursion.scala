package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def aFactorialFunction (n: Int): Int = {
    if (n == 1) n
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * aFactorialFunction(n-1)
      println("Computing factorial of " + n)

      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    ...
    = factHelper(1,1 * 2 * 3 * ... * 8 * 9 * 10 * 1)
    = 1 * 2 * 3 * ... * 8 * 9 * 10)
   */
  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  //1.
  def concatenateString(aString: String, n: Int): String = {
    @tailrec
    def concHelper(anotherString: String, x: Int, accumulator: String): String = {
      if (x == 1) accumulator
      else concHelper(anotherString, x-1, anotherString + accumulator)
    }

    concHelper(aString, n, aString)
  }
  println(concatenateString("hello", 10))


  //2.
  def isPrimeNumber(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)


    isPrimeTailrec(n/2, true)
  }
  println(isPrimeNumber(2003))
  println(isPrimeNumber(629))

  //3.
  def aFibonacciFunction (n: Int): Int = {
    @tailrec
    def fibotHelper(x: Int, accumulator1: Int, accumulator2: Int): Int = {
      if (x >= n) accumulator1
      else fibotHelper(x + 1, accumulator2 + accumulator1, accumulator1)
    }

    if (n <= 2) 1
    fibotHelper(2, 1, 1)
  }
  println(aFibonacciFunction(2))
  println(aFibonacciFunction(5))
}