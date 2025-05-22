package com.potato.petpotatomanager.dto;

import com.potato.petpotatomanager.entity.GroupCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupCodeFilterDto {
    private String groupCode;
    private String groupCodeName;
}
