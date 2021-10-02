package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.SintomaEntity;

@Repository
public interface SintomaRepository extends JpaRepository<SintomaEntity, Integer> {
	SintomaEntity findByIdSintoma(int idSintoma);
}
