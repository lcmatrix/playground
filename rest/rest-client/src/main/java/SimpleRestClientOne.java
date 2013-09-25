import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class SimpleRestClientOne {
    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest");
        String result = resource.path("message").accept(MediaType.TEXT_XML_TYPE).get(String.class);
        System.out.println("Call: " + result);
    }
}
