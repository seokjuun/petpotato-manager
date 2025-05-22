package com.potato.petpotatomanager.entity;

import com.potato.petpotatomanager.entity.key.CodeKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class Code {

    @EmbeddedId
    private CodeKey codeKey;

    @Column(name="code_name")
    private String codeName;

    @Column(name="code_name_brief")
    private String codeNameBrief; // 약어

    @Column(name="order_no")
    private int orderNo;

    @Column(name="is_active") // 1 활성화, 0 비활성화
    @ColumnDefault("1")
    private int isActive;
}
