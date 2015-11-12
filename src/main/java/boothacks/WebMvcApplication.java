package boothacks;

import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
public class WebMvcApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebMvcApplication.class, args);
    }


    @Configuration
    public class WebConfig extends WebMvcConfigurerAdapter {

        @Autowired
        private ThymeleafViewResolver thymeleafResolver;


        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("home");
        }

        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            registry.viewResolver(this.thymeleafResolver);
            registry.enableContentNegotiation(new MappingJackson2JsonView());
        }

    }
}
