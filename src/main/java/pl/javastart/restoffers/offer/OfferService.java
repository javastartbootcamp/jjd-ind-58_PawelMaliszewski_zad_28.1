package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    public List<OfferDto> getAllDtoOffers() {
        return offerRepository.findAll().stream().map(offerMapper::convertToOfferDto).collect(Collectors.toList());
    }

    public OfferDto insertDtoOffer(OfferDto offerDto) {
        Offer offer = offerMapper.convertToOffer(offerDto);
        Offer save = offerRepository.save(offer);
        return offerMapper.convertToOfferDto(save);
    }

    public List<OfferDto> getOfferByTitle(String title) {
       return offerRepository.getAllByTitle("%" + title + "%").stream().map(offerMapper::convertToOfferDto).collect(Collectors.toList());
    }

    public Optional<OfferDto> getOptionalDtoOfferById(Long id) {
        if (offerRepository.findById(id).isPresent()) {
            return Optional.of(offerMapper.convertToOfferDto(offerRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    public boolean deleteOffer(Long id) {
        if (offerRepository.existsById(id)) {
            offerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
