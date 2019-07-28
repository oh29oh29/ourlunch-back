package pe.oh29oh29.ourlunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.entity.Family;
import pe.oh29oh29.ourlunch.entity.FamilyMember;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.repository.FamilyMemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;

    public List<FamilyMember> getFamilyMembers(RequestDTO.FamilyMembersSelectRequest request) {
        Family family = new Family();
        family.setId(request.getFamilyId());

        FamilyMember familyMember = new FamilyMember();
        familyMember.setFamily(family);

        return familyMemberRepository.findAll();
//        return familyMemberRepository.findAll(Example.of(familyMembers));
    }

}
