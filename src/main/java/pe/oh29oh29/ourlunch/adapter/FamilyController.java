package pe.oh29oh29.ourlunch.adapter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.FamilyCommandService;
import pe.oh29oh29.ourlunch.application.value.FamilyCommand;
import pe.oh29oh29.ourlunch.application.value.FamilyRepresentation;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.model.Response;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyCommandService familyCommandService;

    @ApiOperation(
            value = "점심팸 생성 API",
            notes = "점심팸을 생성합니다."
    )
    @PostMapping
    public Response<FamilyRepresentation.Creations> createFamily(
            @RequestBody final FamilyCommand.Creation command,
            @ApiIgnore final OAuth2AuthenticationToken authentication
    ) {
//        final String userId = authentication.getPrincipal().getName();  // Production
        final String userId = "1";  // Test

        final Family family = familyCommandService.createFamily(
                userId,
                command.getCompanyName(),
                command.getFamilyName()
        );

        return new Response<>(
                FamilyRepresentation.Creations
                        .builder()
                        .linkUrl(family.getLinkUrl())
                        .build()
        );
    }


}
