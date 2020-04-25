package com.example.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String none;
	private Double preco;
	
	@ManyToMany
	@JoinTable(name= "PRODUTO_CATEGORIA",
	joinColumns = @JoinColumn(name="produto_id"),
	inverseJoinColumns = @JoinColumn (name="categoria_id")			)
	private List<Categoria> categorias = new ArrayList<>();
		
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Produto(Integer id, String none, Double preco) {
		super();
		this.id = id;
		this.none = none;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNone() {
		return none;
	}
	public void setNone(String none) {
		this.none = none;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", none=" + none + ", preco=" + preco + "]";
	}

	
	
}
