package com.jobquest.security

import grails.transaction.Transactional

@Transactional
class SecurityService {
	def springSecurityService

    LoginAuthenticity refreshLogin(String usernameInput, String accessTokenInput){
        LoginAuthenticity.where{username == usernameInput && accessToken == accessTokenInput}.find()
    }

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
