package httpz

import scalaz.{Success => success, Failure => failure, Validation}

case class Response(response: String, headers: Headers, httpStatus: HttpStatus) {

  // Operate on the headers
  def >>::[T](f: Headers => T): T = f(headers)

  // Make these better later on
  def json_>[T](f: String => T) = f(response)
  def xml_>[T](f: String => T) = f(response)

  // Define a way to get the scalaz or HttpValidation object
  def asScalaz: Validation[String, String] = httpStatus match {
    case Okay => success(response)
    case Failure(_, _) => failure(response) // Maybe find a better set of error messages? (Headers?)
  }

  def wrapped: HttpValidation = {
    new HttpValidation(asScalaz(response))
  }
}
