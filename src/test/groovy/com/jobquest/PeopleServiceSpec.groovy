package com.jobquest

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock
import grails.plugin.springsecurity.*
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.TestMixin
import grails.test.hibernate.*
import grails.test.mixin.support.GrailsUnitTestMixin
import org.springframework.security.providers.encoding.*
import com.jobquest.security.*

@TestFor(PeopleService)
@TestMixin(GrailsUnitTestMixin)
@Mock([LoginAuthenticity, Person, Candidate])
class PeopleServiceSpec extends Specification {
	static loadExternalBeans = true

    void "test createPerson"() {
    	given:
    	def user = new LoginAuthenticity(username: 'yev', password: 'admin123').save()

    	when:
    	def person=service.createPerson(user, 
            [
                firstName: 'John', 
                lastName: 'Smmith',
                phone: '312-434-3325',
                email: 'jobquest123@gmail.com'
            ])

    	then:
    	Person.findByEmail('jobquest123@gmail.com')

    	cleanup:
        user?.delete()
		Person.findByEmail('jobquest123@gmail.com')?.delete()    	
    }

    void "test createCandidate()"(){
        given:
        def user = new LoginAuthenticity(username: 'yev', password: 'admin123').save()
        def stubPerson = new Person(user: user,
                firstName: 'John', 
                lastName: 'Smmith',
                phone: '312-434-3325',
                email: 'jobquest123@gmail.com'
            ).save()

        when:
        def candidate = service.createCandidate(stubPerson,[legalStatus:Candidate.LegalStatuses.USCitizen])

        then:
        Candidate.where{person == stubPerson}

        cleanup:
        user?.delete()
        stubPerson?.delete()
        candidate?.delete()
    }
}
