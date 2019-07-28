package pe.oh29oh29.ourlunch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.oh29oh29.ourlunch.TestSupport;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.repository.FamilyMemberRepository;

public class FamilyMemberServiceTest extends TestSupport {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private FamilyMemberService familyMemberService;

    @Test
    public void 점심팸_멤버_조회_테스트() {
    }
}
