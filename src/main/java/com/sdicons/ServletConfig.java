package com.sdicons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// This class replaces a typical Spring configuration file.
// The @Bean methods each produce a <bean> instance, the name and type are derived from the method declaration.
//
// This context is directly attached to the DispatcherServlet in the web.xml

@Configuration
@EnableWebMvc
public class ServletConfig extends WebMvcConfigurerAdapter
{
    // We create a separate method so that its dependencies will be injected
    // by the Spring configuration system. If we would create it directly using new
    // the Spring system would not have the change to inject the dependencies.

    @Bean
    public RestService restService() {
        return new RestService();
    }

    // Content type detection.
    // Content-type can be specified in the headers, suffixes, extra query-parameter, ...

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(false).
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }
}
