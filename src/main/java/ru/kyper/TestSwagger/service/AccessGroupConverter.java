package ru.kyper.TestSwagger.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.ObjectNode;
import ru.kyper.TestSwagger.dto.AccessGroupVO;
import ru.kyper.TestSwagger.entity.AccessGroup;

public class AccessGroupConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static AccessGroup convertVOtoDAO(AccessGroupVO vo) {
        AccessGroup dao = new AccessGroup();
        updateDAOfromVO(vo, dao);
        return dao;
    }

    public static void updateDAOfromVO(AccessGroupVO vo, AccessGroup dao) {
        dao.setCaption(vo.getCaption());
        dao.setCode(vo.getCode());
        dao.setAccessType(vo.getAccessType());
        dao.setCrmSettings(vo.getCrmSettings().toString());
    }

    public static AccessGroupVO convertDAOtoVO(AccessGroup dao) {
        AccessGroupVO vo = new AccessGroupVO();
        vo.setId(dao.getId());
        vo.setActive(dao.isActive());
        vo.setCaption(dao.getCaption());
        vo.setCode(dao.getCode());
        vo.setAccessType(dao.getAccessType());
        try {
            vo.setCrmSettings(objectMapper.readTree(dao.getCrmSettings()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        AccessGroup parent = dao.getParent();
        if(parent != null) {
            vo.setParentId(parent.getId());
            vo.setParentCaption(parent.getCaption());
        }

        return vo;
    }

}
