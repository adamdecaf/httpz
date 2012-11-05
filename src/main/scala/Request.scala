package httpz

object host {
  def apply(uri: String): Request = new Request(uri)
}

case class Request(uri: String, port: Int = defaultHttpPort, headers: Headers = emptyHeaders) {

  def port_=(port: Int): Request = Request(uri, port, headers)

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
