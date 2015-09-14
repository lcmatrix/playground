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

/**
 * Servlet which reads JMS Messages.
 */
@WebServlet(name = "JmsClientServlet", urlPatterns = "/jmsservlet")
public class JmsClientServlet extends HttpServlet {

    @Resource(lookup = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/Queue0")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("<html><head></head><body><p>Folgende Nachrichten wurden empfangen:</p>");

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            for(int i = 0; i < 3; i++) {
                TextMessage message = (TextMessage) consumer.receive();
                if (message != null) {
                    out.write("Message: " + message.getText() + "<br/>");
                    System.out.println("read jms message: " + message.getText());
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

        out.write("</body></html>");
        out.flush();
    }

    @PostConstruct
    private void setup() {
        try {
            Context context = new InitialContext();
            this.connectionFactory = (ConnectionFactory) context.lookup("jms/ConnectionFactory");
            this.queue = (Queue) context.lookup("jms/Queue0");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
