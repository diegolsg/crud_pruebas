package com.covinoc.crud.adapter.api.document;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
info=@Info(
        title = "Covinoc CRUD",
        version = "1.0.0",
        description = "Carrying out a knowledge test with a CRUD of a banking system to which an account number is" +
                " assigned with certain conditions."
))

public class ConfigureDoc {
}
