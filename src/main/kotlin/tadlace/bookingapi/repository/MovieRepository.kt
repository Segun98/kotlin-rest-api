package tadlace.bookingapi.repository

import org.springframework.data.repository.CrudRepository
import tadlace.bookingapi.entity.Movie


//takes in entity and the datatype of the primary key
interface MovieRepository: CrudRepository<Movie, Int>