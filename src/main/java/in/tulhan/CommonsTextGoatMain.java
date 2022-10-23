package in.tulhan;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Hello world!
 *
 */
public class CommonsTextGoatMain {
    public static void main(String[] args) throws Exception {
        // Start a server listening on the defined port
        int port = 8080;
        Server server = new Server(port);
        WebAppContext webAppContext = new WebAppContext();
        server.setHandler(webAppContext);

        URL webAppDir = CommonsTextGoatMain.class.getClassLoader().getResource("META-INF/resources");
        webAppContext.setResourceBase(webAppDir.toURI().toString());

        // Look for annotations in the jar file and classes directory
        webAppContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/target/classes/|.*\\.jar");

        // Start server and keep the server alive
        server.start();
        String x = String.format("Server running at port %d", port);
        System.out.println(x);
        server.join();
    }
}
