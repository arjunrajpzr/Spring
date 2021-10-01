//This class violates Single Resposibility Principle. Not recommended for Production.
// This is for demonstration and revision purpose.
package com.arjun.springcore;

import com.arjun.springcore.config.SequenceGeneratorConfig;
import com.arjun.springcore.config.ShopConfig;
import com.arjun.springcore.dao.SequenceDao;
import com.arjun.springcore.pojo.Product;
import com.arjun.springcore.pojo.SequenceGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication

/**@ComponentScan example. This is used for demonstration. @SpringBootApplication comes with
 * By default, Spring detects all classes decorated with @Configuration,
 * @Bean, @Component, @Repository, @Service, and @Controller annotations, among others.
 * You can customize the scan process to include one or more include/exclude filters.
 *
 * When applying include filters to detect all classes whose name contains the word Dao or Service,
 * even classes that don’t have annotations are autodetected.
 */

@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"com.arjun.springcore.dao.*Dao*", "com.arjun.springcore.service.*Service*"}
                )
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {org.springframework.stereotype.Controller.class}
                )
        }
)
public class SpringCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableContext = SpringApplication.run(SpringCoreApplication.class, args);


        //example for Spring bean instantiation done by hard-coding the values in a Java config class.
        beanInstatiationUsingJavaConfig();

        //example for bean (POJO instance) creation using a Domain class and a Data Access Object (DAO) by scanning base packages.
        beanInstatiationByScanningBasePackage();

        //example for POJO instance creation in the Spring IoC container by invoking its constructor.
        // It is equivalent to using the new operator to create objects in Java.
        beanInstatiatonByInvokingConstructor();
    }

    private static void beanInstatiatonByInvokingConstructor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);

        System.out.println(aaa);
        System.out.println(cdrw);
    }

    private static void beanInstatiationByScanningBasePackage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.arjun.springcore.*");
        SequenceDao seqDao = context.getBean(SequenceDao.class);

        System.out.println(seqDao.getNextValue("IT"));
        // We are able to print contents only because of overriding toString() in Sequence class.
        System.out.println(seqDao.getSequence("IT"));
    }

    private static void beanInstatiationUsingJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfig.class);
        SequenceGenerator seqGen = (SequenceGenerator) context.getBean("sequenceGenerator");
        SequenceGenerator seqGen1 = context.getBean("sequenceGenerator", SequenceGenerator.class);
        SequenceGenerator seqGen2 = context.getBean(SequenceGenerator.class);
        System.out.println("seqGen: " + seqGen.getSequence());
        System.out.println("seqGen1: " + seqGen1.getSequence());
        System.out.println("seqGen2: " + seqGen2.getSequence());
        System.out.println("Hello World");
    }
}
