package pe.oh29oh29.ourlunch.domain.family;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.domain.company.CompanyService;
import pe.oh29oh29.ourlunch.domain.member.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;
    private final MemberService memberService;
    private final CompanyService companyService;

    @ApiOperation(
            value = "점심팸 생성 API",
            notes = "점심팸을 생성합니다."
    )
    @PostMapping("")
    public FamilyDTO.Creation.Res createFamily(@RequestBody FamilyDTO.Creation.Req request) {
        return FamilyDTO.Creation.Res.builder().build();
    }

    @ApiOperation(
            value = "점심팸 멤버 참여 API",
            notes = "점심팸에 멤버로 참여합니다."
    )
    @PostMapping("/member")
    public FamilyDTO.Join.Res joinFamily(@RequestBody FamilyDTO.Join.Req request) {
        memberService.joinFamily();
        return FamilyDTO.Join.Res.builder().build();
    }
}
