package com.mx.ApiRestMeseros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestMeseros.model.Mesero;
import com.mx.ApiRestMeseros.repository.MeserosRepository;

@Service
public class MeserosServiceImp {

	@Autowired
	MeserosRepository meserosRepo;

	@Transactional(readOnly = true)
	public List<Mesero> listar() {
		return meserosRepo.findAll();
	}

	@Transactional
	public String guardar(Mesero mesero) {
		String msg = "";
		for (Mesero m : meserosRepo.findAll()) {
			if (m.getIdMesero().equals(mesero.getIdMesero())) {
				msg = "Id de mesero repetido";
				break;
			}
			if (m.getNombre().equalsIgnoreCase(mesero.getNombre()) && m.getApm().equalsIgnoreCase(mesero.getApp())
					&& m.getApm().equalsIgnoreCase(mesero.getApm())) {
				msg = "Nombre del mesero repetido";
				break;
			}
		}
		if (msg.isEmpty())
			meserosRepo.save(mesero);
		return msg;
	}

	@Transactional(readOnly = true)
	public Mesero buscar(long id) {
		return meserosRepo.findById(id).orElse(null);
	}

	@Transactional
	public String editar(Mesero mesero) {
		String msg = "";
		for (Mesero m : meserosRepo.findAll()) {
			if (!m.getIdMesero().equals(mesero.getIdMesero())) {
				msg = "No existe un mesero con esa ID";
			}
		}
		if (msg.isEmpty())
			meserosRepo.save(mesero);
		return msg;
	}

	@Transactional
	public String eliminar(long id) {
		String msg = "";
		for (Mesero m : meserosRepo.findAll()) {
			if (!m.getIdMesero().equals(id)) {
				msg = "No existe un mesero con esa ID";
			}
		}
		if (msg.isEmpty())
			meserosRepo.deleteById(id);
		return msg;
	}
}
