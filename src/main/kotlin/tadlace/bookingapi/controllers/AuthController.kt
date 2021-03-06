package tadlace.bookingapi.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tadlace.bookingapi.dto.LoginDTO
import tadlace.bookingapi.entity.Users
import tadlace.bookingapi.service.UsersService
import tadlace.bookingapi.utils.exceptions.Message
import java.util.*

@RestController
class AuthController(
    private val usersService: UsersService
) {

    @PostMapping("createUser")
    fun createUser(@RequestBody user: Users): ResponseEntity<Users> {
        return ResponseEntity(usersService.createUser(user), HttpStatus.CREATED)
    }

    @GetMapping("users")
    fun getUsers(): ResponseEntity<MutableIterable<Users>> = ResponseEntity.ok(usersService.getUsers())

    @PostMapping("login")
    fun login(@RequestBody loginBody: LoginDTO): ResponseEntity<Any?> {
        val user = usersService.login(loginBody.email) ?: return ResponseEntity.badRequest().body(Message("Not found"))

        val check = user.comparePassword(loginBody.password)

        return if (check) {
//            val issuer = loginBody.email
//            JWT.
//            val token = JWT.builder()
//                .withIssuer(issuer)
//                .withClaim("username", loginBody.email)
//                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
//                .sign(Algorithm.HMAC256(secret))

            ResponseEntity.ok(user)
        } else {
            ResponseEntity.badRequest().body(Message("Wrong Password"))
        }

    }
}
