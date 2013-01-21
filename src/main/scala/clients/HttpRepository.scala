package httpz

trait HttpImplementationRepository {
  def executeGet(req: Request): Response
  def executePost(req: Request): Response
  def executePut(req: Request): Response
  def executeDelete(req: Request): Response
  def executeHead(req: Request): Response
}

trait HttpImplementationComponent {
  def httpRepository: HttpImplementationRepository
}
