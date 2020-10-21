package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(x: Int, accumulator: Int = 1): Int =
    if (x <= 1) accumulator
    else trFact(x - 1, x * accumulator)

  val fact10 = trFact(10 , 1)


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  //savePicture(800) - compiler doesn't know that 800 is the width, because width it's not the first parameter

  /* Solutions:
      1. pass in every leading argument
      2. name the arguments
   */

  //1
  savePicture(width = 800)

  //2
  savePicture(height = 600, width = 800, format = "bmp")



}