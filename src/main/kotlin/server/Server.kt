package server

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>){
    embeddedServer(Netty, port=8080){
        routing {
            route("/tasks", Route::taskRoute)
        }
        install(ContentNegotiation){
            gson {  }
        }
    }.run {
        start()
    }
}

fun Route.taskRoute(){
    get("/"){
        call.respond(Tasks.getTasks())
    }

    post("/"){
        val task = call.receive<String>()
        Tasks.addTask(task)
        call.respond(HttpStatusCode.Created)
    }

}