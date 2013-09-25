import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.io.IOException;

public class SimpleRestServer {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServerFactory.create("http://localhost:8080/rest");
        httpServer.start();
        JOptionPane.showMessageDialog(null, "Ende?");
        httpServer.stop(0);
    }
}