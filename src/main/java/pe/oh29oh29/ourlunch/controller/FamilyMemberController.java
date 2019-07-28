package pe.oh29oh29.ourlunch.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.ourlunch.entity.FamilyMember;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.model.ResponseDTO;
import pe.oh29oh29.ourlunch.service.FamilyMemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/familyMember")
public class FamilyMemberController {

    private final FamilyMemberService familyMemberService;

    @ApiOperation(
            value = "점심팸 멤버 조회 API",
            notes = "점심팸 멤버를 조회합니다."
    )
    @GetMapping("")
    public ResponseDTO<List<FamilyMember>> getFamilyMembers(RequestDTO.FamilyMembersSelectRequest request) {
        return new ResponseDTO<>(familyMemberService.getFamilyMembers(request));
    }
}
