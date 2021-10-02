package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.SintomaEntity;
import mx.edu.utez.saps.repository.SintomaRepository;


@Service
@Transactional
public class SintomaService {
	
	@Autowired
	private SintomaRepository sintomaRepository;
	
	public boolean saveSintoma(SintomaEntity sintoma) {
		return sintomaRepository.existsById(sintomaRepository.save(sintoma).getIdSintoma());
	}
	
	public boolean deleteSintoma(int idSintoma) {
		sintomaRepository.deleteById(idSintoma);
		return !sintomaRepository.existsById(idSintoma);
	}
	
	public List<SintomaEntity> getSintomas(){
		return sintomaRepository.findAll();
	}
	
	public SintomaEntity getSintoma(int idSintoma) {
		return sintomaRepository.findByIdSintoma(idSintoma);
	}
}
