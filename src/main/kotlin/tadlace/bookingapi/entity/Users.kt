package tadlace.bookingapi.entity

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0

    @Column
    val name: String = ""

    @Column(unique = true)
    val email: String = ""

    @Column
    var password = ""
        set(value){
        val passwordEnc = BCryptPasswordEncoder()
        field = passwordEnc.encode(value)
    }

    fun comparePassword(password: String):Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}