package cn.yayatao.cloud.member.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("cn.yayatao.cloud.member.api")
public class ClientAutoConfiguration {
}
