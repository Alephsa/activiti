grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.repos.alephsa.url = "https://api.bintray.com/maven/alephsa/maven/grails-activiti-plugin"
grails.project.repos.alephsa.type = "maven"
grails.project.repos.alephsa.username = "alephsa"
grails.project.repos.alephsa.password = "9c7662d7a72d6571b54626a931f070f33e4e46e0"
grails.release.scm.enabled = false
grails.project.repos.default = "alephsa"

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits 'global'
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        mavenRepo name: "Activiti", root: "https://maven.alfresco.com/nexus/content/groups/public"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile ('org.activiti:activiti-engine:5.16.4') {
            excludes 'livetribe-jsr223', 'spring-beans'
        }
        runtime ('org.activiti:activiti-spring:5.16.4') {
            excludes 'spring-context', 'spring-jdbc', 'spring-orm', 'slf4j-log4j12', 'commons-dbcp'
        }
        //runtime 'org.springframework:spring-asm:3.1.4.RELEASE'
        runtime 'javax.mail:mail:1.4.1'
        test ('org.subethamail:subethasmtp-smtp:1.2') {
            excludes 'commons-logging'
        }
        test ('org.subethamail:subethasmtp-wiser:1.2') {
            excludes 'commons-logging'
        }
    }
    plugins {
        build (":tomcat:7.0.55"){
            export = false
        }
        compile ":release:3.0.1"
    }
}
