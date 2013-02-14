/**
 * httpz package object
 */

package object httpz {

  //  Bring up the *Ops Value classes.
  implicit def ImplicitRequestOpsWrapper(req: Request) = new RequestOpsWrapper(req)

}
