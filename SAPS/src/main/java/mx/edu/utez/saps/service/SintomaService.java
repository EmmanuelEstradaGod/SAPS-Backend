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
		SintomaEntity sintoma = sintomaRepository.findByIdSintoma(idSintoma);
		sintoma.setStatus(false);
		sintomaRepository.save(sintoma);
		return sintomaRepository.existsById(idSintoma);
	}
	
	public List<SintomaEntity> getSintomas(){
		return sintomaRepository.findAllByStatus(true);
	}
	
	public SintomaEntity getSintoma(int idSintoma) {
		return sintomaRepository.findByIdSintoma(idSintoma);
	}
}
