package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.NivelEntity;


@Repository
public interface NivelRepository extends JpaRepository<NivelEntity, Integer> {
	NivelRepository findByNivel(int idNivel);
}
