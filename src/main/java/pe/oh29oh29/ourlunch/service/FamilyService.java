package pe.oh29oh29.ourlunch.service;

import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.repository.FamilyRepository;

@Service
public class FamilyService {

    private FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
}
