package cn.yayatao.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YayataoGatewayLauncher {
    public static void main(String[] args) {
        SpringApplication.run(YayataoGatewayLauncher.class);
    }
}
