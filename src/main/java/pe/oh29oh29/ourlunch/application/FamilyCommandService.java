package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

import java.util.UUID;

@RequiredArgsConstructor

@Service
public class FamilyCommandService {

    private final FamilyRepository familyRepository;
    private final MemberRepository memberRepository;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    @Transactional
    public Family createFamily(final String userId,
                        final String companyName,
                        final String familyName) {

        final String linkUrl = generateFamilyLinkUrl();

        final Family family = familyRepository.save(
                Family.of(
                        Company.of(companyName),
                        familyName,
                        linkUrl
                )
        );

        // TODO 응답DTO로 변환해서 반환하자. 현재 형태는 업데이트가 일어난다.
        family.setLinkUrl(ourlunchUrl + family.getLinkUrl());

        // TODO 멤버를 여기서 수정하는게 맞는건지 고민.
        Member member = memberRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        member.setFamily(family);
        member.setMaster(true);

        return family;
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }

}
