package com.potato.petpotatomanager.dto;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class GroupCodeFilterResultDto {
    private String result;
    private List<GroupCodeFilterDto> groupCodeFilterList;
}
