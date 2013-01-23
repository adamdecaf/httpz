package httpz

object host {
  def apply(uri: String) = Request(uri)
}

object RequestOps {
  implicit final class RequestOpsWrapper(val req: Request) extends AnyVal {

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

    def setParams(params: Traversable[Pair[String, String]]): Request = {
      val paramString = params.foldLeft("") {
        (paramStr, pair) => paramStr + "&" + pair._1 + "=" + pair._2
      }
      req.copy(uri = req.uri + "?" + paramString.drop(1))
    }

    // def getParams(): Traversable[Pair[String, String]] = req.params match {
    //   case Some(p) => p
    //   case _       => Traversable.empty[Pair[String, String]]
    // }

    // def addParam(param: Pair[String, String])
    // def addParams(param: Iterable[Pair[String, String]])

    // def setHeaders(): Request =
    // def getHeaders(): Traversable[Pair[String, String]] = req.headers match {
    //   case Some(h) => h
    //   case _       => Traversable.empty[Pair[String, String]]
    // }

    // def addHeader(header: Pair[String, String])
    // def addHeaders(headers: Iterable[Pair[String, String]])

    // Non-default port is higher priority
    // combine headers and postVals
    // combine paths?
    // def mergeRequests(req: Request)
  }
}
