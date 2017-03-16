package com.jobquest.security

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock
import grails.plugin.springsecurity.*
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.TestMixin
import grails.test.hibernate.*
import grails.test.mixin.support.GrailsUnitTestMixin
import org.springframework.security.providers.encoding.*

@TestFor(SecurityService)
@TestMixin(GrailsUnitTestMixin)
@Mock(LoginAuthenticity)
class SecurityServiceSpec extends Specification {
	static loadExternalBeans = true

    void "test createLogin"() {
    	given:
    	def username="yev"
    	def password="admin123"

    	when:
    	service.createLogin(username, password)

    	then:
    	LoginAuthenticity.findByUsername(username)

    	cleanup:
		LoginAuthenticity.findByUsername(username)?.delete()    	
    }

    void "test login()"(){
    	given:
    	def username="yev"
    	def password="admin123"
    	service.springSecurityService=applicationContext.getBean('springSecurityService')
    	service.createLogin(username, password)

    	expect:
    	service.login(username, password)

    	cleanup:
    	LoginAuthenticity.findByUsername(username)?.delete() 	
    }
}
