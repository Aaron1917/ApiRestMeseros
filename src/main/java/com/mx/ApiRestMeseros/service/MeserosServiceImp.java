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
				msg += "Id de mesero repetido";
			}
			if (m.getNombre().equalsIgnoreCase(mesero.getNombre()) &&
				m.getApp().equalsIgnoreCase(mesero.getApp()) &&
				m.getApm().equalsIgnoreCase(mesero.getApm())) {
				msg += " Nombre de mesero repetido";
			}
			if (!msg.isEmpty())
				break;
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
		String msg = "Id de mesero no encontrada";
		for (Mesero m : meserosRepo.findAll()) {
			if (m.getIdMesero().equals(mesero.getIdMesero())) {
				msg = "";
				break;
			}
		}
		if (msg.isEmpty())
			meserosRepo.save(mesero);
		return msg;
	}

	@Transactional
	public String eliminar(long id) {
		String msg = "No existe un mesero con esa ID";
		for (Mesero m : meserosRepo.findAll()) {
			if (m.getIdMesero().equals(id)) {
				msg = "";
				break;
			}
		}
		if (msg.isEmpty())
			meserosRepo.deleteById(id);
		return msg;
	}
}
