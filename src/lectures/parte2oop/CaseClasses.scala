package lectures.parte2oop

object CaseClasses extends App {

  /*
    equals, hashCode, to String
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 24)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)
  println(jim.toString)

  // 3. equals and hashCode implemented out of the box - yeah!!!
  val jim2 = new Person("Jim", 24)
  println(jim == jim2)

  // 4. Case classes have handy copy methods
  val jim3 = jim.copy(age = 45)

  // 5. Case classes have companion objects - automatic
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method works like a constructor. normally we instantiate like this and we
  // don't use new Person

  // 6. CCs are serializable
  // Akka - messages are case classes

  // 7. CCs have extractor pattern = CCs can be use in PATTERN MATCHING

  // 8. There are case objects, same properties as case classes except they don't have companion objects, they are their own companion object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }


  /*
    Expand MyList - use case classes and case objects
   */



}
