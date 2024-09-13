package id.kafka.kotlin_implementation.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class UserDetailDto {
    var userUuid: String? = UUID.randomUUID().toString()
    var userEmail: String? = null
    var userUsername: String? = null
    var createdBy: Int? = null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createdDate: Date? = null
    var updatedBy: Int? = null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var updatedDate: Date? = null
}