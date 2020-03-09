package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

@RequiredArgsConstructor

@Service
public class MemberQueryService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member findById(String id) {
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public boolean exist(String id) {
        return memberRepository.findById(id).isPresent();
    }
}
