package br.com.ibfc.geracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;


@Configuration
public class ThymeleafConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/templates/");
		templateResolver.setSuffix(".html");
	//	templateResolver.setTemplateMode("html");
		// Template cache is true by default. Set to false if you want
		// templates to be automatically updated when modified.
		templateResolver.setCacheable(true);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		// templateEngine.setEnableSpringELCompiler(true); // Compiled SpringEL
		// should speed up executions
		
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setContentType("text/html;encoding=utf-8");
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setViewNames(new String[] { "*th" });
		viewResolver.setOrder(Integer.valueOf(1));
		return viewResolver;
	}

	/* **************************************************************** */
	/* JSP-SPECIFIC ARTIFACTS */
	/* **************************************************************** */

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewNames(new String[] { "*jsp" });
		viewResolver.setOrder(Integer.valueOf(2));
		return viewResolver;
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
