package grails.plugin.bb

import grails.test.mixin.TestFor

@TestFor(BbService)
class BbServiceTests {
    void testDefaultConfiguration() {
        assertEquals("Default configuration!", service.process("test"))
    }

    void testSpecialConfiguration() {
        assertEquals("Special configuration!", service.process("spec", "test"))
    }

    void testEscapeXml() {
        assertEquals("&amp;", service.escapeXml("&"));
    }

    void testSafeHtml() {
        assertEquals("<b>test</b>", service.safeHtml("<b onclick=\"...\">test</b>"));
    }
}
