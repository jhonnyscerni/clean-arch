package br.com.architectureprototype.infrastructure.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.com.architectureprototype")
@EnableFeignClients(basePackages = "br.com.architectureprototype.infrastructure.service.client")
public class WebServerConfig {
}