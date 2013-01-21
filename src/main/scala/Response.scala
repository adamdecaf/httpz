package httpz

import scalaz.{Success, Failure, Validation}

private[httpz] object Response {
  def empty = Response("", List.empty, Okay)
}

case class Response(response: String, headers: Headers, httpStatus: HttpStatus) {

  // Operate on the headers
  def >>::[T](f: Headers => T): T = f(headers)

  // Make these better later on
  def json_>[T](f: String => T) = f(response)
  def xml_>[T](f: String => T) = f(response)

  // Define a way to get the scalaz or HttpValidation object
  def asScalaz: Validation[String, String] = httpStatus match {
    case Okay => Success(response)
    case _    => Failure(response)
  }

  // Use our non-scalaz wrapper around validation.
  def wrapped: HttpValidation = {
    new HttpValidation(asScalaz(response)){}
  }
}
