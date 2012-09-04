package httpz

object GET extends HttpVerbHandler
object POST extends HttpVerbHandler
object PUT extends HttpVerbHandler
object DELETE extends HttpVerbHandler
object HEAD extends HttpVerbHandler

trait HttpVerbHandler {
  def apply(uri: String): Request =
    Request(uri, 80, Nil)

  def apply(uri: String, port: Int): Request =
    Request(uri, port, Nil)
}

case class Request(uri: String, port: Int, headers: Vector[Pair[String, String]]) {

  def ::(port: Int): Request = {
    Request(uri, port, Nil)
  }

  def /(path: String): Request = {
    Request(uri + "/" + path, port, Nil)
  }

  // We can probably do this better
  def *&*(params: Iterable[Pair[String, String]]): Request = {
    val paramString = params.foldLeft("?") {
      (string, pair) => string + "&" + pair._1 + "=" + pair._2
    }
    Request(uri + paramString, port, Nil)
  }

  def *:*(headers: Iterable[Pair[String, String]]): Request = {
    Request(uri, port, headers.to[Vector])
  }

  // Merge two requests based on the union of their properties
  def \:/(other: Request): Request = {
    other
  }

  // Merge two requests based on the intersection of their properties
  def /:\(other: Request): Request = {
    other
  }

}

case class Response(response: String, headers: Iterable[Pair[String, String]]) {

  def >>::[T](f: Iterable[Pair[String, String]] => T): T = f(headers)

  // Make these better later on
  def json->[T](f: String => T) = f(response)
  def xml->[T](f: String => T) = f(response)

}

sealed trait HttpStatus
case object 200 extends HttpStatus { override def toString = "Okay" }
case object 404 extends HttpStatus { override def toString = "File Not Fount" }
