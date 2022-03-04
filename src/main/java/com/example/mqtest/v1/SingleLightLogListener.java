package com.example.mqtest.v1;

import com.coeuy.osp.rmq.adepts.common.InitListener;
import com.coeuy.osp.rmq.adepts.common.MessageResult;
import com.coeuy.osp.rmq.adepts.consumer.MessageProcess;
import com.coeuy.osp.rmq.adepts.producer.SimpleSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * v1 版本手动声明 单线程 init 例子
 * @author yarnk
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SingleLightLogListener implements MessageProcess<String> {

    private final InitListener initListener;

    @PostConstruct
    private void init(){
        // 初始化消费监听 队列名为《light》 默认 1 条线程处理
        initListener.init("light-single",this);
    }

    /**
     * 消息在这里处理
     * @param message
     * @return
     */
    @Override
    public MessageResult process(String message) {
        log.info("处理设备日志:{}", message);
        return MessageResult.success();
    }

}
