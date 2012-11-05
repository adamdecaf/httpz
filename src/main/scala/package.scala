/**
 * httpz package object
 */

import scalaz.Validation

package object httpz {

  // Common types
  type Headers = Iterable[Pair[String, String]]
  type UrlParams = Iterable[Pair[String, String]]

  // Default, config values
  val defaultHttpPort = 80
  def emptyHeaders: Iterable[Pair[String, String]] = List()

  // Validation
  type HttpValidation = Validation[String, String]
}
