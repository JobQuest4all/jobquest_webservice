package com.jobquest

import grails.transaction.Transactional

@Transactional
class EmailService {
    def ping() {
    	sendMail {
		   to "tangeroknight@gmail.com"
		   from "jquest4all@gmail.com"
		   subject "Ping"
		   text 'Hello World!'
		}

		this
    }
}
