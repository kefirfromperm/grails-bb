package grails.plugin.bb

import grails.test.*
import grails.plugin.bb.BbService
import grails.plugin.bb.BbTagLib

class BbTagLibTests extends TagLibUnitTestCase {
    StringWriter out;
    BbTagLib tl;

    protected void setUp() {
        super.setUp();
        out = new StringWriter();
        BbTagLib.metaClass.out = out;
        tl = new BbTagLib();
        tl.bbService = new BbService();
    }

    protected void tearDown() {
        super.tearDown();
        def remove = GroovySystem.metaClassRegistry.&removeMetaClass;
        remove BbTagLib;
    }

    void testDefaultConfiguration() {
        tl.process([text: 'test'], null);
        assertEquals("Default configuration!", out.toString());
    }

    void testBody() {
        tl.process([:], {return "test";});
        assertEquals("Default configuration!", out.toString());
    }

    void testSpecialConfiguration() {
        tl.process([conf: 'spec', text: 'test'], null);
        assertEquals("Special configuration!", out.toString());
    }

    void testEscapeXml(){
        tl.xml([text:'&'], null);
        assertEquals("&amp;", out.toString());
    }
}
