/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmerzamannow.spring.core.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.BeanConfiguration;
import programmerzamannow.spring.core.data.Foo;

/**
 *
 * @author acer
 */
public class BeanTest {
    
    @Test
    void testCreateBean(){
        
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        
        Assertions.assertNotNull(context);
    }
    
    @Test
    void testGetBean(){
        
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        
        Assertions.assertSame(foo1, foo2);
    }
    
}
