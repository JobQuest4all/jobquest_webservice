package jobquest_web_services

import grails.transaction.Transactional
import com.jobquest.security.*;

@Transactional
class SecurityService {
	def springSecurityService

    LoginAuthenticity login(String username, String password) {
        if(!username || !password){
            return false
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
