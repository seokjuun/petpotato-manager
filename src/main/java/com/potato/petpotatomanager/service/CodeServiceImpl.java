package com.potato.petpotatomanager.service;

import com.potato.petpotatomanager.dto.CodeDto;
import com.potato.petpotatomanager.dto.CodeResultDto;
import com.potato.petpotatomanager.entity.Code;
import com.potato.petpotatomanager.entity.key.CodeKey;
import com.potato.petpotatomanager.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;

    @Override
    public CodeResultDto insertCode(Code code) {
        CodeResultDto codeResultDto = new CodeResultDto();
        try {
            codeRepository.save(code);
            codeResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            codeResultDto.setResult("fail");
        }
        return codeResultDto;
    }

    @Override
    public CodeResultDto updateCode(Code code) {
        CodeResultDto codeResultDto = new CodeResultDto();
        try {
            codeRepository.save(code);
            codeResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            codeResultDto.setResult("fail");
        }
        return codeResultDto;
    }

    @Override
    public CodeResultDto deleteCode(CodeKey codeKey) {
        CodeResultDto codeResultDto = new CodeResultDto();
        try {
            codeRepository.deleteById(codeKey);
            codeResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            codeResultDto.setResult("fail");
        }
        return codeResultDto;
    }

    @Override
    public CodeResultDto getCodes(String groupCode, int pageNumber, int pageSize) {
        CodeResultDto codeResultDto = new CodeResultDto();
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<Code> page = codeRepository.findByGroupCode(groupCode,pageable);
            List<CodeDto> CodeDtoList = new ArrayList<>();

            // PageGroupCode -> List<GroupCode>
            page.toList().forEach(code -> CodeDtoList.add(CodeDto.fromCode(code)));
            codeResultDto.setCodeDtoList(CodeDtoList);

            // count
            Long count = codeRepository.count();
            codeResultDto.setCount(count);
            codeResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            codeResultDto.setResult("fail");
        }
        return codeResultDto;
    }

    @Override
    public CodeResultDto detailCode(CodeKey codeKey) {
        CodeResultDto codeResultDto = new CodeResultDto();
        try {
            Optional<Code> CodeOptional = codeRepository.findById(codeKey);

            CodeOptional.ifPresentOrElse(
                    detailCode -> {
                        codeResultDto.setCodeDto(CodeDto.fromCode(detailCode));
                        codeResultDto.setResult("success");
                    },
                    () -> codeResultDto.setResult("fail")
            );
        } catch (Exception e) {
            e.printStackTrace();
            codeResultDto.setResult("fail");
        }
        return codeResultDto;
    }

    @Override
    public CodeResultDto countCode() {
        CodeResultDto codeResultDto = new CodeResultDto();
        try {
            Long count = codeRepository.count();
            codeResultDto.setCount(count);
            codeResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            codeResultDto.setResult("fail");
        }
        return codeResultDto;
    }
}
