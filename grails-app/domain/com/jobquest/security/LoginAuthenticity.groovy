package com.jobquest.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class LoginAuthenticity implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

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
		accessToken = springSecurityService.encodePassword(password)
	}
	
	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}

	static constraints = {
		password blank: false, nullable: false
		username blank: false, unique: true
		accessToken blank: false, nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
}
