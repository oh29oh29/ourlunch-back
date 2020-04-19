package pe.oh29oh29.ourlunch.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.ourlunch.application.FamilyCommandService;
import pe.oh29oh29.ourlunch.application.FamilyQueryService;
import pe.oh29oh29.ourlunch.application.InitialRegistrationFacade;
import pe.oh29oh29.ourlunch.application.value.FamilyCommand;
import pe.oh29oh29.ourlunch.application.value.FamilyRepresentation;
import pe.oh29oh29.ourlunch.domain.family.Family;
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
    private final InitialRegistrationFacade initialRegistrationFacade;

    /**
     * 점심팽 생성 API
     */
    @PostMapping
    public Response<FamilyRepresentation.Create> create(
            OAuth2AuthenticationToken authentication,
            @Valid @RequestBody FamilyCommand.Create command
    ) {
        final String userId = authentication.getPrincipal().getName();
        final Family family = initialRegistrationFacade.regist(
                userId,
                command.getUserName(),
                command.getAppetite(),
                command.getCompanyName(),
                command.getFamilyName()
        );

        return new Response<>(
                FamilyRepresentation.Create
                        .builder()
                        .family(
                                FamilyRepresentation.Create.Family
                                        .builder()
                                        .id(family.getId())
                                        .name(family.getName())
                                        .code(family.getCode())
                                        .build()
                        )
                        .build()
        );
    }

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
            OAuth2AuthenticationToken authentication,
            @Valid @RequestBody FamilyCommand.Join command
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

    /**
     * 점심팸 조회 API
     */
    @GetMapping("/{code}")
    public Response<FamilyRepresentation.GetFamily> getFamily(@PathVariable String code) {
        final Family family = familyQueryService.getFamily(code);

        return new Response<>(
                FamilyRepresentation.GetFamily
                        .builder()
                        .id(family.getId())
                        .name(family.getName())
                        .build()
        );
    }
}
