package tadlace.bookingapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import tadlace.bookingapi.entity.Users

interface UserRepository: JpaRepository<Users, Int> {
     fun findByEmail(email:String): Users?
}