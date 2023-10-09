package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping()
    ResponseEntity<List<OfferDto>> getDtoOffers(@RequestParam(required = false) String title) {
        if (title == null) {
                return ResponseEntity.ok(offerService.getAllDtoOffers());
        }
        return ResponseEntity.ok(offerService.getOfferByTitle(title));
    }

    @PostMapping
    ResponseEntity<OfferDto> insertOffer(@RequestBody OfferDto offerDto) {
        OfferDto saved = offerService.insertDtoOffer(offerDto);
        if (saved != null) {
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    ResponseEntity<Integer> offerCount() {
        return ResponseEntity.ok(offerService.getAllDtoOffers().size());
    }

    @GetMapping("/{id}")
    ResponseEntity<OfferDto> getOfferById(@PathVariable Long id) {
        if (offerService.getOptionalDtoOfferById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(offerService.getOptionalDtoOfferById(id).get());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOfferById(@PathVariable Long id) {
        boolean deleted = offerService.deleteOffer(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
