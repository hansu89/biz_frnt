package biz_frnt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "BizApiClient", url = "localhost:8080/")
public interface BizFeignClient {

    @GetMapping("/createToken")
    public Map<String, Object> getToken();
}
