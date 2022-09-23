package com.ideas2it.employeedetails.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SpecificUrlFilter implements Filter {

    Logger LOGGER = LoggerFactory.getLogger(EmployeeFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Specific url");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

