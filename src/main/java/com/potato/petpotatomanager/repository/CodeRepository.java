package com.potato.petpotatomanager.repository;

import com.potato.petpotatomanager.entity.Code;
import com.potato.petpotatomanager.entity.key.CodeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CodeRepository extends JpaRepository<Code, CodeKey> {
    // Code 의 CRUD 외에
    // groupCode 기준 코드 조회 <- JPQL
    @Query("select c from Code c where c.codeKey.groupCode = :groupCode order by c.orderNo")
    Page<Code> findByGroupCode(@Param("groupCode") String groupCode, Pageable pageable);
}
