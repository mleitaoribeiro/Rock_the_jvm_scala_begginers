package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)

  println(list.head)
  println(list.tail)

  // map - for each element in the list it does something
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter - it filters the elements we want with a condition
  println(list.filter(_ % 2 == 0))

  // flatMap -
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // 1. Print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")
  // List('a1', 'a2', ... , 'd4')

  // substitution of loops in conventional languages - iterations
  // 2 loops - 1 flatmap and 1 map
  // 3 loops - 2 flatmaps and 1 map
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  val combinations2 = numbers.flatMap(n => chars.flatMap(c => colors.map(col => "" + c + n + "-" + col)))
  println(combinations2)


  //foreach
  list.foreach(println)

  //for-comprehensions - he have the same as combinations, but is more readable - compiler is doing flatmaps and maps
  val forCombinations = for {
    n <- numbers
    c <- chars
    col <- colors
  } yield "" + c + n + "-" + col
  println(forCombinations)

  //and we can use filter too in for-comprehensions
  val forCombinationsEven = for {
    n <- numbers if n % 2 == 0
    c <- chars
    col <- colors
  } yield "" + c + n + "-" + col
  println(forCombinationsEven)

  //identical to foreach
  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1. MyList supports for comprehension? - yes
       map(f: A => B) => MyList[B]
       filter(p: A => Boolean) => MyList[A]
       flatMap(f: A => MyList[B] => MyList[B]

    2. A small collection of at most ONE element - Maybe[+T]
       - map, flatmap, filter
   */

}
