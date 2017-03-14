package jobquest_web_services

import com.jobquest.security.*;

class BootStrap {
    def init = { servletContext ->
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
		def userRole = new Role(authority: 'ROLE_CANDIDATE').save(failOnError: true)
		def adminUser = new LoginAuthenticity(username: 'admin', password: 'admin123').save(failOnError: true)
  
		new LoginAuthenticityRole(loginAuthenticity: adminUser, role: adminRole).save(failOnError: true)
		
		for (String url in [
			'/security/**'
			]) {
		 new RequestMap(url: url, configAttribute: 'permitAll').save(failOnError: true)
	  }
    }
    def destroy = {
    }
}
