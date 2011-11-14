package grails.plugin.bb

import grails.test.*
import grails.plugin.bb.BbService

class BbServiceTests extends GrailsUnitTestCase {
    BbService bbService;

    protected void setUp() {
        super.setUp()
        bbService = new BbService();
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testDefaultConfiguration() {
        assertEquals("Default configuration!", bbService.process("test"))
    }

    void testSpecialConfiguration() {
        assertEquals("Special configuration!", bbService.process("spec", "test"))
    }

    void testEscapeXml(){
        assertEquals("&amp;", bbService.escapeXml("&"));
    }
}
