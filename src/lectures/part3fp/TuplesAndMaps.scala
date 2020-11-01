package lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "helo, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) //2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is syntactic sugar for (a,b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim")) // boolean - true if this key exists
  println(phonebook("Jim")) // apply method to show the value correspondent to this key, if the key does not exist the program crashes
                            // we can add .withDefaultValue property and a value that is return when a key doesn't exist
  println(phonebook("mary")) // key does not exist, value is -1

  // add a pairing - maps are immutable so when we add a pairing we instantiate a new map
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.view.mapValues(number => number * 10))

  // conversions to other collections
  println(phonebook.toList) // conversion is made in pairs
  val list = List(("Daniel", 555))
  println(list.toMap)
  val names = List("Bob", "Bulma", "James", "Mary", "John", "Martha")
  println(names.groupBy(name => name.charAt(0))) // groups the names with the same initial letter

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900? "JIM" overlap and the second disappears

       !!!! careful with mapping keys, they cannot overlap, otherwise we lose data

    2. Overly simplified social network based on maps
       Person = String - association between a person and a list of friends (Strings) with a map
       - add a person to the network
       - remove
       - friend a person (mutual)
       - unfriend (mutual)

       - number of friends of a person
       - person with most friends
       - how many people have NO friends
       - if there is a social connection between two people (direct or not)

   */


  // add a person to the network
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))


    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val emptyNetwork: Map[String, Set[String]] = Map() //empty network

  val network = add(add(emptyNetwork, "Bob"), "Mary" )
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //Jim, Bob, Mary
  val people = add(add(add(emptyNetwork, "Bob"), "Mary" ), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends (network: Map[String, Set[String]], person: String) = {
    if (!network.contains(person)) 0
    else (network(person).size)
  }

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.view.count(pair => pair._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

}
