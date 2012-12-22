package br.com.projeto.hibernate.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormaDePagamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 218326925134514229L;
	@Override
	public String toString() {
		return "FormaDePagamento [id=" + id + ", vezes=" + vezes
				+ ", formaDePagamento=" + formaDePagamento + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((formaDePagamento == null) ? 0 : formaDePagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vezes == null) ? 0 : vezes.hashCode());
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
		FormaDePagamento other = (FormaDePagamento) obj;
		if (formaDePagamento == null) {
			if (other.formaDePagamento != null)
				return false;
		} else if (!formaDePagamento.equals(other.formaDePagamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vezes == null) {
			if (other.vezes != null)
				return false;
		} else if (!vezes.equals(other.vezes))
			return false;
		return true;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVezes() {
		return vezes;
	}
	public void setVezes(String vezes) {
		this.vezes = vezes;
	}
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	@Column(name = "vezes")
	private String vezes = "";
	@Column(name = "formaDePagamento")
	private String formaDePagamento = "";
	
	

}
