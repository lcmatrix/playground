/*
 * Created by norman on 29.05.15.
 */
package rest;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * REST Service.
 */
@Path("/hello")
public class HelloRestService {

    @JMSConnectionFactory("jms/ConnectionFactory")
    @Resource(lookup="jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup="jms/Queue0")
    private Queue queue;

    /**
     * Simple method which returns "Hello REST" as String.
     * @return Hello REST
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Hello REST";
    }

    /**
     * This method returns an instance of {@link RestModel} as JSON or XML.
     * @return a {@link RestModel} instance
     */
    @Path("/model")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RestModel getModel() {
        RestModel model = new RestModel();
        model.setName("key");
        model.setValue("value");
        return model;
    }

    /**
     * This method reads POST requests with content type json and xml and print the given data.
     * @param data given data in request
     */
    @Path("/send")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void doPostModel(RestModel data) {
        System.out.println("Received model: " + data);
    }

    /**
     * This method reads POST requests with content type text/plain and print the given data.
     * @param data given data in request
     */
    @Path("/send")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void doPostString(String data) {
        System.out.println("Received string: " + data);
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(this.queue);
            TextMessage message = session.createTextMessage(data);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @PostConstruct
    private void setup() throws NamingException {
        Context context = new InitialContext();
        this.connectionFactory = (ConnectionFactory) context.lookup("jms/ConnectionFactory");
        this.queue = (Queue) context.lookup("jms/Queue0");
    }
}
