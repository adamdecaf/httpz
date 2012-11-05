/**
 * httpz package object
 */

import scalaz.{@@, Tag, Validation}

package object httpz {

  // TODO: Make these be nonEmpty also
  type Headers = Iterable[Pair[String, String]]
  type UrlParams = Iterable[Pair[String, String]]

  sealed trait NonEmpty
  type NonEmptyString = String @@ NonEmpty

  type HttpValidation = Validation[String, String]

  // TODO:
  implicit def stringToNonEmptyString(s: String): NonEmptyString = {
    if (s.length > 0) Tag[String, NonEmpty](s)
    else throw EmptyStringException
  }
}
