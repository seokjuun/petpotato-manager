package com.potato.petpotatomanager.repository;

import com.potato.petpotatomanager.dto.GroupCodeFilterDto;
import com.potato.petpotatomanager.entity.Code;
import com.potato.petpotatomanager.entity.GroupCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupCodeRepository extends JpaRepository<GroupCode, String> {
    @Query("SELECT new com.potato.petpotatomanager.dto.GroupCodeFilterDto(gc.groupCode, gc.groupCodeName) " +
            "FROM GroupCode gc WHERE gc.isActive = 1")
    List<GroupCodeFilterDto> findAllForFilter();
}
