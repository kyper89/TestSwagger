package ru.kyper.TestSwagger.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "access_group")
public class AccessGroup {

	@Id
	@GeneratedValue(generator = "access_group_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "access_group_seq")
	private Long id;

	@Column
	private boolean active;

	@Column
	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", referencedColumnName="id")
	private AccessGroup parent;

	@Column(nullable = false)
	private String caption;

	@Column
	private String crmSettings;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AccessType accessType;


}
