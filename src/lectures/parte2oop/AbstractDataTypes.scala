package lectures.parte2oop

object AbstractDataTypes extends App {

  // abstract classes - they have uncompleted methods or fields, subclasses do it

  abstract class Animal { //cannot be instantiated
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    def eat: Unit = println("crunch, crunch")

  }

  //traits
  trait Carnivore { //also abstract like a class with abstract methods, but can be inherited along classes
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"

  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("crunch, crunch")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes - both can have both abstract and no abstract methods
  // 1. traits cannot have constructed parameters
  // 2. multiple traits may be inherited by the same class
  // 3. traits = behaviour, abstract class is a type of thing

}
