package org.search.jobportal.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Objects;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.jobsearch+json"), "v")
                .addSupportedVersions("1.0", "2.0", "3.0")
                .setDefaultVersion("1.0");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api", controllerType -> true);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .exposedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//
//    }
}
