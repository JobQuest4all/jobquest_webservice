package com.jobquest

class Reference {

	String position

    static constraints = {
    	person nullable: false
    	position blank: true
    }

    Person person
}
