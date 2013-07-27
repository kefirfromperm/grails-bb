class BbGrailsPlugin {
    // the plugin version
    def version = "1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "grails-app/conf/kefirbb.xml",
            "grails-app/conf/spec.xml",
            "grails-app/conf/DataSource.groovy",
            "grails-app/conf/UrlMappings.groovy",
            "web-app"
    ]

    def author = "Vitalii Samolovskikh aka Kefir"
    def authorEmail = "kefir@perm.ru"
    def title = "Grails BB-Codes plugin"
    def description = '''The plugin supports text processing with the KefirBB library.
The KefirBB allows to create flexible configurations for different text translations.
For example, BB-to-HTML or HTML filtration.'''

    // URL to the plugin's documentation
    def documentation = "http://kefirsf.org/kefirbb/"
    String license = 'APACHE'
    def issueManagement = [system: 'github', url: 'https://github.com/kefirfromperm/grails-bb/issues']
    def scm = [url: 'https://github.com/kefirfromperm/grails-bb']
}
