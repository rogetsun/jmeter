package com.uv.jmeter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

@Component
@Slf4j
public class Calculator {
    private TransferQueue<String> queue = new LinkedTransferQueue<>();
    private long count;

    public void add(String id) throws InterruptedException {
        this.queue.put(id);
    }

    public String get() throws InterruptedException {
        String id = this.queue.take();
        count++;
        log.debug("get id: " + id + ", count:" + this.count);
        return id;
    }

    public long getCount() {
        return count;
    }

}
