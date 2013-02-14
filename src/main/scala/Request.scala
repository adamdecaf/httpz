package httpz

object host {
  def apply(uri: String) = Request(uri)
}

// For these maybe use java.net.URI under a wrapper?

final class RequestOpsWrapper(val req: Request) extends AnyVal {

  def setPort(p: Int): Request = req.copy(port = p)
  def getPort(): Int = req.port

  def setPath(path: String): Request = req.uri.split("/").take(3) match {
    case Array(scheme, _, host) =>
      val maybeExtraSlash = if (!path.startsWith("/")) "/" else ""
    req.copy(uri = scheme + "//" + host + maybeExtraSlash + path)
  }

  def getPath(): String = req.uri.split("/").drop(3).mkString("/")

  def /(path: String): Request = {
    val maybeExtraSlash = if (!req.uri.endsWith("/") && !path.startsWith("/")) "/" else ""
    req.copy(uri = req.uri + maybeExtraSlash + path)
  }

  // Doesn't really work on edge cases
  def setParams(params: Traversable[Pair[String, String]]): Request = {
    val paramString = params.foldLeft("") {
      (paramStr, pair) => paramStr + "&" + pair._1 + "=" + pair._2
    }
    req.copy(uri = req.uri + "?" + paramString.drop(1))
  }

  // todo: def getParams(): Traversable[Pair[String, String]]
  def getParams(): String = req.uri.split("""\?""") match {
    case Array(_, path) => path
    case a => println(a.toList); ""
  }

  // Doesn't really work with existing params..
  def addParams(p: Traversable[Pair[String, String]]): Request = {
    val paramString = p.foldLeft(""){ (acc, pair) => acc + "&" + pair._1 + "=" + pair._2 }
    req.copy(uri = req.uri + paramString)
  }

  def setHeaders(headers: Traversable[Pair[String, String]]): Request = {
    req.copy(headers = Some(headers))
  }

  def getHeaders(): Map[String, String] = req.headers match {
    case Some(headers) => headers.toMap
    case None          => Map.empty
  }

  def addHeaders(headers: Traversable[Pair[String, String]]): Request = req.headers match {
    case Some(_) | None if (headers.isEmpty) => req
    case Some(h)                             => req.copy(headers = Some(h ++ headers))
    case None                                => req.copy(headers = Some(headers))
  }

  def setPostValues(values: Traversable[Pair[String, String]]): Request = {
    req.copy(postValues = Some(values))
  }

  def getPostValues(): Traversable[Pair[String, String]] = req.postValues match {
    case Some(pv) => pv
    case None     => Iterable.empty
  }

  def addPostValues(values: Traversable[Pair[String, String]]): Request = req.postValues match {
    case Some(_) | None if (values.isEmpty) => req
    case Some(pv)                           => req.copy(postValues = Some(pv ++ values))
    case None                               => req.copy(postValues = Some(values))
  }

  // Doesn't handle merging the paths or anything..
  // req.addParams(other.getParams())
  // Doesn't handle different ports..
  def mergeWith(other: Request) = {
    req.addHeaders(other.getHeaders()).addPostValues(other.getPostValues())
  }
}
