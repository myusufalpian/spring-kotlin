package id.kafka.kotlin_implementation.service

import id.kafka.kotlin_implementation.entity.User
import id.kafka.kotlin_implementation.model.SignInRequestDto
import id.kafka.kotlin_implementation.model.UserDetailDto
import id.kafka.kotlin_implementation.repository.UserRepository
import id.kafka.kotlin_implementation.utils.GenerateResponse
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
public class UserService @Autowired constructor(var userRepository: UserRepository, private val generateResponse: GenerateResponse, private val modelMapper: ModelMapper) {
    public fun signIn(param: SignInRequestDto): ResponseEntity<String> {
        val user = param.userUsername?.let { userRepository.findByUserUsernameAndUserStatus(it, 1) }
        if (user != null) {
            if (user.userPass == param.userPass) {
                println("Login Success")
                return generateResponse.success("Login Success", modelMapper.map(user, UserDetailDto::class.java))
            } else {
                println("Wrong Password")
                return generateResponse.error("Wrong Password")
            }
        } else {
            println("User Not Found")
            return generateResponse.notFound("User Not Found")
        }
    }
}