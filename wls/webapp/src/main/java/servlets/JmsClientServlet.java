/*
 * Created by norman on 14.09.15.
 */
package servlets;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet which reads JMS Messages.
 */
@WebServlet(name = "JmsClientServlet", urlPatterns = "/jmsservlet")
public class JmsClientServlet extends HttpServlet {

    @Resource(mappedName = "jms/ConnectionFactory", type = javax.jms.ConnectionFactory.class,
    name = "jms.ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/Queue0", type = javax.jms.Queue.class, name = "jms.Queue0")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("<html><head></head><body><p>Folgende Nachrichten wurden empfangen:</p>");

        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            connection.start();
            QueueBrowser browser = session.createBrowser(queue);
            Enumeration enumeration = browser.getEnumeration();
            MessageConsumer consumer = session.createConsumer(queue);
            while(true) {
                TextMessage message = (TextMessage) consumer.receive(1000);
                if (message == null) {
                    // no message received, stop receiving
                    break;
                }
                out.write("Message: " + message.getText() + "<br/>");
                System.out.println("read jms message [ID: " + message.getJMSMessageID()
                        + " , Text: " + message.getText() + "]");
                message.acknowledge();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        out.write("</body></html>");
        out.flush();
    }

    // not used anymore, using dependency injection
    //@PostConstruct
    /*private void setup() {
        try {
            Context context = new InitialContext();
            this.connectionFactory = (ConnectionFactory) context.lookup("jms/ConnectionFactory");
            this.queue = (Queue) context.lookup("jms/Queue0");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }*/
}
