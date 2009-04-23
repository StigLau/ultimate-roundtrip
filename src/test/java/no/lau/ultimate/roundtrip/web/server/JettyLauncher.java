package no.lau.ultimate.roundtrip.web.server;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettyLauncher {
    public static void main(String[] args) {

        Server server = new Server(8080);
        server.addHandler(new WebAppContext("./src/main/webapp", "/ultimate-roundtrip"));
        try {
            server.start();
            Thread.sleep(100000); //Makes sure the server doesn't die
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
