package pe.edu.upc.wayrugrupo5.Configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                        title = "Wary-u API",
                        version = "1.0",
                         description = "API REST del sistema de reporte ciudadano de incidencias Wary-u."
                        ),
                        security = @SecurityRequirement(name = "bearerAuth")
                )
        @SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "Pega aquí el token JWT obtenido en /login (sin la palabra 'Bearer', Swagger la agrega sola)."
        )
public class OpenApiConfig {

}