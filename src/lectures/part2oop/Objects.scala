package lectures.part2oop

object Objects { // we use objects for class level definition in scala

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ( no "static), instead has objects
  //Objects can have var, val and methods like a class but can not have parameters
  object Person { //can have a type, but it is its only instance and the name is person
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    //factory method, built persons using some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) { // THE OBJECT ABOVE IS NO LONGER THE ONLY INSTANCE OF person, because there is a class too
    // instance-level functionality

  }

  //here object and class are COMPANIONS because he have one object and one class with the same name and the same scope

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    //Differences between object and class

    //Scala object is a singleton instance by definition, no need to code specifically for this

    val will = Person
    val daniel = Person

    println(will == daniel) // they point to the same and only instance - object

    //but if we have class and object with the same name, we can have two person
    val mary = new Person("mary")
    val john = new Person("john")

    println(will == daniel) //it's false

    val bobby = Person(mary, john) // apply method
  }

  // Scala Applications = only scala object with
  // def main(args: Array[String]): Unit - java virtual machine entry is here


}
