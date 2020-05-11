package com.Yggdrasil.HelpMe.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Servico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@OneToOne
	private Cliente contratante;
	@OneToOne
	private Cliente contratado;
	private Calendar data;
	private Double valor;
	
	
	
	public Servico () {
	}

	public Servico(Integer id, Cliente contratante, Cliente contratado, Calendar data, Double valor) {
		super();
		Id = id;
		this.contratante = contratante;
		this.contratado = contratado;
		this.data = data;
		this.valor = valor;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Cliente getContratante() {
		return contratante;
	}

	public void setContratante(Cliente contratante) {
		this.contratante = contratante;
	}

	public Cliente getContratado() {
		return contratado;
	}

	public void setContratado(Cliente contratado) {
		this.contratado = contratado;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
	

}
