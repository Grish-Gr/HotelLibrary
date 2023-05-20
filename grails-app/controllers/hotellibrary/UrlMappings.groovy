package hotellibrary

class UrlMappings {

    static mappings = {
        "/$home/$list/$page/$searchName?"(controller: "home", action:"list")


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
