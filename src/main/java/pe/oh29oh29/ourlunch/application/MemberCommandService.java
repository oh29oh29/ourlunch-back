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
            final String userId,
            final Family family
    ) {
        final Member member = findById(userId);
        member.setFamily(family);
    }

    public boolean exist(final String id) {
        return memberRepository.findById(id).isPresent();
    }

    @Transactional
    public Member signUp(
            final String id,
            final String nickName
    ) {
        return memberRepository.save(Member.of(id, nickName));
    }

    public Member findById(final String id) {
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void updateFamilyWithMaster(
            final String userId,
            final Family family
    ) {
        final Member member =
                memberRepository
                        .findById(userId)
                        .orElseGet(() -> signUp(userId, ""));

        member.setFamily(family);
        member.setMaster(true);
    }

}
