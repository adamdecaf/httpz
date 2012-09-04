# httpz

A simple abstraction layer above http with the use of scalaz.

## Use Case

    GET "https://facebook.com/" <<? ("profile" -> "12345"), ("version" -> "9876")

## Useful Operators

    Request Methods
    GET / POST / PUT / DELETE / HEAD -- Init the http request
    / -- Add paths onto the request
    :: -- specify the port on the request
    *&* or <<?& -- Add url paramaters
    *:* or <<:: -- Add headers onto the request
    file -- Add that file as contents for a PUT
    \:/ -- Merge two requests on the union of their properties
    /:\ -- Merge two requests based on the intersection of their properties

    Response Methods
    >>:: -- Process headers
    json_> -- Process the response as json
    xml_> -- Process the response as xml


## Features

* Completely non-blocking
* Wrapped around futures and async code
* Http library independent
* JSON library independent
* XML library independent

## Future

* Handle response headers
* Provide a layer to handle exceptions during the request
* Treat the response as a json object
* Treat the response as a xml object
* Get certain properties directly from the request and response
