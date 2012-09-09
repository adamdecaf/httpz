/**
 * httpz package object
 */

import scalaz.{@@, Tag}

package object httpz {

  // TODO: Make these be nonEmpty also
  type Headers = Iterable[Pair[String, String]]
  type UrlParams = Iterable[Pair[String, String]]

  sealed trait NonEmpty
  type NonEmptyString = String @@ NonEmpty

  // TODO:
  implicit def stringToNonEmptyString(s: String): NonEmptyString = {
    if (s.length > 0) Tag[String, NonEmpty](s)
    else throw EmptyStringException
  }
}
