package lectures.part4pm

object PatternsEverywhere extends App {

  // big idea #1
  try {
    // CODE
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // catches are actually MATCHES
  /*
    try {
      // code
    } catch (e) {
      e match {
        case e: RuntimeException => "runtime"
        case npe: NullPointerException => "npe"
        case _ => "something else"
      }
    }
   */

  // big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1 ,2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  // PM also valid for case classes, :: operators

  // big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b) // it has the value of 2
  // multiple value definitions are based on PATTERN MATCHING\
  // ALL THE POWER

  val head :: tail = list // pattern is head :: tail
  println(head) // prints 1
  println(tail) // prints 2,3,4

  // big idea #4 - NEW
  // partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal are based on PATTERN MATCHING - advanced

  // it's the same as
  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }
  println(mappedList)

}
