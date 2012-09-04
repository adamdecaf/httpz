package httpz

object Http extends HttpImpl with ApacheHttpContext {

  //def apply(uri: String): Response = this(Request(uri, 0, Nil))
  def apply(req: Request): Response = execute(req)

}

private[httpz] trait HttpImplInterface {

  def execute(req: Request): Response

}

// Research this better to figure out a common api
private[httpz] trait HttpContext
private[httpz] trait ApacheHttpContext extends HttpContext

private[httpz] trait HttpImpl extends HttpImplInterface {
  this: HttpContext =>

  def execute(req: Request): Response = Response("", Vector(), Okay)

}
