package httpz.tests

import org.specs2.mutable.Specification

object RequestsSpec extends Specification {
  import httpz._

  "Building Requests" should {
    "work as expcted" in {
      host("http://google.com") === new Request("http://google.com", 80, Vector())
      //host("") must beAnInstanceOf[Throwable]
    }

    "work to change properties on them." in {
      val uri = host("http://google.com/")
      uri.port_=(100) === uri.copy(port = 100)
      uri / ("test") === uri.copy(uri = "http://google.com/test")
      uri *&* Vector("a" -> "b") === uri.copy(uri = "http://google.com/?a=b")
      //uri *:* Vector("test" -> "testing") === uri
    }

    "work to merge requests" in pending
  }

}
