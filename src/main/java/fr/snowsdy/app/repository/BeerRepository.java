package fr.snowsdy.app.repository;

import fr.snowsdy.app.entity.Beer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("beerRepository")
public interface BeerRepository extends CrudRepository<Beer, Long> {
    
    @Query("from Beer where price >= :min and price <= :max")
    List<Beer> searchByPrice(@Param("min") float min, @Param("max") float max);

    default String testOk(){
        return "T'a perdu!";
    }
}
