package pe.oh29oh29.ourlunch.domain.family;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.domain.family.dto.RequestDTO;
import pe.oh29oh29.ourlunch.domain.family.dto.ResponseDTO;
import pe.oh29oh29.ourlunch.model.Response;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;

    @ApiOperation(
            value = "점심팸 생성 API",
            notes = "점심팸을 생성합니다."
    )
    @PostMapping
    public Response<ResponseDTO.Creations> createFamily(@RequestBody final RequestDTO.Creation request,
                                                       @ApiIgnore final OAuth2AuthenticationToken authentication) {

//        final String userId = authentication.getPrincipal().getName();  // Production
        final String userId = "1";  // Test

        final Family family = familyService.createFamily(userId, request.getCompanyName(), request.getFamilyName());

        return new Response<>(
                ResponseDTO.Creations
                        .builder()
                        .linkUrl(family.getLinkUrl())
                        .build()
        );
    }


}
