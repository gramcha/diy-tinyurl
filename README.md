# diy-tinyurl

Simple implementation of tiny url system. This is developed as springboot web application and integrated with redis cache.

## What is tiny url?
Basically, tiny url is a URL shortening service, a web service that provides short aliases for redirection of long URLs. There are many other similar services like Google URL Shortener, Bitly etc..

For example, URL **https://github.com/gramcha/diy-tinyurl/blob/master/src/main/java/com/gramcha/service/UrlService.java** is long and hard to remember, tiny url can create a alias for it – **https://goo.gl/tTRe1X**. If you click the alias, it’ll redirect you to the original URL.

## Solution
Service will maintain the key value pair of tiny and long url. It will redirect to long url whenever tiny url hitted. The tiny url key will be generated based on random logic with 7 char length.

It is a spring boot based web service. System exposes an endpoint to generate tiny ul for given long url. System will have the logic for generating the key which will be used to as tiny url. Same will be stored in redis cache with long url.

Redis cache configuration are added into application.properties file.

**application.properties file**

    server.port = 8080
    spring.cache.type=redis
    spring.redis.host=127.0.0.1
    spring.redis.port=6379
    #unlimted seconds 0
    spring.redis.cache.expiration=0

# Endpoints

1.**shorten**

It will accept the long url as input and generates the tiny url. 

### For example: 

POST "https://github.com/gramcha/diy-tinyurl/blob/master/src/main/java/com/gramcha/service/UrlService.java" as raw text to this endpoint. Endpoint will return below result in response.

    {
    "tinyUrl": "http://localhost:8080/tN72u2j",
    "longUrl": "https://github.com/gramcha/diy-tinyurl/blob/master/src/main/java/com/gramcha/service/UrlService.java",
    "key": "tN72u2j"
    }

2.**/{tinyurlkey}**

This endpoint is getting hitted when tiny url used. Service extracts key from the url and finds the match in redis cache to redirect to long url.
