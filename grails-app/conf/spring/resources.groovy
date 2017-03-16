import grails.plugin.springsecurity.*
import grails.plugin.springsecurity.authentication.encoding.*

// Place your Spring DSL code here
beans = {
	passwordEncoder(BCryptPasswordEncoder, 10){}

	springSecurityService(SpringSecurityService){
		passwordEncoder = ref("passwordEncoder")
	}
}
