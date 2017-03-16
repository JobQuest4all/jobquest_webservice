package com.jobquest.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import com.jobquest.*

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class LoginAuthenticity  {
	transient springSecurityService
	static transients = ['springSecurityService']

	String username
	String password
	String accessToken
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<Role> getAuthorities() {
		LoginAuthenticityRole.findAllByLoginAuthenticity(this)*.role
	}

	def beforeInsert() {
		encodePassword()
		encodeAccessToken()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
			encodeAccessToken()
		}
	}

	protected void encodeAccessToken(){
		accessToken = springSecurityService?.passwordEncoder ?
            springSecurityService.encodePassword(password) :
            password
	}
	
	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ?
            springSecurityService.encodePassword(password) :
            password
	}

	static hasOne = [person: Person]

	static constraints = {
		password blank: false, nullable: false, minSize: 6
		username blank: false, unique: true, minSize: 3, matches: '[\\p{Alnum}\\.]++'
		accessToken blank: false, nullable: true
		person nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
}
