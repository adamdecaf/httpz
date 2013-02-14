package httpz

import org.specs2.specification.Scope
import org.specs2.mutable.Specification

object RequestsSpec extends Specification {

  "Building Requests" should {
    "work as expcted" in {
      host("http://google.com") === Request("http://google.com")
      host("") === Request("")
    }

    "get and set the port" in new context {
      defaultRequest.getPort === 80
      defaultRequest.setPort(100).getPort === 100
    }

    "work to set and get the path" in new context {
      req.getPath === "some/path"
      req.setPath("/a/b/").getPath === "a/b"
      req.setPath("a/b/").getPath === "a/b"
      req.setPath("a/b/").uri === "http://google.com/a/b/"
    }

    "work to add paths" in new context {
      defaultRequest / "" === defaultRequest.copy(uri = "http://google.com/")
      defaultRequest / "somePath" === defaultRequest.copy(uri = "http://google.com/somePath")
    }

    "work to set params" in new context {
      (req setParams Map("name" -> "httpz", "date" -> "0")) === req.copy(uri = "http://google.com/some/path/?name=httpz&date=0")
    }

    "work to add and get params" in new context {
      paramReq.getParams === "a=1&b=2"
      //(req addParams(Map("a" -> "1", "b" -> "1")) getParams) === "a=1&b=1"
    }

    "work to set headers" in new context {
      req.setHeaders(Map("a" -> "1")).getHeaders() === Map("a" -> "1")
    }

    "work to add and get headers" in new context {
      req.addHeaders(Map()) === req
      req.addHeaders(Map("a" -> "1")).addHeaders(Map("b" -> "2")).getHeaders === Map("a" -> "1", "b" -> "2")
    }

    "work to merge requests" in new context {
      val other = req.setHeaders(Map("a" -> "1")).setHeaders(Map("b" -> "2")).setPostValues(Map("c" -> "3"))
      req.mergeWith(other) === other
    }
  }

  trait context extends Scope {
    val defaultRequest = Request("http://google.com")
    val req = Request("http://google.com/some/path/")
    val paramReq = Request("http://google.com/some/path/?a=1&b=2")
  }
}
