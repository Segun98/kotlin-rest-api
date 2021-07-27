package tadlace.bookingapi

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import tadlace.bookingapi.dto.MovieDTO


data class Movie(
    val id: Int = -1,
    val name: String,
    val rating: String
)

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class MovieControllerTest(
    @Autowired(required = false)
    private val mockMvc: MockMvc,
    @Autowired(required = false)
    private val mapper: ObjectMapper
){

    @Test
    fun `creating a movie`(){

        val movie = Movie(1,"Testing", "8")
        mockMvc.post("/"){
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(movie)
        }.andExpect {
            jsonPath("$.id"){value(1)}
            jsonPath("$.name"){value("Testing")}
            jsonPath("$.rating"){value("8")}
        }
    }

}