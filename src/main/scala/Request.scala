package httpz

// Maybe headers should be a more solidified type. Or a Pair[Stirng, String]*
case class Request(uri: String, port: Int, headers: Headers) {

  def ::(port: Int): Request = {
    Request(uri, port, Nil)
  }

  def /(path: String): Request = {
    Request(uri + "/" + path, port, Nil)
  }

  // We can probably do this better
  def *&*(params: UrlParams): Request = {
    val paramString = params.foldLeft("?") {
      (string, pair) => string + "&" + pair._1 + "=" + pair._2
    }
    Request(uri + paramString, port, Nil)
  }

  def *:*(headers: Headers): Request = {
    Request(uri, port, Vector())
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
