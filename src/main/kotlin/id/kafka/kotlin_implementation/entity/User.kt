package id.kafka.kotlin_implementation.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "usrs", schema = "public")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usrs_id", columnDefinition = "serial")
    var userId: Int? = null
    @Column(name = "usrs_uuid")
    var userUuid: String? = UUID.randomUUID().toString()
    @Column(name = "usrs_rles_id")
    var userRoleId: Int? = 0
    @Column(name = "usrs_email")
    var userEmail: String? = null
    @Column(name = "usrs_usrnme")
    var userUsername: String? = null
    @Column(name = "usrs_pass")
    var userPass: String? = null
    @Column(name = "usrs_sttus")
    var userStatus: Int? = 0
    @Column(name = "created_by")
    var createdBy: Int? = null
    @Column(name = "createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createdDate: Date? = null
    @Column(name = "updated_by")
    var updatedBy: Int? = null
    @Column(name = "updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var updatedDate: Date? = null
}