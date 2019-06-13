package cu.certificados.cerme.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@ComponentScan(basePackages = { "cu.certificados.cerme.configuracion"})
public class ApplicationConfiguration
{

}