/*
 * Created by norman on 29.05.15.
 */
package rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A model class with JAXB annotations for REST service.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RestModel {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name=").append(name).append(", value=").append(value);
        return sb.toString();
    }
}
