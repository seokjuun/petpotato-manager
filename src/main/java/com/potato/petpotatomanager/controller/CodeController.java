package com.potato.petpotatomanager.controller;

import com.potato.petpotatomanager.dto.CodeResultDto;
import com.potato.petpotatomanager.entity.Code;
import com.potato.petpotatomanager.entity.key.CodeKey;
import com.potato.petpotatomanager.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/codes")
public class CodeController {
    private final CodeService codeService;

    @GetMapping("/")
    public CodeResultDto getCodes(
            @RequestParam("groupCode") String groupCode,
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pageSize") int pageSize
    ) {
        return codeService.getCodes(groupCode,pageNumber, pageSize);
    }

    @GetMapping("/{groupCode}/{code}")
    public CodeResultDto detailCode(
            @PathVariable("groupCode") String groupCode,
            @PathVariable("code") String code
    ) {
        CodeKey codeKey = new CodeKey(groupCode,code);
        return codeService.detailCode(codeKey);
    }

    @PostMapping("/")
    public CodeResultDto insertCode(
            // Code 는 key 부분이 CodeKey 로 되어 있어서 바로 받지 못하고 분리해서 받는데 필수이므로
            // 아래 두 항목이 누락되지 않도록
            @RequestParam("groupCode") String groupCode,
            @RequestParam("code") String code,
            @RequestParam("codeName") String codeName,
            @RequestParam("codeNameBrief") String codeNameBrief,
            @RequestParam("orderNo") int orderNo
    ) {
        CodeKey codeKey = new CodeKey(groupCode, code);
        Code codeEntity = new Code();
        codeEntity.setCodeKey(codeKey);
        codeEntity.setCodeName(codeName);
        codeEntity.setCodeNameBrief(codeNameBrief);
        codeEntity.setOrderNo(orderNo);
        return codeService.insertCode(codeEntity);
    }

    @PutMapping("/")
    public CodeResultDto updateCode(
            @RequestParam("groupCode") String groupCode,
            @RequestParam("code") String code,
            Code codeParam
            ) {
        CodeKey codeKey = new CodeKey(groupCode,code);
        codeParam.setCodeKey(codeKey);
        return codeService.updateCode(codeParam);
    }

    @DeleteMapping("/{groupCode}/{code}")
    public CodeResultDto deleteCode(
            @PathVariable("groupCode") String groupCode,
            @PathVariable("code") String code
    ) {
        CodeKey codeKey = new CodeKey(groupCode,code);
        return codeService.deleteCode(codeKey);
    }

    @GetMapping("/count")
    public CodeResultDto countCode() {
        return codeService.countCode();
    }
}
