package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming} //if we have a lot to import from playground, we use import playground._
                                //alias for Cinderella, useful when we need to call two classes with the same name from different packages

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  //classes in the same package (package members) are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJvm", 2018)

  // if not, we have to import the package
  val princess = new Princess

  //or write the full name
  val princess2 = new playground.Cinderella // playground Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object - when we need to access universal methods or constants outside classes
  // rarely use
  sayhello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  val date = new Date //assumes the first import, but we can do it another away so the compiler knows
  val sqlDate = new java.sql.Date(2018, 5, 4) // 1.we used fully qualified name

  // 2. we used aliasing
  val sqlDate2 = new SqlDate(2018, 5, 4)

  // default imports - automatically imported
  // java.lang - String Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println etc

}
