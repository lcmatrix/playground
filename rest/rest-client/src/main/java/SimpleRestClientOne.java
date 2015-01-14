import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class SimpleRestClientOne {
    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest");
        ClientResponse result = resource.path("message").accept(MediaType.TEXT_XML_TYPE).get(ClientResponse.class);
        if(result.hasEntity()) {
            System.out.println("Call: " + result.getEntity(MessageOne.class).getMessage());
        }

        String s = resource.path("message").get(String.class);
        System.out.println(s);
        ClientResponse message = resource.path("message").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        System.out.println("Call 2: " + message);
    }
}
