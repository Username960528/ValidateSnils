package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://example.org/snils", name = "validateSnilsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidateSnilsResponse {

    @XmlElement(namespace = "http://example.org/snils")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}