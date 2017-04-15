package com.jobquest

import grails.transaction.Transactional
import grails.plugin.mail.*

@Transactional
class EmailService {

    def ping() {
    	sendMail {
		   to 'jobquest4all@gmail.com'
		   from 'JobQuest <jobquest4all@gmail.com>'
		   subject 'Test - Ping'
		   text 'Hello World!'
		}

		this
    }
}
