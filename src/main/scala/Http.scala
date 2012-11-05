package httpz

object Http extends HttpImpl with ApacheHttpImplementationRepository {
  // def apply(uri: String): Response = this(Request(uri, 0, Nil))
  def apply(req: Request): Response = execute(req)
}

trait HttpImplementationRepository {
  def execute(req: Request): Response
}

trait HttpImplementationComponent {
  def httpRepository: HttpImplementationRepository
}
