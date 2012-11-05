package httpz

import scalaz.{Success, Failure, Validation}

case class Response(response: String, headers: Iterable[Pair[String, String]], httpStatus: HttpStatus) {
  def >>::[T](f: Iterable[Pair[String, String]] => T): T = f(headers)

  // Make these better later on
  def json_>[T](f: String => T) = f(response)
  def xml_>[T](f: String => T) = f(response)

  // Define a way to get the scalaz or HttpValidation object
  def asScalaz: Validation[String, String] = httpStatus match {
    case Okay => Success(response)
    case Failure(_, _) => Failure(response) // Maybe find a better set of error messages? (Headers?)
  }

  def wrapped: HttpValidation = {
    new HttpValidation(asScalaz(response))
  }
}
