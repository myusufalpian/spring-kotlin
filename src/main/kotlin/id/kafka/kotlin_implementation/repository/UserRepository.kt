package id.kafka.kotlin_implementation.repository

import id.kafka.kotlin_implementation.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {
    fun findByUserUuidAndUserStatus(userUuid: String, userStatus: Int): User?
    fun findByUserUsernameAndUserStatus(userUsername: String, userStatus: Int): User?
}