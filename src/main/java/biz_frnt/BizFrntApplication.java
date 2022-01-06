package biz_frnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BizFrntApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizFrntApplication.class, args);
    }

}
