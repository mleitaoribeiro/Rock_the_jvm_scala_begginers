package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < =<

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .... side effects
  println(aVariable)

  // Instructions (DO) vs expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  var i = 0
  val aWhile = while (i<10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN!!!

  // EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3) // unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning
  
  // Code Blocks
  val aCodeBLOCK = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBLOCK)
  
  // 1. difference between "hello world" vs println("hello world")?
                          //value of type String        // side effect - type unit and prints a String
  // 2.

  //true
  val someValue = (
    2 < 3
  )
  println(someValue)

  //42
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)

  
  
}
