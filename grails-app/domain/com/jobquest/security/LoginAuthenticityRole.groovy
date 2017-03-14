package com.jobquest.security

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class LoginAuthenticityRole implements Serializable {

	private static final long serialVersionUID = 1

	LoginAuthenticity loginAuthenticity
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof LoginAuthenticityRole) {
			other.loginAuthenticityId == loginAuthenticity?.id && other.roleId == role?.id
		}
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (loginAuthenticity) builder.append(loginAuthenticity.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static LoginAuthenticityRole get(long loginAuthenticityId, long roleId) {
		criteriaFor(loginAuthenticityId, roleId).get()
	}

	static boolean exists(long loginAuthenticityId, long roleId) {
		criteriaFor(loginAuthenticityId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long loginAuthenticityId, long roleId) {
		LoginAuthenticityRole.where {
			loginAuthenticity == LoginAuthenticity.load(loginAuthenticityId) &&
			role == Role.load(roleId)
		}
	}

	static LoginAuthenticityRole create(LoginAuthenticity loginAuthenticity, Role role) {
		def instance = new LoginAuthenticityRole(loginAuthenticity: loginAuthenticity, role: role)
		instance.save()
		instance
	}

	static boolean remove(LoginAuthenticity u, Role r) {
		if (u != null && r != null) {
			LoginAuthenticityRole.where { loginAuthenticity == u && role == r }.deleteAll()
		}
	}

	static int removeAll(LoginAuthenticity u) {
		u == null ? 0 : LoginAuthenticityRole.where { loginAuthenticity == u }.deleteAll()
	}

	static int removeAll(Role r) {
		r == null ? 0 : LoginAuthenticityRole.where { role == r }.deleteAll()
	}

	static constraints = {
		role validator: { Role r, LoginAuthenticityRole ur ->
			if (ur.loginAuthenticity?.id) {
				LoginAuthenticityRole.withNewSession {
					if (LoginAuthenticityRole.exists(ur.loginAuthenticity.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['loginAuthenticity', 'role']
		version false
	}
}
