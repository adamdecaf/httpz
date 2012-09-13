package httpz

case class Response(response: String, headers: Iterable[Pair[String, String]], httpStatus: HttpStatus) {

  def >>::[T](f: Iterable[Pair[String, String]] => T): T = f(headers)

  // Make these better later on
  def json_>[T](f: String => T) = f(response)
  def xml_>[T](f: String => T) = f(response)

  // These should only evaluate when the request is completed
  //def flatMap
  //def map

  // def onComplete
  // def onSuccess
  // def onFailure

}
