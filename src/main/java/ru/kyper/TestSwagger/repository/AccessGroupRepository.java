package ru.kyper.TestSwagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.kyper.TestSwagger.entity.AccessGroup;

import java.util.List;

@Repository
public interface AccessGroupRepository extends JpaRepository<AccessGroup, Long>, JpaSpecificationExecutor<AccessGroup> {
    List<AccessGroup> findAllByCodeAndActiveTrueAndIdNot(String code, Long id);
}
