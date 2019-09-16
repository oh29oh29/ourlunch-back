package pe.oh29oh29.ourlunch.domain.member;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.domain.member.dto.RequestDTO;
import pe.oh29oh29.ourlunch.domain.member.dto.ResponseDTO;
import pe.oh29oh29.ourlunch.model.Response;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(
            value = "점심팸 멤버 참여 API",
            notes = "점심팸에 멤버로 참여합니다."
    )
    @PostMapping("/family")
    public Response<ResponseDTO.Join> joinFamily(@RequestBody final RequestDTO.Join request,
                                                 @ApiIgnore final OAuth2AuthenticationToken authentication) {

//        final String userId = authentication.getPrincipal().getName();  // Production
        final String userId = "1";  // Test


        return new Response<>(
                ResponseDTO.Join
                        .builder()
                        .build()
        );
    }

}
