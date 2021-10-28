package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.ConsultorEntity;

@Repository
public interface ConsultorRepository extends JpaRepository<ConsultorEntity, Integer>{
	ConsultorEntity findByIdConsultor(int idConsultor);
}
