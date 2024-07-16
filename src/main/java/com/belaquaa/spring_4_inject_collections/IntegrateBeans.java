package com.belaquaa.spring_4_inject_collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("integrate-beans")
public class IntegrateBeans {
    private final List<String> fruits;

    // По-умолчанию Spring пытается найти все bean-ы с типом String, объединить в List<String> и произвести
    // интегрирование. В данном случае будет создана коллекции на основании одного найденного bean-а (some-fruit),
    // а bean из List<String> рассмотрен не будет:
    @Autowired
    IntegrateBeans(List<String> fruits) {
        this.fruits = fruits;
    }

    // В случаях, когда необходимо внедрить только часть bean-ов с типом String, то совместно с аннотацией @Bean
    // используется @Qualifier("some-name"). Далее при интеграции bean-ов с помощью @Autowired, аналогично, указывается
    // @Qualifier("some-name"), которая объединит в коллекцию только bean-ы, объявленные с @Qualifier("some-name").

    // Если в качестве коллекции будет использоваться Map, то значениями будут сами bean-ы, а ключами - имена bean-ов.

    public List<String> getFruits() {
        return fruits;
    }
}
