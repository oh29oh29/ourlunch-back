package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

@RequiredArgsConstructor

@Service
public class MemberCommandService {

    private final MemberRepository memberRepository;

    @Transactional
    public void joinFamily(
            String userId,
            Family family
    ) {
        final Member member = findById(userId);
        member.setFamily(family);
    }

    @Transactional
    public Member signUp(
            String id,
            String nickName
    ) {
        return memberRepository.save(new Member(id, nickName));
    }

    public Member findById(String id) {
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void updateFamilyWithMaster(
            String userId,
            String userName,
            String appetite,
            Family family
    ) {
        final Member member =
                memberRepository
                        .findById(userId)
                        .orElseGet(() -> signUp(userId, ""));

        member.setName(userName);
        member.setAppetite(appetite);
        member.setFamily(family);
        member.setMaster(true);
    }

}
