import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("message")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message(){
        return "hi";
    }

    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    public MessageOne messageAsXml() {
        MessageOne response = new MessageOne();
        response.setMessage("hallo xml");
        return response;
    }
}
