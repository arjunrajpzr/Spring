package com.arjun.springcore.config;

import com.arjun.springcore.pojo.Battery;
import com.arjun.springcore.pojo.Disc;
import com.arjun.springcore.pojo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfig {

    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 9);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 15);
        p2.setCapacity(700);
        return p2;
    }

}
