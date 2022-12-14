package com.claro.WSCarMaintence.model;

import java.io.Serializable;
import java.util.Objects;


public class MecanicoID implements Serializable{
	private static final long serialVersionUID = -5235196532556803317L;

	private String tipoDocumento;
	private Integer documento;

	public MecanicoID() {
	}

	public MecanicoID(String tipoDocumento, Integer documento) {
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		MecanicoID mecanicoId = (MecanicoID) obj;
		return tipoDocumento.equals(mecanicoId.tipoDocumento) && documento.equals(mecanicoId.documento);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoDocumento, documento);
	}
}