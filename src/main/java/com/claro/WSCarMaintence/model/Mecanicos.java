package com.claro.WSCarMaintence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.ParameterMode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mecanicos", schema = "public")
@Getter
@Setter
@ToString
@IdClass(value = MecanicoID.class)
@NamedStoredProcedureQuery(name = "sp_crear_mecanico", 
procedureName = "public.sp_crear_mecanico", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_tipo_documento", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_documento", type = Integer.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_primer_nombre", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_segundo_nombre", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_primer_apellido", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_segundo_apellido", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_celular", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_direccion", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_email", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_estado", type = String.class)

})
public class Mecanicos implements Serializable {
	public Mecanicos(String string, int i, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9) {
		// TODO Auto-generated constructor stub
	}

	public Mecanicos() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -7618741732297408457L;

	@Id
	@Column(name = "tipo_documento", length = 2, nullable = false)
	private String tipoDocumento;

	@Id
	@Column(name = "documento", length = 11, nullable = false)
	private Integer documento;

	@Column(name = "primer_nombre", length = 30, nullable = false)
	private String primerNombre;

	@Column(name = "segundo_nombre", length = 30)
	private String segundoNombre;

	@Column(name = "primer_apellido", length = 30, nullable = false)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 30)
	private String segundoApellido;

	@Column(name = "celular", length = 10, nullable = false)
	private String celular;

	@Column(name = "direccion", length = 200, nullable = false)
	private String direccion;
	
	 
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "estado", length = 1, nullable = false)
	private String estado;

}

