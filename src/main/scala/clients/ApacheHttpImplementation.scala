package httpz

trait ApacheHttpImplementationRepository extends HttpImplementationRepository {
  def execute(req: Request): Response = {
    Response.empty
  }
}

trait ApacheHttpImplementationComponent extends HttpImplementationComponent {
  lazy val httpRepository = new ApacheHttpImplementationRepository{}
}
