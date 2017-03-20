package com.jobquest

class Reference {

	String position

    static constraints = {
    	person nullable: false
    	position blank: true
    }

    static hasMany = [people:Person]
    static belongsTo = Person
}
