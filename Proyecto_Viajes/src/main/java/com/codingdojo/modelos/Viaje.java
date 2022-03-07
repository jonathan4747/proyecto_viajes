package com.codingdojo.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
@Entity
@Table (name="viajes")
public class Viaje {
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private long id;

	@Size(min=1,max=50,message="llenar el espacio")
	@NotNull
	private String nombregasto;
	
	@Size(min=1,max=50,message="llenar el espacio")
	@NotNull
	private String vendedor;
	
	
	@NotNull
	private long monto;
	
	@Size(min=5,max=500 ,message="descripcion debe de tener mas de 5 caracteres")
	@NotNull
	private String descripcion;
	
	public Viaje() {
	}

	public Viaje(String nombregasto, String vendedor, long monto, String descripcion) {
		
		this.nombregasto = nombregasto;
		this.vendedor = vendedor;
		this.monto = monto;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombregasto() {
		return nombregasto;
	}

	public void setNombregasto(String nombregasto) {
		this.nombregasto = nombregasto;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public long getMonto() {
		return monto;
	}

	public void setMonto(long monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
