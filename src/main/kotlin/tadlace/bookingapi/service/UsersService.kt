package tadlace.bookingapi.service

import org.springframework.stereotype.Service
import tadlace.bookingapi.dto.LoginDTO
import tadlace.bookingapi.entity.Users
import tadlace.bookingapi.repository.UserRepository

@Service
class UsersService(
    private val userRepository: UserRepository
) {
    fun createUser(user:Users): Users{
        userRepository.save(user)
        return user
    }

    fun getUsers(): MutableIterable<Users> {
        return userRepository.findAll()
    }


    fun login(email: String):Users?{
        return userRepository.findByEmail(email)
    }
}