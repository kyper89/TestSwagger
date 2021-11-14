package ru.kyper.TestSwagger.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kyper.TestSwagger.dto.AccessGroupVO;
import ru.kyper.TestSwagger.entity.AccessGroup;
import ru.kyper.TestSwagger.repository.AccessGroupRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class AccessGroupService {

    private final AccessGroupRepository accessGroupRepository;

    @Transactional
    public void add(AccessGroupVO vo, Long parentId) {
        AccessGroup accessGroup = AccessGroupConverter.convertVOtoDAO(vo);
        accessGroup.setActive(true);
        if (parentId != null) {
            accessGroup.setParent(getAccessGroup(parentId));
        }
        accessGroupRepository.saveAndFlush(accessGroup);

    }

    public AccessGroupVO findById(Long id) {
        AccessGroup accessGroup = getAccessGroup(id);
        return AccessGroupConverter.convertDAOtoVO(accessGroup);
    }


    public AccessGroup getAccessGroup(Long id) {
        return accessGroupRepository.findById(id).orElseThrow(() -> new AccessGroupNotFoundException(id));
    }

    public List<AccessGroupVO> findAll() {
        return accessGroupRepository.findAll().stream().map(AccessGroupConverter::convertDAOtoVO).collect(Collectors.toList());
    }
}
