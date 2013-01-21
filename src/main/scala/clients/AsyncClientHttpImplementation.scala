package httpz

trait AsyncClientHttpImplementationRepository extends HttpImplementationRepository {
  def execute(req: Request): Response = {
    Response.empty
  }
}

trait AsyncClientHttpImplementationComponent extends HttpImplementationComponent {
  lazy val httpRepository = new AsyncClientHttpImplementationRepository{}
}
