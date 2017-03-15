package com.jobquest
import com.jobquest.security.*

class Person {

	String firstName, lastName, email, phone

    static constraints = {
    	firstName blank: false, minSize: 2, matches: '[\\p{Alpha}]+[\']*[\\p{Alpha}]*'
    	lastName blank: false, minSize: 2, matches: '[\\p{Alpha}]+[\']*[\\p{Alpha}]*'
    	email email: true, blank: false, unique: true
    	phone blank: true, matches: '\\+{0,1}[0-9]*.*[0-9]{3}.*[0-9]{3}.*[0-9]{4}'
    	user nullable: true
    }

    LoginAuthenticity user
}
