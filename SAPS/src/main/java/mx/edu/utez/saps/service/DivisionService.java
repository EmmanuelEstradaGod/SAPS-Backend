package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.DivisionEntity;
import mx.edu.utez.saps.repository.DivisionRepository;

@Service
@Transactional
public class DivisionService {
	@Autowired
	private DivisionRepository divisionRepository;
	
	public boolean saveDivision(DivisionEntity division) {
		return divisionRepository.existsById(divisionRepository.save(division).getIdDivision());
	}
	
	public boolean deleteDivision(int idDivision) {
		divisionRepository.deleteById(idDivision);
		return !divisionRepository.existsById(idDivision);
	}
	
	public List<DivisionEntity> getDivisiones() {
		return divisionRepository.findAll();
	}
	
	public DivisionEntity getDivision(int idDivision) {
		return divisionRepository.findByIdDivision(idDivision);
	}
}
