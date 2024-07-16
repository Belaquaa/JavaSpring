package com.belaquaa.spring_3_scanning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Аннотация @ComponentScan используется вместе с @Configuration для указания Spring контейнеру, где искать
// компоненты, которые должны быть автоматически обнаружены и зарегистрированы как bean-ов. @ComponentScan может
// автоматически обнаруживать все классы с аннотациями @Component, @Service, @Repository, @Controller и другими
// стереотипными аннотациями.

// Аннотация @PropertySource используется для указания пути к файлам свойств, которые должны быть загружены в контекст
// приложения. Это позволяет разработчикам внедрять конфигурационные данные из внешних источников и использовать их в
// своих компонентах с помощью аннотации @Value. Путь указывается относительно папки resources.

@Configuration
@ComponentScan("com.belaquaa.spring_3_scanning")
@PropertySource("classpath:data.properties")
public class ScanConfig {
    // Компоненты в пакете "com.vovandrelo.spring_3_scanning" и его подпакетах, аннотированные как @Component,
    // @Service, @Repository или @Controller, будут автоматически обнаружены и добавлены в контекст приложения в
    // качестве bean-ов без необходимости явного определения методов @Bean для каждого из них.

    // Причём, внутри одного приложения часть bean-ов может быть создана с помощью аннотаций, а часть через явное
    // определение внутри конфигурационного класса.
}
