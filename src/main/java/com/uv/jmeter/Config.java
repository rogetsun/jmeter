package com.uv.jmeter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "uv", ignoreInvalidFields = true)
public class Config {

    /**
     * 是否计算请求数
     */
    private boolean isCalculate;
    /**
     * 延迟时长
     */
    private long sleepSeconds;
    /**
     * 触发延迟概率 %
     */
    private int delayPercent;

    public int getDelayPercent() {
        return delayPercent;
    }

    public void setDelayPercent(int delayPercent) {
        this.delayPercent = delayPercent;
    }

    public long getSleepSeconds() {
        return sleepSeconds;
    }

    public void setSleepSeconds(long sleepSeconds) {
        this.sleepSeconds = sleepSeconds;
    }

    public boolean isCalculate() {
        return isCalculate;
    }

    public void setCalculate(boolean calculate) {
        isCalculate = calculate;
    }
}
