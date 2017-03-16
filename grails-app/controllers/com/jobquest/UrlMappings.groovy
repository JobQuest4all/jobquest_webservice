package com.jobquest

class UrlMappings {

    static mappings = {
        group "/security", {
            group "/users", {
                "/"(controller: "security", action: "createNewUser", method: "POST")
            }
            "/login"(controller: "security", action: "login", method: "POST")
        }

        group "/people", {
            "/candidates"(resources: 'candidate')
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
