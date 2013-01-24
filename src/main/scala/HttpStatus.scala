package httpz

object HttpStatus {
  def apply(status: String): HttpStatus = status match {
    case "200" => Okay()
    case "201" => Created()
    case "202" => Accepted()
    case "203" => PartialInformation()
    case "204" => NoResponse()
    case "205" => ResetContent()
    case "206" => PartialContent()
    case "230" => AuthenticationSuccessful()

    case "301" => Moved()
    case "302" => Found()
    case "303" => Method()
    case "304" => NotModified()
    case "305" => UseProxy()
    case "307" => TemporaryRedirect()
    case "308" => PermanentRedirect()

    case "400" => BadRequest()
    case "401" => Unauthorized()
    case "402" => PaymentRequired()
    case "403" => Forbidden()
    case "404" => FileNotFound()
    case "405" => MethodNotAllowed()
    case "406" => NotAcceptable()
    case "407" => ProxyAuthenticationRequired()
    case "408" => RequestTimeout()
    case "409" => Conflict()
    case "410" => Gone()
    case "411" => LengthRequired()
    case "412" => PreconditionFailed()
    case "413" => RequestEntityTooLarge()
    case "414" => RequestURITooLong()
    case "415" => UnsupportedMediaType()
    case "416" => RequestedRangeNotSatisfiable()
    case "417" => ExpectationFailed()
    case "422" => UnprocessableEntity()
    case "428" => PreconditionRequired()
    case "429" => TooManyRequests()
    case "431" => RequestHeaderFieldsTooLarge()
    case "451" => UnavailableForLegalReasons()

    case "500" => InternalError()
    case "501" => NotImplemented()
    case "502" => ServiceTemporarilyOverloaded()
    case "503" => ServiceUnavailable()
    case "504" => GatewayTimeout()
    case "505" => HttpVersionNotSupported()
    case "507" => InsufficientStorage()
    case "509" => BandwidthLimitExceeded()

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
case class ResetContent(val asNumber: Int = 205, val asString: String = "Reset Content") extends HttpStatus
case class PartialContent(val asNumber: Int = 206, val asString: String = "Partial Content") extends HttpStatus
case class AuthenticationSuccessful(val asNumber: Int = 230, val asString: String = "Authentication Successful") extends HttpStatus

case class Moved(val asNumber: Int = 301, val asString: String = "Moved") extends HttpStatus
case class Found(val asNumber: Int = 302, val asString: String = "Found") extends HttpStatus
case class Method(val asNumber: Int = 303, val asString: String = "Method") extends HttpStatus
case class NotModified(val asNumber: Int = 304, val asString: String = "Not Modified") extends HttpStatus
case class UseProxy(val asNumber: Int = 305, val asString: String = "Use Proxy") extends HttpStatus
case class TemporaryRedirect(val asNumber: Int = 307, val asString: String = "Temporary Redirect") extends HttpStatus
case class PermanentRedirect(val asNumber: Int = 308, val asString: String = "Permanent Redirect") extends HttpStatus

case class BadRequest(val asNumber: Int = 400, val asString: String = "Bad Request") extends HttpStatus
case class Unauthorized(val asNumber: Int = 401, val asString: String = "Unauthorized") extends HttpStatus
case class PaymentRequired(val asNumber: Int = 402, val asString: String = "Payment Required") extends HttpStatus
case class Forbidden(val asNumber: Int = 403, val asString: String = "Forbidden") extends HttpStatus
case class FileNotFound(val asNumber: Int = 404, val asString: String = "File Not Found") extends HttpStatus
case class MethodNotAllowed(val asNumber: Int = 405, val asString: String = "Method Not Allowed") extends HttpStatus
case class NotAcceptable(val asNumber: Int = 406, val asString: String = "Not Acceptable") extends HttpStatus
case class ProxyAuthenticationRequired(val asNumber: Int = 407, val asString: String = "Proxy Authentication Required") extends HttpStatus
case class RequestTimeout(val asNumber: Int = 408, val asString: String = "Request Timeout") extends HttpStatus
case class Conflict(val asNumber: Int = 409, val asString: String = "Conflict") extends HttpStatus
case class Gone(val asNumber: Int = 410, val asString: String = "Gone") extends HttpStatus
case class LengthRequired(val asNumber: Int = 411, val asString: String = "Length Required") extends HttpStatus
case class PreconditionFailed(val asNumber: Int = 412, val asString: String = "Precondition Failed") extends HttpStatus
case class RequestEntityTooLarge(val asNumber: Int = 413, val asString: String = "Request Entity Too Large") extends HttpStatus
case class RequestURITooLong(val asNumber: Int = 414, val asString: String = "Request-URI Too Long") extends HttpStatus
case class UnsupportedMediaType(val asNumber: Int = 415, val asString: String = "Unsupported Media Type") extends HttpStatus
case class RequestedRangeNotSatisfiable(val asNumber: Int = 416, val asString: String = "Requested Range Not Satisfiable") extends HttpStatus
case class ExpectationFailed(val asNumber: Int = 417, val asString: String = "Expectation Failed") extends HttpStatus
case class UnprocessableEntity(val asNumber: Int = 422, val asString: String = "Unprocessable Entity") extends HttpStatus
case class PreconditionRequired(val asNumber: Int = 428, val asString: String = "Precondition Required") extends HttpStatus
case class TooManyRequests(val asNumber: Int = 429, val asString: String = "Too Many Requests") extends HttpStatus
case class RequestHeaderFieldsTooLarge(val asNumber: Int = 431, val asString: String = "Request Header Fields Too Large") extends HttpStatus
case class UnavailableForLegalReasons(val asNumber: Int = 451, val asString: String = "Unavailable For Legal Reasons") extends HttpStatus

case class InternalError(val asNumber: Int = 500, val asString: String = "Internal Error") extends HttpStatus
case class NotImplemented(val asNumber: Int = 501, val asString: String = "Not Implemented") extends HttpStatus
case class ServiceTemporarilyOverloaded(val asNumber: Int = 502, val asString: String = "Service Temporarily Overloaded") extends HttpStatus
case class ServiceUnavailable(val asNumber: Int = 503, val asString: String = "Service Unavailable") extends HttpStatus
case class GatewayTimeout(val asNumber: Int = 504, val asString: String = "Gateway Timeout") extends HttpStatus
case class HttpVersionNotSupported(val asNumber: Int = 505, val asString: String = "HTTP Version Not Supported") extends HttpStatus
case class InsufficientStorage(val asNumber: Int = 507, val asString: String = "Insufficient Storage") extends HttpStatus
case class BandwidthLimitExceeded(val asNumber: Int = 509, val asString: String = "BandwidthLimit Exceeded") extends HttpStatus

case class UnknownStatus(val asNumber: Int = 0, val asString: String = "Unknown Status") extends HttpStatus
