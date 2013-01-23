package httpz

object HttpStatus {
  def apply(status: String): HttpStatus = status match {
    case "200" => Okay()
    case "201" => Created()
    case "202" => Accepted()
    case "203" => PartialInformation()
    case "204" => NoResponse()
    case "301" => Moved()
    case "302" => Found()
    case "303" => Method()
    case "304" => NotModified()
    case "400" => BadRequest()
    case "401" => Unauthorized()
    case "402" => PaymentRequired()
    case "403" => Forbidden()
    case "404" => FileNotFound()
    case "500" => InternalError()
    case "501" => NotImplemented()
    case "502" => ServiceTemporarilyOverloaded()
    case "503" => GatewayTimeout()
    case _     => UnknownStatus()
  }
}

sealed trait HttpStatus {
  this: Any =>

  val asNumber: Int
  val asString: String
  override def toString() = "HttpStatus: %s%s".format(asString, asNumber)
}

case class Okay(val asNumber: Int = 200, val asString: String = "Okay") extends HttpStatus
case class Created(val asNumber: Int = 201, val asString: String = "Created") extends HttpStatus
case class Accepted(val asNumber: Int = 202, val asString: String = "Accepted") extends HttpStatus
case class PartialInformation(val asNumber: Int = 203, val asString: String = "Partial Information") extends HttpStatus
case class NoResponse(val asNumber: Int = 204, val asString: String = "No Response") extends HttpStatus
case class Moved(val asNumber: Int = 301, val asString: String = "Moved") extends HttpStatus
case class Found(val asNumber: Int = 302, val asString: String = "Found") extends HttpStatus
case class Method(val asNumber: Int = 303, val asString: String = "Method") extends HttpStatus
case class NotModified(val asNumber: Int = 304, val asString: String = "Not Modified") extends HttpStatus
case class BadRequest(val asNumber: Int = 400, val asString: String = "Bad Request") extends HttpStatus
case class Unauthorized(val asNumber: Int = 401, val asString: String = "Unauthorized") extends HttpStatus
case class PaymentRequired(val asNumber: Int = 402, val asString: String = "Payment Required") extends HttpStatus
case class Forbidden(val asNumber: Int = 403, val asString: String = "Forbidden") extends HttpStatus
case class FileNotFound(val asNumber: Int = 404, val asString: String = "File Not Found") extends HttpStatus
case class InternalError(val asNumber: Int = 500, val asString: String = "Internal Error") extends HttpStatus
case class NotImplemented(val asNumber: Int = 501, val asString: String = "Not Implemented") extends HttpStatus
case class ServiceTemporarilyOverloaded(val asNumber: Int = 502, val asString: String = "Service Temporarily Overloaded") extends HttpStatus
case class GatewayTimeout(val asNumber: Int = 503, val asString: String = "Gateway Timeout") extends HttpStatus
case class UnknownStatus(val asNumber: Int = 0, val asString: String = "Unknown Status") extends HttpStatus
