package no.lau.ultimate.roundtrip.web.page;

import org.junit.*;

/**
 * @author Stig Lau
 * Checks that the front page renders correctly
 * This test shows how one can render pages on the local server
 */
public class IndexPageTest extends AbstractWebTestFixture {

    @Before
    public void setContext() {
        tester.getTestContext().setBaseUrl("http://localhost:8080/ultimate-roundtrip");
    }

    @Test
    public void testFrontPage() {
        tester.beginAt("/index.ftl");
        tester.assertTextPresent("2. wicket");
    }
}
