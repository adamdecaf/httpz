package httpz

import scalaz.{Success, Failure}

class HttpValidation(private val result: HttpValidation) {
  def andThen[T](f: String => T): T = result.fold(f(_), f(_))

  def onFailure[T](f: ): T
  def onSuccess[T](f: ): T
  def onComplete[T](f: ): T

  def toOption[T]: Option[T] = result match {
    case Failure(_) => None
    case Success(a) => Some(a)
  }

}
