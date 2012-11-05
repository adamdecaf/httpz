# httpz documentation

## What?

httpz is a library that attempts to abstract over HTTP, from failure to success, and tries to allow developers an ease of mind.

## How?

To make a usual HTTP GET you could do the following

```scala
val request = GET "http://weather-service.com" / "weather" *&* Map("city" -> "san fransisco", "type" -> "daily", "fmt" -> "json")
```

You can then handle the request like so.

```scala
request json_> {
  // Some function the handles json
}
```
