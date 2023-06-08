package com.yujung.cloudconfigclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
//@RefreshScope
@ConfigurationProperties("com.yujung.client")
public class MyConfig {

    private String profile;
    private String region;
}
