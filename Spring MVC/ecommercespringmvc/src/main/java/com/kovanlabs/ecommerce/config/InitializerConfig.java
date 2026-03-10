package com.kovanlabs.ecommerce.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitializerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {//to initialize root context, initialize dao, service, db beans
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
        //return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // DispatcherServlet handles all the request
        //return new String[]{"/user"}; handles only user request
    }

}
