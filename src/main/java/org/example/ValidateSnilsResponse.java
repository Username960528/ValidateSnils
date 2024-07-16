package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "validateSnilsResponse")
public class ValidateSnilsResponse {
    private String result;

    @XmlElement
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}