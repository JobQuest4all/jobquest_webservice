package com.jobquest

class Candidate {
	static def LegalStatuses=[USCitizen: 'US Citizen', 
	GreenCard:'Green Card', 
	Visa: 'Visa']

	String legalStatus=''

    static constraints = {
    	person nullable: false, unique: true
    	legalStatus blank: true
    }

    Person person
}
