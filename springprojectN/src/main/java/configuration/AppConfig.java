package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"configuration", "controller", "daoReposit", "service"})
public class AppConfig {
}
