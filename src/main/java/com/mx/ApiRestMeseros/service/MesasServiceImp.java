package com.mx.ApiRestMeseros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestMeseros.model.Mesas;
import com.mx.ApiRestMeseros.repository.MesasRepository;

@Service
public class MesasServiceImp {

	@Autowired
	MesasRepository mesasRepo;

	@Autowired
	MeserosServiceImp meserosImp;

	@Transactional(readOnly = true)
	public List<Mesas> listar() {
		return mesasRepo.findAll();
	}

	@Transactional
	public String guardar(Mesas mesa){
		String msg = "";
		if(meserosImp.buscar(mesa.getMesero().getIdMesero()) == null)
			msg += "El ID mesero no existe";
			
		for (Mesas m: mesasRepo.findAll()) {
			if (m.getIdMesa().equals(mesa.getIdMesa()))
				msg += " El ID de mesa se repite";
			if (m.getNumMesa().equals(mesa.getNumMesa()))
				msg += " El numero de mesa se repite";
			if (!msg.equals("El ID mesero no existe") && !msg.isEmpty())
				break;
		}
		if (msg.isEmpty())
			mesasRepo.save(mesa);
		return msg;
	}
	
	@Transactional(readOnly = true)
	public Mesas buscar(Long id) {
		return mesasRepo.findById(id).orElse(null);
	}
	
	@Transactional
	public String editar(Mesas mesa){
		String msg = "";
		if(meserosImp.buscar(mesa.getMesero().getIdMesero()) == null)
			msg += "El ID mesero no existe";
			
		for (Mesas m: mesasRepo.findAll()) {
			if (m.getIdMesa().equals(mesa.getIdMesa()))
				msg += " El ID de mesa se repite";
			if (!msg.equals("El ID mesero no existe") && !msg.isEmpty())
				break;
		}
		if (msg.isEmpty())
			mesasRepo.save(mesa);
		return msg;
	}
	
	@Transactional
	public String eliminar(Long id){
		String msg = "";
			
		for (Mesas m: mesasRepo.findAll()) {
			if (m.getIdMesa().equals(id))
				msg += " El ID de mesa se repite"; break;
		}
		if (msg.isEmpty())
			mesasRepo.deleteById(id);
		return msg;
	}
}
