package com.mx.ApiRestMeseros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestMeseros.model.Mesero;
import com.mx.ApiRestMeseros.service.MeserosServiceImp;

@RestController
@RequestMapping(path = "MeserosWebService")
@CrossOrigin
public class MeserosWebService {

	@Autowired
	MeserosServiceImp imp;

	// http://localhost:9000/MeserosWebService/listar
	@GetMapping(path = "listar")
	public List<Mesero> listar() {
		return imp.listar();
	}

	// http://localhost:9000/MeserosWebService/guardar
	@GetMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Mesero mesero) {
		String res = imp.guardar(mesero);
		if (res.isEmpty())
			return new ResponseEntity<>(mesero, HttpStatus.CREATED);
		return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
	}

	// http://localhost:9000/MeserosWebService/buscar
	@GetMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Mesero mesero) {
		Mesero m = imp.buscar(mesero.getIdMesero());
		if (m != null)
			return new ResponseEntity<>(m, HttpStatus.CREATED);
		return new ResponseEntity<>("Mesero no encontrado", HttpStatus.NOT_FOUND);
	}

	// http://localhost:9000/MeserosWebService/editar
	@GetMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Mesero mesero) {
		String res = imp.editar(mesero);
		if (res.isEmpty())
			return new ResponseEntity<>(mesero, HttpStatus.CREATED);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
	
	// http://localhost:9000/MeserosWebService/eliminar
	@GetMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Mesero mesero) {
		String res = imp.eliminar(mesero.getIdMesero());
		if (res.isEmpty())
			return new ResponseEntity<>(mesero, HttpStatus.CREATED);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
}
