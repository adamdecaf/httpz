package httpz

object host {
  // TODO: Do some detection on this to
  // a) confirm it's a valid uri
  // b) figure out the port
  def apply(s: NonEmptyString): Request = new Request(s, 80, Vector())
}

// Maybe headers should be a more solidified type. Or a Pair[Stirng, String]*
case class Request(uri: NonEmptyString, port: Int, headers: Headers) {

  def port_=(port: Int): Request = {
    Request(uri, port, Nil)
  }

  def /(path: String): Request = {
    val extraSlash = if (!uri.endsWith("/") && !path.startsWith("/")) "/" else ""
    Request(uri + extraSlash + path, port, headers)
  }

  // We can probably do this better
  def *&*(params: UrlParams): Request = {
    val paramString = params.foldLeft("") {
      (string, pair) => string + "&" + pair._1 + "=" + pair._2
    }
    Request(uri + "?" + paramString.drop(1), port, headers)
  }

  def *:*(headers: Headers): Request = {
    Request(uri, port, headers)
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
