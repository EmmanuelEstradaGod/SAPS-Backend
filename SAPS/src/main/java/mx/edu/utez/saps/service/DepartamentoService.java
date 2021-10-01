package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.DepartamentoEntity;
import mx.edu.utez.saps.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public boolean saveDepartamento(DepartamentoEntity departamento) {
		return departamentoRepository.existsById(departamentoRepository.save(departamento).getIdDepartamento());
	}
	
	public boolean deleteDepartamento(int idDepartamento) {
		departamentoRepository.deleteById(idDepartamento);
		return !departamentoRepository.existsById(idDepartamento);
	}
	
	public List<DepartamentoEntity> getDepartamentos(){
		return departamentoRepository.findAll();
	}
	
	public DepartamentoEntity getDepartamento(int idDepartamento) {
		return (DepartamentoEntity) departamentoRepository.findByDepartamento(idDepartamento);
	}
}
