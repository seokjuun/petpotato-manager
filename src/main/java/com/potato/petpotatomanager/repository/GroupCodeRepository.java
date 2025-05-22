package com.potato.petpotatomanager.repository;

import com.potato.petpotatomanager.entity.GroupCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupCodeRepository extends JpaRepository<GroupCode, String> {
}
