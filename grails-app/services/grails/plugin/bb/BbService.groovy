package grails.plugin.bb

import org.kefirsf.bb.BBProcessorFactory
import org.kefirsf.bb.EscapeXmlProcessorFactory
import org.kefirsf.bb.TextProcessor

import java.util.concurrent.ConcurrentHashMap

class BbService {
    /** Configuration resource extension  */
    private static final CONFIGURATION_EXTENSION = '.xml';

    // It isn't need transaction
    boolean transactional = false;

    // TextProcessorFactory
    private BBProcessorFactory factory;

    // Processors
    private final TextProcessor defaultProcessor;
    private final Map<String, TextProcessor> processors;
    private final TextProcessor escapeXmlProcessor;
    private final TextProcessor safeHtmlProcessor;

    /**
     * Construct the service
     */
    def BbService() {
        factory = BBProcessorFactory.getInstance();
        defaultProcessor = factory.create();
        safeHtmlProcessor = factory.createFromResource("org/kefirsf/bb/safehtml.xml")
        escapeXmlProcessor = EscapeXmlProcessorFactory.getInstance().create();
        processors = new ConcurrentHashMap<String, TextProcessor>();
    }

    /**
     * Process text with specified configuration
     */
    CharSequence process(String configuration, CharSequence src) {
        TextProcessor processor = processors.get(configuration);
        if (processor == null) {
            def resourceName = configuration + CONFIGURATION_EXTENSION;
            processor = factory.createFromResource(resourceName);
            processors.put(configuration, processor);
        }
        return processor.process(src);
    }

    /**
     * Process text with default configuration of KefirBB
     */
    CharSequence process(CharSequence src) {
        return defaultProcessor.process(src);
    }

    /**
     * Escape XML symbols
     */
    CharSequence escapeXml(CharSequence src) {
        return escapeXmlProcessor.process(src);
    }

    /**
     * Process HTML to safe HTML. Without JS and styles.
     */
    CharSequence safeHtml(CharSequence src) {
        return safeHtmlProcessor.process(src)
    }
}
