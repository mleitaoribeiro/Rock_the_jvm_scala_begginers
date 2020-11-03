package lectures.part4pm

import exercices.{Empty, Cons, MyList}

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"i've found $something"//try to extract this if the rest of the pattern matches
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  //PM can be nested!!!!

  // 4 - case classes - constructor pattern
  // PMs can be nested with Case Classes as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList: Unit = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }

  // 5 - list patterns
  val aStandardliST = List(1, 2, 3, 42)
  val standardListMatching = aStandardliST match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // "var art" pattern - list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // infix patterns
  }

  // 6 - type specifiers

  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case noneEmptyList @ Cons(_, _) => // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _) => // name binding inside nested pattern
  }

  // 8 - multi-patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // compound patterns (multi-pattern)
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(speciaElement, _)) if speciaElement % 2 == 0 =>
  }

  //ALL

  /*
    Question
   */

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings : List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch)
  // JVM trick question


}
