package com.jobquest

import grails.transaction.Transactional
import com.jobquest.security.*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
class PeopleService {
	def log = LoggerFactory.getLogger("grails.app.service.PeopleService")

	def createPerson(LoginAuthenticity user, HashMap params){
		if(!user || !params){return null}

		def person = Person.findByEmail(params.email)

		if(!person){
			person = new Person(firstName: params.firstName,
				lastName: params.lastName,
				email: params.email,
				phone: params.phone,
				user: user
				).save(failOnError: true)
		}

		person
	}

    def createCandidate(Person person, HashMap params) {
    	if(!person || !params){return null}

    	def candidate = Candidate.findById(person.id)

		if(!candidate){
			candidate = new Candidate(person: person, legalStatus: params.legalStatus).save(failOnError: true)
		}

		candidate
    }
}
