# httpz

A simple abstraction layer above http with the use of scalaz.

## Use Case

    GET "https://facebook.com/" <<? ("profile" -> "12345"), ("version" -> "9876")

## Useful Operators

* GET / POST / PUT / DELETE / HEAD -- Init the http request
* / -- Add paths onto the request
* : -- specify the port on the request
* *&* -- Add url paramaters
* *:* -- Add headers onto the request
* file -- Add that file as contents for a PUT

* \:/ -- Merge two requests on the union of their properties
* /:\ -- Merge two requests based on the intersection of their properties
