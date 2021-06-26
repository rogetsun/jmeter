package com.uv.jmeter.controller;

import com.uv.jmeter.Config;
import com.uv.jmeter.UVListener;
import com.uv.jmeter.service.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class DefaultController {

    @Resource
    private Calculator calculator;
    @Resource
    private Config config;

    @Resource
    private UVListener uvListener;

    private final Random random = new Random();

    @RequestMapping(value = "/jmeter", method = {RequestMethod.GET, RequestMethod.POST})
    public String jmeterTest(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        String host = request.getRemoteAddr();
        log.debug("error：id={}, name={}", id, name);
        log.debug("host:{},id={},name={}", host, id, name);
        try {
            if (random.nextInt(100) < config.getDelayPercent() && config.getSleepSeconds() > 0) {
                log.debug("sleep {}", config.getSleepSeconds());
                TimeUnit.SECONDS.sleep(config.getSleepSeconds());
            }
            if (config.isCalculate()) {
                calculator.add(id);
            }
        } catch (Exception e) {
            log.error("添加失败，" + id, e);
        }
        log.debug("/jmeter response over!");
        return "jmeter test";

    }

    @GetMapping("/count")
    public String getCount() {
        return "count:[" + calculator.getCount() + "]";
    }
}
