// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.jobquest.security.LoginAuthenticity'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.jobquest.security.LoginAuthenticityRole'
grails.plugin.springsecurity.authority.className = 'com.jobquest.security.Role'
grails.plugin.springsecurity.requestMap.className = 'com.jobquest.security.RequestMap'
grails.plugin.springsecurity.securityConfigType = 'Requestmap'
grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false

grails {
   mail {
     host = "smtp.gmail.com"
     port = 465
     username = "jobquest4all@gmail.com"
     password = "jquest123"
     props = ["mail.smtp.auth":"true",
     		      "mail.smtp.port": "587",
              "mail.smtp.starttls.enable":"true"]
   }
}