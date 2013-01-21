package httpz

object GET extends HttpVerbHandler {
  def apply(req: Request)(implicit httpRepository: HttpImplementationComponent): Response =
    httpRepository.executeGet(req)
}

object POST extends HttpVerbHandler {
  def apply(req: Request)(implicit httpRepository: HttpImplementationComponent): Response =
    httpRepository.executePost(req)
}

object PUT extends HttpVerbHandler {
  def apply(req: Request)(implicit httpRepository: HttpImplementationComponent): Response =
    httpRepository.executePut(req)
}

object DELETE extends HttpVerbHandler {
  def apply(req: Request)(implicit httpRepository: HttpImplementationComponent): Response =
    httpRepository.executeDelete(req)
}

object HEAD extends HttpVerbHandler {
  def apply(req: Request)(implicit httpRepository: HttpImplementationComponent): Response =
    httpRepository.executeHead(req)
}

trait HttpVerbHandler {
  this: HttpImplementationComponent =>

  def apply(req: Request)(implicit httpRepository: HttpImplementationComponent): Response
}
