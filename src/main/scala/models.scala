package httpz

case class Request(
  uri: String,
  params: Option[Traversable[Pair[String, String]]] = None,
  headers: Option[Traversable[Pair[String, String]]] = None,
  postValues: Option[Traversable[Pair[String, String]]] = None,
  port: Int = 80
)

case class Response(
  response: String,
  headers: Traversable[Pair[String, String]],
  httpStatus: HttpStatus
)
