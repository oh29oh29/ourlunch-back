package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

@RequiredArgsConstructor

@Service
public class MemberCommandService {

    private final MemberRepository memberRepository;

    public void joinFamily(final String userId, final Family family) {
        final Member member = findById(userId);
        member.setFamily(family);
    }

    public boolean exist(final String id) {

        return memberRepository.findById(id).isPresent();
    }

    public Member signUp(final String id, final String nickName) {

        return memberRepository.save(Member.of(id, nickName));
    }

    public Member findById(final String id) {

        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
