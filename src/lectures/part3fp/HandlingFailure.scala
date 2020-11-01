package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // OPTIONS = when code throws a null
  // TRY = when code throws exceptions

  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("super failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMthod(): String = throw new RuntimeException("no string for you")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMthod())
  println(potentialFailure)

  // syntax sugar
  val anotherFailure = Try{
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess) // boolean, is true when it's success

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMthod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // IF you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  // => for-comprehension

  /*
    Exercise
   */
  val host = "localhost"
  val port = "8080"
  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // if you get the html page from the connection, print it to the console i.e. call renderHTML
  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  //
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for-comprehension
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  /*
    With imperative languages

    try {
      connection = HttpService.getConnection(host, port)
      try {
        page = connection.get("/home)
        renderHTML(page)
      } catch (some other exception) {

      }
    } catch (exception) {

    }
   */

}
