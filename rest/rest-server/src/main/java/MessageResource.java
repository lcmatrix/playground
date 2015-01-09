import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("message")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message(){
        return "hi";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public Response messageAsXml() {
        Response response = new Response();
        response.message = "hallo xml";
        return response;
    }

    @XmlRootElement
    class Response {
        private String message;
    }
}
