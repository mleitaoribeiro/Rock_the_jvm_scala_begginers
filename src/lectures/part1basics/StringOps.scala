package lectures.part1basics

object StringOps extends App{

  val str: String = "Hello, Iam learning Scala"

  println(str.charAt(2)) // found a char at a index
  println(str.substring(7, 11)) // part of the string, from index 7 to 11 in this example
  println(str.split(" ").toList) // split the String where the character " " is present
  println(str.startsWith("Hello")) // prints true or false if the beginning of the phrase is Hello
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt //conversion string in int
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"
  println(anotherGreeting)

  //F-interpolaters - format
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolater - print characters literally
  println(raw"This is a \n newline") // only works in rare characters in the string and not when we use variabel expansion e.g. $name
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
