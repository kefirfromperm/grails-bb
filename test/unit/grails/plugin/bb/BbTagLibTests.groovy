package grails.plugin.bb

import grails.test.mixin.TestFor
import org.junit.Before

@TestFor(BbTagLib)
class BbTagLibTests {
    @Before
    public void prepareTagLib(){
        tagLib.bbService = new BbService();
    }

    void testDefaultConfiguration() {
        assertEquals("Default configuration!", applyTemplate('<bb:process text="test"/>'));
    }

    void testBody() {
        assertEquals("Default configuration!", applyTemplate('<bb:process>test</bb:process>'));
    }

    void testSpecialConfiguration() {
        assertEquals("Special configuration!", applyTemplate('<bb:process conf="spec" text="test"/>'));
    }

    void testEscapeXml(){
        assertEquals("&amp;", applyTemplate('<bb:xml text="&"/>'));
    }
}
