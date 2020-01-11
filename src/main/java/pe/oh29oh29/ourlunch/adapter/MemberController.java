package pe.oh29oh29.ourlunch.adapter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.MemberCommandService;
import pe.oh29oh29.ourlunch.application.value.MemberCommand;
import pe.oh29oh29.ourlunch.application.value.MemberRepresentation;
import pe.oh29oh29.ourlunch.model.Response;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @ApiOperation(
            value = "점심팸 멤버 참여 API",
            notes = "점심팸에 멤버로 참여합니다."
    )
    @PostMapping("/family")
    public Response<MemberRepresentation.Join> joinFamily(
            @RequestBody final MemberCommand.Join command,
            @ApiIgnore final OAuth2AuthenticationToken authentication
    ) {
        /*
        * TODO production code
        * final String userId = authentication.getPrincipal().getName();
        * */
        final String userId = "1";  // Test

        return new Response<>(
                MemberRepresentation.Join
                        .builder()
                        .build()
        );
    }

}
