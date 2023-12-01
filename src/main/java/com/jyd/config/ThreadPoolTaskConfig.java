package com.jyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolTaskConfig {

    private static final int corePoolSize = 8;       		// 核心线程数（默认线程数）
    private static final int maxPoolSize = 8;			    // 最大线程数
    private static final int keepAliveTime = 300;			// 允许线程空闲时间（单位：默认为秒）
    private static final int queueCapacity = 100000;			// 缓冲队列数
    private static final String threadNamePrefix = "Message-Async-"; // 线程池名前缀
    private static final String threadGroupName = "Message-Threads"; // 线程组名

    @Bean("messageTaskExecutor") // bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskExecutor getAsyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);
        ThreadGroup threadGroup = new ThreadGroup(threadGroupName);
        executor.setThreadGroup(threadGroup);
        executor.setThreadGroupName(threadGroupName);
        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}

