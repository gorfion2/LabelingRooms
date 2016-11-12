package pl.labelingRooms.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Class that configured web url
 *
 * @author Kamil S
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");

        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");

        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");

        registry.addResourceHandler("/angular/**").addResourceLocations("classpath:/js/angular/");

        registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/js/bootstrap/");

    }
}
