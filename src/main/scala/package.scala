/**
 * httpz package object
 */
import scala.language.implicitConversions

package object httpz {

  //  Bring up the *Ops Value classes.
  implicit def ImplicitRequestOpsWrapper(req: Request) = new RequestOpsWrapper(req)

}
