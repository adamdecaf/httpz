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

sealed trait HttpStatus
case object Okay extends HttpStatus { override def toString() = "HttpStatus: Okay 200" }

// Use Tagged types to declare status codes??
// case object 200 extends HttpStatus { override def toString() = "Okay" }
// case object 201 extends HttpStatus { override def toString() = "Created" }
// case object 202 extends HttpStatus { override def toString() = "Accepted" }
// case object 203 extends HttpStatus { override def toString() = "Partial Information" }
// case object 204 extends HttpStatus { override def toString() = "No Response" }
// case object 301 extends HttpStatus { override def toString() = "Moved" }
// case object 302 extends HttpStatus { override def toString() = "Found" }
// case object 303 extends HttpStatus { override def toString() = "Method" }
// case object 304 extends HttpStatus { override def toString() = "Not Modified" }
// case object 400 extends HttpStatus { override def toString() = "Bad Request" }
// case object 401 extends HttpStatus { override def toString() = "Unauthorized" }
// case object 402 extends HttpStatus { override def toString() = "Payment Required" }
// case object 403 extends HttpStatus { override def toString() = "Forbidden" }
// case object 404 extends HttpStatus { override def toString() = "File Not Fount" }
// case object 500 extends HttpStatus { override def toString() = "Internal Error" }
// case object 501 extends HttpStatus { override def toString() = "Not Implemented" }
// case object 502 extends HttpStatus { override def toString() = "Service Temporarily Overloaded" }
// case object 503 extends HttpStatus { override def toString() = "Gateway Timeout" }
