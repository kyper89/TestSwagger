package ru.kyper.TestSwagger.dto;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.kyper.TestSwagger.entity.ValidatedBackofficeObjectV2;

import javax.persistence.AccessType;

@ApiModel
@Data
@EqualsAndHashCode(callSuper=false, of = "id")
@NoArgsConstructor
@ValidatedBackofficeObjectV2
public class AccessGroupVO {

    @ApiModelProperty(value = "Идентификатор в системе", readOnly = true)
    private Long id;

    @ApiModelProperty(value = "Признак активности записи", readOnly = true)
    private boolean active;

    @ApiModelProperty(value = "Наименование группы доступа")
    private String caption;

    @ApiModelProperty(value = "Код")
    private String code;

    @ApiModelProperty(value = "Тип доступа")
    private AccessType accessType;

    @ApiModelProperty(value = "Настройки crm")
    private JsonNode crmSettings;

    @ApiModelProperty(value = "Вышестоящая группа доступа", readOnly = true)
    private Long parentId;

    @ApiModelProperty(value = "Вышестоящая группа доступа (для отображения)", readOnly = true)
    private String parentCaption;

}
