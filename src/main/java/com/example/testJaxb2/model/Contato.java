package com.example.testJaxb2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Contato implements Serializable {

    @XmlElement
    private Long id;

    @XmlElement
    private Integer version;

    @XmlElement
    private String name;

    @XmlElement
    private String lastName;

    @XmlElement
    private LocalDate birthDate;

    public static Contato testeDeContato(){
        return new Contato(new Random().nextLong(),
                           new Random().nextInt(),
                           "William",
                           "Dias",
                            LocalDate.of(2000, 02,02));
    }
}
