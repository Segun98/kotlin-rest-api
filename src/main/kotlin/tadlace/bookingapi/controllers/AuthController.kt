package tadlace.bookingapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
//class AuthController {
//
//   @GetMapping
//   fun helloWorld() = listOf(Users("Segun", "Olanitori"), Users("Don", "Simon"), Users("Jon", "Doe"))
//
//}
data class Users(val firstName: String, val lastName:String)
