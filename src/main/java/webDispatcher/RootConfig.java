package webDispatcher;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ImportResource({"/WEB-INF/context.xml", "/WEB-INF/security.xml"})
public class RootConfig {

}
