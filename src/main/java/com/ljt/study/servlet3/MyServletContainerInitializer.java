package com.ljt.study.servlet3;

import org.springframework.web.SpringServletContainerInitializer;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author LiJingTang
 * @date 2021-07-18 12:03
 * @see SpringServletContainerInitializer
 */
@HandlesTypes(HandleService.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext ctx) {
        System.out.println("MyServletContainerInitializer: onStartup");
        set.forEach(c -> System.out.println(c.getName()));
        ServletRegistration.Dynamic servlet = ctx.addServlet("myServlet", MyServlet.class);
        servlet.addMapping("/servlet3");
        FilterRegistration.Dynamic filter = ctx.addFilter("myFilter", MyFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        ctx.addListener(MyListener.class);
    }

}

interface HandleService {
}


class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 7564435024696392016L;

}

class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

}

class MyListener implements ServletContextListener {

}
