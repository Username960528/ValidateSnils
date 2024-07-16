package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://example.org/snils", name = "validateSnilsRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidateSnilsRequest {

    @XmlElement(namespace = "http://example.org/snils")
    private String snils;

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }
}