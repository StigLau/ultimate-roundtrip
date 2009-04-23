package no.lau.ultimate.roundtrip.web.page;

import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Developer: Stig Lau
 * Date: Jul 20, 2007
 * Time: 9:28:26 PM
 */
public class GooglePageTest {

    private static WebTester tester;

    @BeforeClass
    public static void setUp() {
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
    }

    @Test
    public void testGoogleSearch() {
        tester.getTestContext().setBaseUrl("http://www.google.com");
        tester.beginAt("/index.html");
        tester.assertFormPresent("f");
        tester.setTextField("q", "JWebUnit");
        tester.submit("btnG");
        tester.assertLinkPresentWithText("JWebUnit - Quick Start");
    }
}
