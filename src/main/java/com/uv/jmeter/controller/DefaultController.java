package com.uv.jmeter.controller;

import com.uv.jmeter.Config;
import com.uv.jmeter.UVListener;
import com.uv.jmeter.service.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class DefaultController {

    @Resource
    private Calculator calculator;
    @Resource
    private Config config;

    @Resource
    private UVListener uvListener;

    @RequestMapping(value = "/jmeter", method = {RequestMethod.GET, RequestMethod.POST})
    public String jmeterTest(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        String host = request.getRemoteAddr();
        log.error("error：id={}, name={}", id, name);
        log.info("host:{},id={},name={}", host, id, name);
        log.debug("debug：id={}, name={}", id, name);
        log.trace("trace：id={}, name={}", id, name);
        try {
            if (config.isCalculate()) {
                calculator.add(id);
            }
        } catch (Exception e) {
            log.error("添加失败，" + id, e);
        }
        return "jmeter test";

    }

    @GetMapping("/count")
    public String getCount() {
        return "count:[" + calculator.getCount() + "]";
    }
}
