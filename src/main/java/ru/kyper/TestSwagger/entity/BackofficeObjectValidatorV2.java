package ru.kyper.TestSwagger.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kyper.TestSwagger.dto.AccessGroupVO;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BackofficeObjectValidatorV2 implements ConstraintValidator<ValidatedBackofficeObjectV2, AccessGroupVO> {

	private final ObjectMapper mapper;

	@SneakyThrows
	@Override
	public boolean isValid(AccessGroupVO obj, ConstraintValidatorContext context) {

		context.disableDefaultConstraintViolation();

	//	mapper.createObjectNode().set("crmSettings", obj.getCrmSettings());
		context.buildConstraintViolationWithTemplate("message")
				.addPropertyNode("crmSettings")
				.addPropertyNode("elements")
		//		.addBeanNode()
		//			.inContainer( Map.class, 1 )
		//			.inIterable().atKey( "documentContactFullName" )
				.addConstraintViolation();
//		JsonNode jsonNode = mapper.valueToTree(obj);
//
//		if (jsonNode.has("crmSettings") && !jsonNode.get("crmSettings").isNull()) {
//
//			JsonNode crmSettingsNode = jsonNode.get("crmSettings");
//			String crmSettings = crmSettingsNode.asText();
//
//
//				crmSettingsNode = mapper.readTree(jsonNode.get("crmSettings").asText());
//
//
//		}
		return false;

	}
}
