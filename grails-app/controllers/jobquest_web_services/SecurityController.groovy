package jobquest_web_services

class SecurityController {
	def springSecurityService
	
    def login(){
		foundUser = LoginAuthenticity.find{
			username == params.username &&
			password == springSecurityService.encodePassword(params.password)
		}
		
		if(foundUser){
			respond foundUser
		}else{
			render(status: 401, text: "User(${foundUser.username}) authentication failed")
		}
	}
}
