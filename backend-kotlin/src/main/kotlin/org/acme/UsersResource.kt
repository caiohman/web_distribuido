package org.acme

import org.acme.model.Users
import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.panache.common.Sort
import org.jboss.logging.Logger
import java.lang.Exception
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.WebApplicationException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Path("/users")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
class UsersResource {

    @GET
    fun get(): List<Users> {
        return Users.listAll(Sort.by("name"))
    }

    @Provider
    class ErrorMapper : ExceptionMapper<Exception> {
        @Inject
        lateinit var objectMapper: ObjectMapper

        override fun toResponse(exception: Exception): Response {
            LOGGER.error("Failed to handle request", exception)
            var code = 500
            if (exception is WebApplicationException) {
                code = exception.response.status
            }
            val exceptionJson = objectMapper.createObjectNode()
            exceptionJson.put("exceptionType", exception.javaClass.name)
            exceptionJson.put("code", code)
            if (exception.message != null) {
                exceptionJson.put("error", exception.message)
            }
            return Response.status(code)
                .entity(exceptionJson)
                .build()
        }
    }

    companion object {
        private val LOGGER = Logger.getLogger(UsersResource::class.java.name)
    }

}