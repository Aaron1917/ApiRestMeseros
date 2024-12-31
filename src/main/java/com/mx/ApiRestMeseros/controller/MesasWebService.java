package com.mx.ApiRestMeseros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestMeseros.model.Mesas;
import com.mx.ApiRestMeseros.service.MesasServiceImp;

@RestController
@RequestMapping(path = "MesasWebService")
@CrossOrigin
public class MesasWebService {

	@Autowired
	MesasServiceImp imp;

	// http://localhost:9000/MesasWebService/listar
	@GetMapping(path = "listar")
	public List<Mesas> listar() {
		return imp.listar();
	}

	// http://localhost:9000/MesasWebService/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Mesas mesa) {
		String res = imp.guardar(mesa);
		if (res.isEmpty())
			return new ResponseEntity<>(mesa, HttpStatus.CREATED);
		return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
	}

	// http://localhost:9000/MesasWebService/buscar
	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Mesas mesa) {
		Mesas m = imp.buscar(mesa.getIdMesa());
		if (m != null)
			return new ResponseEntity<>(m, HttpStatus.OK);
		return new ResponseEntity<>("Mesa no encontrada", HttpStatus.NOT_FOUND);
	}

	// http://localhost:9000/MesasWebService/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Mesas mesa) {
		String res = imp.editar(mesa);
		if (res.isEmpty())
			return new ResponseEntity<>(mesa, HttpStatus.OK);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	// http://localhost:9000/MesasWebService/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Mesas mesa) {
		String res = imp.eliminar(mesa.getIdMesa());
		if (res.isEmpty())
			return new ResponseEntity<>("Mesa eliminada", HttpStatus.OK);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
}
