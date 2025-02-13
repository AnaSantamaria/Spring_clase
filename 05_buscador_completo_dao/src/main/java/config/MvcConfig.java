package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

public class MvcConfig implements WebMvcConfigurer  {

	
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
	 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	 templateResolver.setApplicationContext(this.applicationContext);
	 templateResolver.setPrefix("/");
	 templateResolver.setSuffix(".html");
	 // HTML es la plantilla por defecto, se indica por claridad.
	 templateResolver.setTemplateMode(TemplateMode.HTML);
	 return templateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine(){ 
	 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 templateEngine.setTemplateResolver(templateResolver());
	 templateEngine.setEnableSpringELCompiler(true);
	 return templateEngine;
	}
	@Bean
	public ThymeleafViewResolver viewResolver(){
	 ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	 viewResolver.setTemplateEngine(templateEngine());
	 return viewResolver;
	} 

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/toAltaResultados").setViewName("alta");
		registry.addViewController("/").setViewName("inicio");
		registry.addViewController("/toEliminar").setViewName("eliminar");
		registry.addViewController("/toBuscarPoPrecioMax").setViewName("buscar");
		WebMvcConfigurer.super.addViewControllers(registry);
	}
}