package com.uv.jmeter;

import com.uv.jmeter.service.Calculator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class UVListener implements ServletContextListener {

    @Resource
    private Calculator calculator;

    private ExecutorService service;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        service = Executors.newSingleThreadExecutor();
        service.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                String id;
                while (true) {
                    id = calculator.get();
                }
            }
        });
        log.debug("UVListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        service.shutdown();
        log.debug("UVListener contextDestroyed");
    }

}
