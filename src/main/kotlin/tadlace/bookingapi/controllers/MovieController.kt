package tadlace.bookingapi.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tadlace.bookingapi.dto.MovieDTO
import tadlace.bookingapi.service.MovieService

@RestController
class MovieController(
    private val movieService: MovieService
) {

    @PostMapping
    fun createMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> {
           return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
    }

    @GetMapping
    fun getMovies(): ResponseEntity<List<MovieDTO>> {
           return ResponseEntity.ok(movieService.getMovies())
    }

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id:Int): ResponseEntity<MovieDTO> {
        return ResponseEntity.ok(movieService.getMovie(id))
    }
    
    @PutMapping
    fun updateMovie(@RequestBody movieDTO: MovieDTO):ResponseEntity<MovieDTO>{
        return ResponseEntity.ok(movieService.updateMovie(movieDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id:Int):ResponseEntity<Unit> {
       return ResponseEntity(movieService.deleteMovie(id), HttpStatus.NO_CONTENT)
    }


}