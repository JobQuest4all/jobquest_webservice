package com.jobquest

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(EmailService)
class EmailServiceSpec extends Specification {

    void "test ping"() {
        expect:
            service.ping()
    }
}
