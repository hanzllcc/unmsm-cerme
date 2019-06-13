package cu.certificados.cerme.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "cu.certificados.cerme.service.impl", "cu.certificados.cerme.mapper" })
public class ServiceConfiguration
{

}