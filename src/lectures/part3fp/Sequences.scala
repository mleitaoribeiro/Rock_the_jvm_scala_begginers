package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,4,3,2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  //concatenation
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10 // 10 not included
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello")) // to includes 10

  //Lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89 // or :: for prepending
  println(prepended)

  val apples5 = List.fill(5)("apple") // fill 5 times with the word apple
  println(apples5)
  println(aList.mkString("-"))

  //Array
  val numbers = Array(1,2,3,4)
  val threeElems = Array.ofDim[Int](3) // for primitive types, defaults values as 0 or false are allocated
  println(threeElems)
  println(threeElems.mkString("Array(", ", ", ")"))
  threeElems.foreach(println)

  val threeStrings = Array.ofDim[String](3) // for Strings, it allocates null values
  println(threeStrings.mkString("Array(", ", ", ")"))
  threeStrings.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and sequences
  val numbersSeq: Seq[Int] = numbers // implicit conversion - the compiler finds a way xD
  println(numbersSeq) // it converts the sequence in a Wrapped Array

  // vectora
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  // List
  // advantage - keeps reference to tail, first element really quick
  // disadvantage - updating an element in the middle takes long

  println(getWriteTime(numbersList))

  // Vector - a lot fast
  // advantage - depth of the tree is small,
  // disadvantage - needs to replace entire 32 branch tree and replace that all elements
  println(getWriteTime(numberVector))

}
