package com.example.testJaxb2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;

@Configuration
public class Jaxb2Config {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(new Class[]{
                // O Jaxb necessita conhecer todas as classes de contexto XML
                //com.example.testJaxb2.classe1.class,
                //com.example.testJaxb2.classe2.class,
                //com.example.testJaxb2.classe3.class
        });

        marshaller.setMarshallerProperties(new HashMap<String, Object>() {
            //put(javax.xml.bind.Marshaller.JAXB_FORMATTER_OUTPUT, true);
        });

        return marshaller;
    }
}
