package httpz

trait AsyncClientHttpImplementationRepository extends HttpImplementationRepository {
  def execute(req: Request): Response = {

  }
}

trait AsyncClientHttpImplementationComponent extends HttpImplementationComponent {
  lazy val httpRepository = new AsyncClientHttpImplementationComponent{}
}
