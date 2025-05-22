package com.potato.petpotatomanager.controller;


import com.potato.petpotatomanager.dto.CodeResultDto;
import com.potato.petpotatomanager.entity.GroupCode;
import com.potato.petpotatomanager.service.GroupCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group-codes")
public class GroupCodeController {
    private final GroupCodeService groupCodeService;

    @GetMapping
    public CodeResultDto listGroupCode(@RequestParam(value = "pageNumber", defaultValue = "0") int page,
                                       @RequestParam(value = "pageSize", defaultValue = "10") int size) {
        return groupCodeService.listGroupCode(page, size);
    }

    @GetMapping("/{groupCode}")
    public CodeResultDto detailGroupCode(@PathVariable("groupCode") String groupCode) {
        return groupCodeService.detailGroupCode(groupCode);
    }


    @PostMapping
    public CodeResultDto insertGroupCode( GroupCode groupCode) {
        return groupCodeService.insertGroupCode(groupCode);
    }

    @PutMapping
    public CodeResultDto updateGroupCode( GroupCode groupCode) {
        return groupCodeService.updateGroupCode(groupCode);
    }

    @DeleteMapping("/{groupCode}")
    public CodeResultDto deleteGroupCode(@PathVariable String groupCode) {
        return groupCodeService.deleteGroupCode(groupCode);
    }

    @GetMapping("/count")
    public CodeResultDto countGroupCode() {
        return groupCodeService.countGroupCode();
    }

    @PatchMapping("/{groupCode}/toggle")
    public CodeResultDto toggleGroupCodeStatus(@PathVariable String groupCode) {
        return groupCodeService.toggleGroupCodeStatus(groupCode);
    }
}
