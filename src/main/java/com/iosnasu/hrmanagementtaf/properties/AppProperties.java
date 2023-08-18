package com.iosnasu.hrmanagementtaf.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private String baseUrl;

    private String dbDriverName;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
}
