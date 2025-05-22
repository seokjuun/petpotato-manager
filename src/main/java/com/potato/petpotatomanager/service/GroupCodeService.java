package com.potato.petpotatomanager.service;

import com.potato.petpotatomanager.dto.CodeResultDto;
import com.potato.petpotatomanager.dto.GroupCodeFilterDto;
import com.potato.petpotatomanager.dto.GroupCodeFilterResultDto;
import com.potato.petpotatomanager.entity.GroupCode;

public interface GroupCodeService {
    CodeResultDto insertGroupCode(GroupCode groupCode);
    CodeResultDto updateGroupCode(GroupCode groupCode);
    CodeResultDto deleteGroupCode(String groupCode);

    CodeResultDto listGroupCode(int pageNumber, int pageSize);
    CodeResultDto detailGroupCode(String groupCode);
    CodeResultDto countGroupCode();

    CodeResultDto toggleGroupCodeStatus(String groupCode);
    GroupCodeFilterResultDto getGroupCodesFilter();

}
