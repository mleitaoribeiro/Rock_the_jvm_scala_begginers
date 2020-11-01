package lectures.part2oop

object Inheritance extends App {

  //single class inheritance - extend one class at a time
  sealed class Animal {
    val creatureType = "wild"

    //private is for Animal class only, protected for sub classes also
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) // no need for age because of the second constructor
  //when we instantiate a subClass object, the compiler will call the superclass constructor first, so here we have to extend the name and age also

  //overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat //method eat from the super class
      println("crunch, crunch")
    }

  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING VS overLOADING

  // super - method or field in the parent class

  // preventing overrides:
  // 1 - use the keyword final
  // 2 - use final in the class
  // 3 - seal the class = is possible to extend classes in this File, but prevent extension in other files
         // often used when we want to be exhausted in inheritance, e.g. cats and dogs are the only animals that we can have so we sealed the class Animal to this file



}
