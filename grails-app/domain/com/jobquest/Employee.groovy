package com.jobquest

class Employee {

	String position

    static constraints = {
    	person unique: true, nullable: false
    	position blank: true
    	organization nullable: false
    }

    static belongsTo = [organization: Organization]

    Person person
}
