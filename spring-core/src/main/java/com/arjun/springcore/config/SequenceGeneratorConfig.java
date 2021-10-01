package com.arjun.springcore.config;

import com.arjun.springcore.pojo.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring bean instantiations done by hard-coding the values in a Java config class.
 */
@Configuration
public class SequenceGeneratorConfig {

    // generates a bean name based on the method name.
    // Alternatively, you can explicitly specify the bean name in the @Bean annotation with the name attribute.
    // For example, @Bean(name="mys1"). If you explicitly specify the bean name,
    // the method name is ignored for the purposes of bean creation.
    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator seqGen = new SequenceGenerator();
        seqGen.setPrefix("30");
        seqGen.setSuffix("A");
        seqGen.setInitial(10000);
        return seqGen;
    }
}
