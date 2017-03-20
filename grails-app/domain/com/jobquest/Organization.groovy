package com.jobquest

class Organization {
	String name

    static constraints = {
    	name blank: false
    }

    static hasMany = [employees: Employee]
}
