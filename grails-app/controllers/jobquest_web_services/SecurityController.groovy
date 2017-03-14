package jobquest_web_services
import com.jobquest.security.*
import grails.plugin.springsecurity.annotation.Secured
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SecurityController {
	static String JSON_CONTENT_TYPE='application/json'

	def log = LoggerFactory.getLogger("grails.app.controller.SecurityController")
	def securityService
	
	def createNewUser(){
		if(!verifyInput()) { return }

		def newUser = securityService.createLogin(usernameFromRequest(), passwordFromRequest())

		if(newUser){
			render(contentType: JSON_CONTENT_TYPE) {
					user(username: newUser.username, 
						accessToken: newUser.accessToken,
						passwordExpired: newUser.passwordExpired,
						accountExpired: newUser.accountExpired,
						accountLocked: newUser.accountLocked)
				}
		}else{
			log.info "User not created: ${usernameFromRequest()}"
			render(status: 500, text: "User not created: ${usernameFromRequest()}")
		}
	}

    def login(){
		if(!verifyInput()) { return }

		def foundUser = securityService.login(usernameFromRequest(), passwordFromRequest())
		
		if(foundUser){
			log.info "User has been authenticated: ${foundUser.username}"
			render(contentType: JSON_CONTENT_TYPE) {
				user(username: foundUser.username, 
					accessToken: foundUser.accessToken,
					passwordExpired: foundUser.passwordExpired,
					accountExpired: foundUser.accountExpired,
					accountLocked: foundUser.accountLocked)
			}
		}else{
			log.info "User not authenticated: ${usernameFromRequest()}"
			render(status: 401, text: "user authentication failed: invalid credentials")
		}
	}

	private String usernameFromRequest(){
		request.JSON.get('username').toString()
	}

	protected String passwordFromRequest(){
		request.JSON.get('password').toString()
	}

	/*
	Verify input. If invalid, render 401 response and return flag.
	*/
	private boolean verifyInput(){
		if(!request.JSON){
			render(status: 401, text: "user authentication failed: credentials malformed")
			false
		}
		
		else if(!request.JSON.containsKey('username')){
			render(status: 401, text: "user authentication failed: username missing")
			false
		}

		else if(!request.JSON.containsKey('password')){
			render(status: 401, text: "user authentication failed: password missing")
			false
		}

		true
	}
}
