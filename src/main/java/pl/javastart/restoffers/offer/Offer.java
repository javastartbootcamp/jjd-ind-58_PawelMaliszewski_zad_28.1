package pl.javastart.restoffers.offer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.javastart.restoffers.category.Category;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String imgUrl;
    private BigDecimal price;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
