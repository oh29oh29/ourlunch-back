package pe.oh29oh29.ourlunch.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.ourlunch.application.FamilyCommandService;
import pe.oh29oh29.ourlunch.application.FamilyQueryService;
import pe.oh29oh29.ourlunch.application.value.FamilyCommand;
import pe.oh29oh29.ourlunch.application.value.FamilyRepresentation;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.model.Response;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/family")
public class FamilyController {

    private final FamilyQueryService familyQueryService;
    private final FamilyCommandService familyCommandService;

    /**
     * 점심팸 멤버 조회 API
     */
    @GetMapping("/{familyId}/members")
    public Response<FamilyRepresentation.GetMembers> getMembers(@PathVariable String familyId) {
        final List<Member> members = familyQueryService.getMembers(familyId);
        final List<FamilyRepresentation.GetMembers.Member> memberList =
                members.stream()
                        .map(member ->
                                FamilyRepresentation.GetMembers.Member
                                        .builder()
                                        .id(member.getId())
                                        .name(member.getName())
                                        .appetite(member.getAppetite())
                                        .build())
                        .collect(Collectors.toList());

        return new Response<>(
                FamilyRepresentation.GetMembers
                        .builder()
                        .members(memberList)
                        .build()
        );
    }

    /**
     * 점심팸 멤버 가입 API
     */
    @PostMapping("/join")
    public Response join(
            @Valid @RequestBody FamilyCommand.Join command,
            OAuth2AuthenticationToken authentication
    ) throws Exception {
        final OAuth2User user = authentication.getPrincipal();
        final String id = user.getName();

        familyCommandService.join(
                command.getFamilyCode(),
                id,
                command.getName(),
                command.getAppetite()
        );

        return Response.ok();
    }
}
