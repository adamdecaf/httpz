package httpz

trait ApacheHttpImplementationRepository extends HttpImplementationRepository {
  def execute(req: Request): Response = {

  }
}

trait ApacheHttpImplementationComponent extends HttpImplementationComponent {
  lazy val httpRepository = new ApacheHttpImplementationComponent{}
}
