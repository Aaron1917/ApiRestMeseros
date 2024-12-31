package com.mx.ApiRestMeseros.model;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 
 * CREATE TABLE MESERO(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(70) NOT NULL,
APP VARCHAR2(70) NOT NULL,
APM VARCHAR2(70),
SUELDO NUMBER NOT NULL);
 * */

@Entity
@Table(name = "MESERO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mesero {

	@Id
	@Column(name = "ID")
	private Long idMesero;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APP")
	private String app;
	
	@Column(name = "APM")
	private String apm;
	
	@Column(name = "SUELDO")
	private Double sueldo;
	
	//Cardinalidad
	@OneToMany(mappedBy = "mesero", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Mesas> lista = new ArrayList<>(); 
}