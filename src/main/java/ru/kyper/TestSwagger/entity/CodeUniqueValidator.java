package ru.kyper.TestSwagger.entity;

import lombok.RequiredArgsConstructor;
import ru.kyper.TestSwagger.dto.AccessGroupVO;
import ru.kyper.TestSwagger.repository.AccessGroupRepository;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@RequiredArgsConstructor
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CodeUniqueValidator implements ConstraintValidator<CodeUnique, Object[]> {

	private final AccessGroupRepository repository;

	@Override
	public void initialize(CodeUnique constraintAnnotation) {}

	@Override
	public boolean isValid(Object[] values, ConstraintValidatorContext context) {

		if (values == null
				|| values.length < 3
				|| !(values[1] instanceof AccessGroupVO)
				|| !(values[2] instanceof Boolean)) {
			return true;
		}

		boolean overrideDuplicate = (boolean) values[2];
		if (overrideDuplicate) {
			return true;
		}

		Long id = values[0] instanceof Long ? (Long) values[0] : 0L;
		String code = ((AccessGroupVO) values[1]).getCode();
		return repository.findAllByCodeAndActiveTrueAndIdNot(code, id).isEmpty();
	}
}