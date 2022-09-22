package academy.prog.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) { // чтобы зайти внуть каталога admin, что томкэт не умеет, нужно перенаправить запрос
        registry.addViewController("/admin")
                .setViewName("redirect:/admin/");
        registry.addViewController("/admin/")
                .setViewName("forward:/admin/index.html");
    }

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/")
                .addResourceLocations("/resources/");
    }*/
}
