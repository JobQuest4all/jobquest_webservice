package com.jobquest

class UrlMappings {

    static mappings = {
        post "/users"(controller: "user", action: "save")
        post "/users/login"(controller: "user", action: "login")
        post "/candidates"(controller: "candidate", action: "save")
    }
}
