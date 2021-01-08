package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();/**定义为随机*/
        //return new RetryRule();/**按照轮训获取服务，服务失败会重新请求*/
        //return new WeightedResponseTimeRule();/**对轮询的扩展，响应速度越快越容易被选中*/
        //return new BestAvailableRule();/**会过滤掉由于多次访问故障而处于断路器跳闸状态的服务器，然后选中一个并发量最小的服务器*/
        //return new AvailabilityFilteringRule();/**先过滤掉故障实例，再选择并发较小的实例*/
        //return new ZoneAvoidanceRule(); /**默认规则，复合判断server所在区域的性能和server的可用性选择服务器*/
    }

}
