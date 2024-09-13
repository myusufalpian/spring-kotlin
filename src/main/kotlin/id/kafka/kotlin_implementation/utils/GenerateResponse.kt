package id.kafka.kotlin_implementation.utils

import id.kafka.kotlin_implementation.model.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class GenerateResponse(private val objectMapper: ObjectMapper) {

    fun success(message: String, data: Any?): ResponseEntity<String> {
        return ResponseEntity.ok(objectMapper.writeValueAsString(Response(code = 200, message = message, data = data)))
    }

    fun created(message: String, data: Any?): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapper.writeValueAsString(Response(code = 201, message = message, data = data)))
    }

    fun error(message: String): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(objectMapper.writeValueAsString(Response(code = 500, message = message, data = null)))
    }

    fun badRequest(message: String): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(objectMapper.writeValueAsString(Response(code = 400, message = message, data = null)))
    }

    fun notFound(message: String): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectMapper.writeValueAsString(Response(code = 404, message = message, data = null)))
    }

    fun unauthorized(message: String): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(objectMapper.writeValueAsString(Response(code = 401, message = message, data = null)))
    }
}
