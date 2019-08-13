package pe.oh29oh29.ourlunch.domain.family;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.model.ResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;

    @ApiOperation(
            value = "점심팸 생성 API",
            notes = "점심팸을 생성합니다."
    )
    @PostMapping("")
    public ResponseDTO<Family> createFamily(@RequestBody RequestDTO.FamilyCreationRequest request) {
        return new ResponseDTO<>(familyService.createFamily(request));
    }

    @ApiOperation(
            value = "점심팸 멤버 참여 API",
            notes = "점심팸에 멤버로 참여합니다."
    )
    @PostMapping("/member")
    public ResponseDTO joinFamily(@RequestBody RequestDTO.FamilyJoinRequest request) {
        familyService.joinFamily(request);
        return new ResponseDTO();
    }
}
