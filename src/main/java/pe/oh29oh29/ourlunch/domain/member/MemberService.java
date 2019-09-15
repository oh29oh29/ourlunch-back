package pe.oh29oh29.ourlunch.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void joinFamily() {
    }

    boolean exist(final String id) {

        return memberRepository.findById(id).isPresent();
    }

    Member signUp(final String id, final String nickName) {

        return memberRepository.save(Member.of(id, nickName));
    }

    Member getById(final String id) {

        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
