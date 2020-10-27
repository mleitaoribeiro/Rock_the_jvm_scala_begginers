package lectures.parte2oop

object AnonymousClasses extends App {

  abstract class Animal {
   def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahhahaha")
  }

  /*
    equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahahahhahaha")
    }

    val funnyAnimal: Animal = new AnonymousClasses$$anon$1 / but compiler does this behind the scenes

    for this not to happen we have to be sure to define all the abstract methods when we extend an abstract class
  */

  println(funnyAnimal.getClass)

  // anonymous classes both work with abstract and non abstract classes
  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }


  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can be of service?")
  }

  /*
    1. Generic trait My Predicate[-T] with method test(T) returns Boolean
    2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3. MyList:
       - map (transformer) => MyList
       - filter (predicate) => MyList
       - flatMap(transformer from A to MyList [B]) => MyList [Int]

       class EvenPredicate extends MyPredicate[Int]
       class StringToIntTransformer extends MyTransformer[String, Int]

       [1,2,3].map(n * 2) = [2,4,6]
       [1,2,3,4].filter(n % 2) = [2,4]
       [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */

}
