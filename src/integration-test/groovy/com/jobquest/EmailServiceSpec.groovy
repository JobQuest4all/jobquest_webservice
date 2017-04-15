package com.jobquest


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class EmailServiceSpec extends Specification {
    def emailService

    void "test ping"() {
        expect:
            emailService.ping()
    }
}
