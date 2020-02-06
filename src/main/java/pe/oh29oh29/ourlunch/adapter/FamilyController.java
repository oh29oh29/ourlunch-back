package pe.oh29oh29.ourlunch.adapter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.FamilyCommandService;
import pe.oh29oh29.ourlunch.application.FamilyQueryService;
import pe.oh29oh29.ourlunch.application.value.FamilyRepresentation;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.model.Response;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyCommandService familyCommandService;
    private final FamilyQueryService familyQueryService;

    @ApiOperation(
            value = "점심팸 멤버 조회 API",
            notes = "점심팸 전체 멤버를 조회합니다."
    )
    @GetMapping("/{familyId}/members")
    public Response<FamilyRepresentation.GetMembers> getMembers(@PathVariable String familyId) {
        final List<Member> members = familyQueryService.getMembers(familyId);
        final List<FamilyRepresentation.GetMembers.Member> memberList = new ArrayList<>();
        for (Member member : members) {
            memberList.add(
                    FamilyRepresentation.GetMembers.Member
                            .builder()
                            .id(member.getId())
                            .name(member.getName())
                            .build()
            );
        }

        return new Response<>(
                FamilyRepresentation.GetMembers
                        .builder()
                        .members(memberList)
                        .build()
        );
    }
}
