package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;

@RequiredArgsConstructor

@Service
public class FamilyQueryService {

    private final FamilyRepository familyRepository;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;


}
