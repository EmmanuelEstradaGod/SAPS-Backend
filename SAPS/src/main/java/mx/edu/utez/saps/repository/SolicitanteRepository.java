package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.SolicitanteEntity;

@Repository
public interface SolicitanteRepository extends JpaRepository<SolicitanteEntity, Integer>{
	SolicitanteEntity findByIdSolicitante(int idSolicitante);
	List<SolicitanteEntity> findAllByStatus(boolean status);
	List<SolicitanteEntity> findAllByUsuario_IdUsuario(int idUsuario);
}
