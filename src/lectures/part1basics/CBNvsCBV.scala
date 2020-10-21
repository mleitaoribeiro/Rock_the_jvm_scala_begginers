package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()) // time is estimated here and then that number is the value of x
  calledByName(System.nanoTime()) // no time estimation and x = System.nanoTime - 2 different values

  def infinitive(): Int = 1 + infinitive()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinitive(), 34)
  printFirst(34, infinitive())
}
