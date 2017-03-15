package com.jobquest
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CandidateController {
	static String JSON_CONTENT_TYPE='application/json'
	SecurityService securityService
	PeopleService peopleService
	def log = LoggerFactory.getLogger("grails.app.controller.CandidateController")

    def create() { 
		if(!verifyInput()) { return }
		else if(!request.JSON){
			render(contentType: JSON_CONTENT_TYPE){}
			return
		}	

		log.info "username from request: ${usernameFromRequest()}"
		log.info "access-token from request: ${accessTokenFromRequest()}"
		log.info "firstName from request: ${firstNameFromRequest()}"
		log.info "lastName from request: ${lastNameFromRequest()}"
		log.info "email from request: ${emailFromRequest()}"
		log.info "phone from request: ${phoneFromRequest()}"

		def foundUser = securityService.refreshLogin(usernameFromRequest(), accessTokenFromRequest())

		if(!foundUser){
			log.info "[CandidateController] User not found: ${usernameFromRequest()}"
			render(status: 401, text: "user authentication failed: user(${usernameFromRequest}) not found")
			return false
		}

		log.info "Found user: ${foundUser.username}"

		def person = peopleService.createPerson(foundUser, [firstName: firstNameFromRequest(),
			lastName: lastNameFromRequest(),
			email: emailFromRequest(),
			phone: phoneFromRequest()
			])

		log.info "Person created: ${person.firstName} ${person.lastName}"

		def candidateObj = peopleService.createCandidate(person, [legalStatus: legalStatusFromRequest()])

		log.info "Candidate created for person named ${person.firstName} ${person.lastName}"

		render(contentType: JSON_CONTENT_TYPE) {
					candidate(username: foundUser.username, 
						accessToken: foundUser.accessToken,
						passwordExpired: foundUser.passwordExpired,
						accountExpired: foundUser.accountExpired,
						accountLocked: foundUser.accountLocked,
						firstName: person.firstName,
						lastName: person.lastName,
						email: person.email,
						legalStatus: candidateObj.legalStatus)
				}
    }

    private String phoneFromRequest(){
    	request.JSON?.get('phone').toString()
    }

    private String legalStatusFromRequest(){
    	request.JSON?.get('legalStatus').toString()
    }

    private String emailFromRequest(){
    	request.JSON?.get('email').toString()
    }

    private String lastNameFromRequest(){
    	request.JSON?.get('lastName').toString()
    }

    private String firstNameFromRequest(){
    	request.JSON?.get('firstName').toString()
    }

    private String accessTokenFromRequest(){
    	request.JSON?.get('accessToken').toString()
    }

    private String usernameFromRequest(){
    	request.JSON?.get('username').toString()
    }

    private boolean verifyInput(){
    	if(!accessTokenFromRequest()){
			render(status: 401, text: "user authentication failed: access token not provided")
			return false
		}
		else if(!usernameFromRequest()){
			render(status: 401, text: "user authentication failed: username not provided")
			return false
		}

		true
    }
}
