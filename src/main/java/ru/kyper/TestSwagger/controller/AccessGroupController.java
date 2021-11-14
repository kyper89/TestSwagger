package ru.kyper.TestSwagger.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kyper.TestSwagger.dto.AccessGroupVO;
import ru.kyper.TestSwagger.entity.CodeUnique;
import ru.kyper.TestSwagger.service.AccessGroupService;

import java.util.List;

@Api(value = "Ресурс для работы с группами доступа, версия 2")
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("accessGroup/v2")
public class AccessGroupController {

    private final AccessGroupService accessGroupService;

    @ApiOperation(value = "Создание группы доступа")
    @CodeUnique
    @PostMapping
    public void create(
            @RequestParam(required = false) Long parentId,
            @RequestBody @Validated AccessGroupVO vo,
            @RequestParam(required = false)  boolean overrideDuplicate) {
        accessGroupService.add(vo, parentId);
    }

    @ApiOperation(value = "Получение группы доступа")
    @GetMapping("/{id}")
    public AccessGroupVO read(@PathVariable("id") Long id) {
        return accessGroupService.findById(id);
    }

    @ApiOperation(value = "Получение списка групп доступа")
    @GetMapping
    public List<AccessGroupVO> readAll() {
        return accessGroupService.findAll();
    }

}
