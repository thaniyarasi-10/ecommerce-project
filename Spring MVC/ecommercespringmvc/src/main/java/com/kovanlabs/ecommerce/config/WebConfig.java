package com.kovanlabs.ecommerce.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Enable MVC features,Scan controllers,Setup request mapping,Setup handler mappings,Setup message converters
@Configuration
@EnableWebMvc
@ComponentScan("com.kovanlabs.ecommerce")// scan all controller components
// Controllers belong to web layer, so they live in Servlet Context.
public class WebConfig {
}
