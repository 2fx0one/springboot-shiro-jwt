package com.tfx0one.common.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//@Controller
public class AppErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(AppErrorController.class);

    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        return new ModelAndView("error", getErrorAttributes(request, false));
    }


    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
//        Map<String, Object> map = this.errorAttributes.getErrorAttributes(requestAttributes,includeStackTrace);
//        String URL = request.getRequestURL().toString();
//        map.put("URL", URL);
//        logger.debug("AppErrorController.method [error info]: status-" + map.get("status") +", request url-" + URL);
//        return map;
        return null;
    }
}
