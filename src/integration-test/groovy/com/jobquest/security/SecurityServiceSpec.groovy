package com.jobquest.security


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class SecurityServiceSpec extends Specification {
	def securityService

    void "test createLogin"() {
    	given:
    	def username="yev"
    	def password="admin123"

    	when:
    	securityService.createLogin(username, password)

    	then:
    	LoginAuthenticity.findByUsername(username)

    	cleanup:
		LoginAuthenticity.findByUsername(username)?.delete()    	
    }

    void "test login()"(){
    	given:
    	def username="yev"
    	def password="admin123"
    	securityService.createLogin(username, password)

    	expect:
    	securityService.login(username, password)

    	cleanup:
    	LoginAuthenticity.findByUsername(username)?.delete() 	
    }
}
