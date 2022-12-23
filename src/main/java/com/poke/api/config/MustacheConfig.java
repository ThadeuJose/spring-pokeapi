package com.poke.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.TemplateLoader;

@Configuration
public class MustacheConfig {

    @Bean
    public Mustache.Compiler mustacheCompiler(TemplateLoader mustacheTemplateLoader) {
        return Mustache.compiler().defaultValue("").withLoader(mustacheTemplateLoader);
    }

}
