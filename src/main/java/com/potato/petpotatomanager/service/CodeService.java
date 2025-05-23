package com.potato.petpotatomanager.service;

import com.potato.petpotatomanager.dto.CodeResultDto;
import com.potato.petpotatomanager.entity.Code;
import com.potato.petpotatomanager.entity.key.CodeKey;

public interface CodeService {
    CodeResultDto insertCode(Code code);
    CodeResultDto updateCode(Code code);
    CodeResultDto deleteCode(CodeKey codeKey);

    CodeResultDto getCodesByGroupCode(String groupCode, int pageNumber, int pageSize);
    CodeResultDto getCodes(int pageNumber, int pageSize);
    CodeResultDto detailCode(CodeKey codeKey);
    CodeResultDto countCode();
    CodeResultDto updateCodeStatus(CodeKey codeKey, int isActive);
}
