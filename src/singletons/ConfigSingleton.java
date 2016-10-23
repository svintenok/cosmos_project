package singletons;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import javax.servlet.ServletContext;
import java.util.Locale;

public class ConfigSingleton {
    private static Configuration cfg = null;
    public static Configuration getConfig(ServletContext sc) {
        if (cfg == null){
            cfg = new Configuration();
            cfg.setDefaultEncoding("utf-8");
            cfg.setServletContextForTemplateLoading(
                    sc,
                    "/WEB-INF/templates"
            );
            cfg.setTemplateExceptionHandler(
                    TemplateExceptionHandler.HTML_DEBUG_HANDLER
            );
        }
        return cfg;
    }
}
