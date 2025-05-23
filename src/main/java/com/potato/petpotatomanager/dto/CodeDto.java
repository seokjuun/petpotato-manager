package com.potato.petpotatomanager.dto;

import com.potato.petpotatomanager.entity.Code;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CodeDto {
    private String groupCode;
    public String code;
    private String codeName;
    private String codeNameBrief;
    private int orderNo;
    private int isActive;

    public static CodeDto fromCode(Code code){
        return CodeDto.builder()
                .groupCode(code.getCodeKey().getGroupCode())
                .code(code.getCodeKey().getCode())
                .codeName(code.getCodeName())
                .codeNameBrief(code.getCodeNameBrief())
                .orderNo(code.getOrderNo())
                .isActive(code.getIsActive())
                .build();
    }
}
