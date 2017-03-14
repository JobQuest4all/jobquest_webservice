package jobquest_web_services

import grails.transaction.Transactional
import com.jobquest.security.*;

@Transactional
class SecurityService {
	def springSecurityService

    LoginAuthenticity createLogin(String username, String password){
        if(!username || !password){
            return null
        }

        new LoginAuthenticity(username: username, password: password).save()
    }

    LoginAuthenticity login(String username, String password) {
        if(!username || !password){
            return null
        }

    	def foundUser = LoginAuthenticity.findByUsername(username)
    	boolean isPasswordValid = springSecurityService.passwordEncoder.isPasswordValid(foundUser?.password, password, null)

    	if(foundUser && isPasswordValid){
    		foundUser
    	}else{
    		return null
    	}
    }
}
