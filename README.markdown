# Spring REST
## Description

The goal of this template is to have a basic Spring REST server, ready to be run in Tomcat.
The Spring configuration is based on annotations, no XML context files!
Only REST, no SOAP. Spring does not follow the JAXRS standard, it uses its own MVC annotations.

Spring MVC uses Jackson for JSON rendering.
Content negotiation ContentNegotiationConfigurer can be configured in the ServletConfig, you can configure how
Spring detects the required content-type.

## Features

* Standard Java web application.
* REST methods, content negotiation for XML and JSON.
* Spring configuration (annotation based).

## Notes
* At least Java 1.6 needed for the Spring annotations.
* In Spring +3.1 @ComponentScan becomes available, so you do not need to create the beans explicitly.
* You should run it as a Tomcat application. It was tested with Tomcat 6 and 7.

## Links

+ Startup information: ["http://localhost:8080"](http://localhost:8080)
+ JSON ["http://localhost:8080/hello?mediaType=json"](http://localhost:8080/hello?mediaType=json)
+ XML ["http://localhost:8080/hello?mediaType=xml"](http://localhost:8080/hello?mediaType=xml)

## Files

* **/README.txt**: This file.
* **/pom.xml**: The Maven configuration file.
   1. Spring core + web.
   1. Jackson for JSON rendering.
* **/src/main/java/com/sdicons/ApplicationConfig.java**: The Spring configuration class replacing the XML configuration.
It is empty, but beans defined here are accessible in all other contexts.
* **/src/main/java/com/sdicons/ServletConfig**: The spring configuration for a specific servlet,
the DispathcerServlet in this case.
* **/src/main/java/com/sdicons/RestService.java**: A plain JAX-RS 'hello' service.
* **/src/main/java/com/sdicons/Message.java**: A model object that can be rendered to JSON and XML.
* **/src/main/webapp/WEB-INF/web.xml**: Standard Java web application.
   1. Dispatcher Servlet configuration and a link to the ServletConfig.
   1. Spring context setup to pick up our ApplicationConfig class to initialize the context.

## Conclusion

Since Spring is a box full of Lego blocks, it is sometimes difficult to understand how the different parts work
together to accomplish the result. In the current setup much magic happens because of the @EnableWebMvc
annotation and it is difficult to get a clear picture on what is happening.

The ContentNegotiationConfigurer is really nice, you can configure how the user can request the media format (JSON, XML, ...)
in various ways. You can use HTTP headers, parameters, ... it is a nice feature.