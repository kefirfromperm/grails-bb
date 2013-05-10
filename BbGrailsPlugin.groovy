class BbGrailsPlugin {
    // the plugin version
    def version = "1.0-SNAPSHOT"
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

    def author = "Vitaliy Samolovskih aka Kefir"
    def authorEmail = "kefir@perm.ru"
    def title = "Support bb codes with KefirBB"
    def description = '''\\
It supports text processing with KefirBB.
'''

    // URL to the plugin's documentation
    def documentation = "http://kefirsf.org/kefirbb/"
}
