package net.tyrannosaurus.redis.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import java.lang.reflect.Method;

@Configuration
public class RedisKeyGenerator  {

    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();

                sb.append(target.getClass().getName());
                for (Object obj : params) {
                    // 由于参数可能不同, hashCode肯定不一样, 缓存的key也需要不一样
                    sb.append(JSON.toJSONString(obj).hashCode());
                }
                return sb.toString();
            }
        };
    }

}
