package com.example.testJaxb2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringWriter;

@Component
public class MarshallerWrapper {

    @Autowired
    private Jaxb2Marshaller marshaller;
    // than:
    // JAXBContext jc = JAXBContext.newInstance(User.class);
    // Marshaller marshaller = jc.createMarshaller();

    // marshalls one object (of your bound classes) into a String.
    public <T> String marshallXml(final T obj) throws JAXBException {
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);
        marshaller.marshal(obj, result);
        return sw.toString();
    }

    // (tries to) unmarshall(s) an InputStream to the desired object.
    @SuppressWarnings("unchecked")
    public <T> T unmarshallXml(final InputStream xml) throws JAXBException {
        return (T) marshaller.unmarshal(new StreamSource(xml));
    }
}
