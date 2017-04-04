package com.jobquest

class Candidate {
	static def LegalStatuses=[
	USCitizen: 'US Citizen', 
	GreenCard:'Green Card', 
	Visa: 'Visa',
	Other: 'Other']

	String legalStatus=''

    static constraints = {
    	person nullable: false, unique: true
    	legalStatus nullable: true
    }

    Person person
}
