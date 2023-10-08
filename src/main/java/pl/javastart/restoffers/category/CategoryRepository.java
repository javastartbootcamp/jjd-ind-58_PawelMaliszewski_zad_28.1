package pl.javastart.restoffers.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findAllByName(String name);

    @Query(value = "SELECT COUNT(*) FROM Category c, Offer o WHERE c.id  = o.category.id AND c.id = :#{#id}")
    Integer countOffersByCategoryId(@Param("id") Long id);
}
