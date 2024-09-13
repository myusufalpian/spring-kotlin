package id.kafka.kotlin_implementation.controller

import id.kafka.kotlin_implementation.model.SignInRequestDto
import id.kafka.kotlin_implementation.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth", produces = ["application/json"])
class AuthController(var userService: UserService) {
    @PostMapping("/sign-in")
    fun signIn(@RequestBody param: SignInRequestDto) = userService.signIn(param)
}