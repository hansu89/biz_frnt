package biz_frnt.frnt.controller;

import biz_frnt.client.BizFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class FeignController {

    @Autowired
    BizFeignClient bizFeignClient;

    private final Logger logger = LoggerFactory.getLogger(FeignController.class);

    @RequestMapping("/init")
    public String open() {
        logger.debug("로그를 찍자 !!!!!!!!!!!!!!!!!");
        return "frnt/hello";
    }

    @RequestMapping("/feignEx")
    @ResponseBody
    public Map<String, Object> feignEx() {
        return bizFeignClient.getToken();
    }
}
