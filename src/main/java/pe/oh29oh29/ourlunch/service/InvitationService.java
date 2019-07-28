package pe.oh29oh29.ourlunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.repository.FamilyRepository;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final FamilyRepository familyRepository;

}
