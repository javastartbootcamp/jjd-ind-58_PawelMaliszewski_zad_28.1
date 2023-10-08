package pl.javastart.restoffers.offer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

    @Query(value = "SELECT o FROM Offer o WHERE UPPER(o.title) LIKE UPPER(:#{#title})")
    public List<Offer> getAllByTitle(@Param("title") String title);

    @Override
    List<Offer> findAll();
}
