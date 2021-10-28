package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.SolicitudEstudianteEntity;

@Repository
public interface SolicitudEstudianteRepository extends JpaRepository<SolicitudEstudianteEntity, Integer>{

	SolicitudEstudianteEntity findByIdSolicitudEstudiante(int idSolicitudEstudiante);
	SolicitudEstudianteEntity findByMatricula(String matricula);
	List<SolicitudEstudianteEntity> findAllByStatus(boolean status);
}
