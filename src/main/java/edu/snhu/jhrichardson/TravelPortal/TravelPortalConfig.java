/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import edu.snhu.jhrichardson.TravelPortal.interceptors.LoggerInterceptor;

/**
 * @author john.richardson3
 *
 */
@Configuration
public class TravelPortalConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;
	
		
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**")
				.addResourceLocations("/WEB-INF/files/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(loggerInterceptor());
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
	
	@Bean 
	LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
		
	}
	
	@Bean
	LoggerInterceptor loggerInterceptor() {
		LoggerInterceptor li = new LoggerInterceptor();
		return li;
	}
	
//	/**
//	 * An Internal Resource View Resolver
//	 * @return @see ViewResolver
//	 */
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
//		ivr.setPrefix("/WEB-INF/jsp/");
//		ivr.setSuffix(".jsp");
//		ivr.setOrder(1);
//		return ivr;
//	}
//	
	@Bean
	public ViewResolver thymeleafResolver() {
		ThymeleafViewResolver tvr = new ThymeleafViewResolver();
		tvr.setTemplateEngine(templateEngine());
		tvr.setOrder(0);
		return tvr;
	}
	
	@Bean
	SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(applicationContext);
		tr.setPrefix("/WEB-INF/views/");
		tr.setSuffix(".html");
		return tr;
	}
	
	@Bean
	SpringTemplateEngine templateEngine() {
		SpringTemplateEngine te = new SpringTemplateEngine();
		te.setTemplateResolver(templateResolver());
		te.setEnableSpringELCompiler(true);
		return te;
	}
}
