package lectures.parte2oop

object Generics extends App {

  class MyList[+A] {
    //use the type A
    def add[B >: A] (element: B) : MyList[B] = ???
    /*
      A = cat
      B = Animal (Dog)
     */
  }

  class MyMap[Key, Value]


  val listIntegers = new MyList[Int]
  val listString = new MyList[String]


  //generic methods

  object MyList {

    def empty[A]: MyList[A] = ???

  }

  val emptyListIntegers = MyList.empty[Int]


  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal = covariance
  class CovariantList[+A] // +A means it's a covariance list
  val Animal: Animal = new Cat
  val AnimalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???? HARD DECISION => we return a list of animals in this situation

  // 2. NO = INVARIANCE
  class InvariantList[A] // no signs before or after
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]


  // 3. Hell, no!! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  //bounded types
  class Cage[A <: Animal] (animal: A)// means class cage only accepts type A that are subtype of Animal, if it is >: means a supertype
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car)


  // expand MyList to be generic







}
