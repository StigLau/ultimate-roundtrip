package no.lau.ultimate.roundtrip.web.page;

import  net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.mortbay.jetty.webapp.WebAppContext;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * User: Stig
 *
 * Abstract class for testing web pages
 */
public abstract class AbstractWebTestFixture {
    protected static WebTester tester;
    private static org.mortbay.jetty.Server server;

    /**
     * Sets up a Jetty webserver for testing on integration-test-port 8095
     * Sets up the JWebUnit WebTester, used by all Web tests
     */
    @BeforeClass
    public static void setUp() throws Exception {
        server = new org.mortbay.jetty.Server(8080);
        server.addHandler(new WebAppContext("./src/main/webapp", "/ultimate-roundtrip"));
        server.start();

        // Set up tester
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        tester.getTestContext().setBaseUrl("http://localhost:8080/ultimate-roundtrip");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }
}
