package pe.oh29oh29.ourlunch.domain.family;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.domain.company.CompanyService;
import pe.oh29oh29.ourlunch.domain.family.dto.RequestDTO;
import pe.oh29oh29.ourlunch.domain.family.dto.ResponseDTO;
import pe.oh29oh29.ourlunch.domain.member.MemberService;
import pe.oh29oh29.ourlunch.model.Response;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;
    private final MemberService memberService;
    private final CompanyService companyService;

    @ApiOperation(
            value = "점심팸 생성 API",
            notes = "점심팸을 생성합니다."
    )
    @PostMapping
    public Response<ResponseDTO.Creation> createFamily(@RequestBody final RequestDTO.Creation request) {
        final Family family = familyService.createFamily(request.getCompanyName(), request.getFamilyName());
        return new Response<>(
                ResponseDTO.Creation
                        .builder()
                        .linkUrl(family.getLinkUrl())
                        .build()
        );
    }

    @ApiOperation(
            value = "점심팸 멤버 참여 API",
            notes = "점심팸에 멤버로 참여합니다."
    )
    @PostMapping("/member")
    public Response<ResponseDTO.Join> joinFamily(@RequestBody final RequestDTO.Join request) {

        memberService.joinFamily();

        return new Response<>(
                ResponseDTO.Join
                        .builder()
                        .build()
        );
    }
}
