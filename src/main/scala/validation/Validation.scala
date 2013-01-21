package httpz

import scalaz.{Success, Failure, Validation}

// Generic validation objects

class HttpzValidation[T] {

  //def isSuccess =

}

// object HttpValidation {
//   def apply(result: Validation[String, String]): HttpValidation =
//     new HttpValidation(result)
// }

// class HttpValidation private (private val result: Validation[String, String]) {
//   def andThen[T](f: String => T): T = result.fold(f(_), f(_))

//   def fold[X](fail: Response => X, success: Response => X): X = result match {
//     case Failure(_) => fail(result)
//     case Success(_) => success(result)
//   }

//   def toOption: Option[String] = result match {
//     case Failure(_) => None
//     case Success(document) => Some(document)
//   }

// }
