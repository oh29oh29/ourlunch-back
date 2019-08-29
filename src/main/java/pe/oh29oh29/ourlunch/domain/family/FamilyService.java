package pe.oh29oh29.ourlunch.domain.family;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    public Family createFamily() {

        return null;
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }

}
