package pl.javastart.restoffers.offer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfferDto {

    private Long id;
    private String title;
    private String description;
    private String imgUrl;
    private BigDecimal price;
    private String category;
}
