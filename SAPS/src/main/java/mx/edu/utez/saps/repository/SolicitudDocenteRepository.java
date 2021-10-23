package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.SolicitudDocenteEntity;

@Repository
public interface SolicitudDocenteRepository extends JpaRepository<SolicitudDocenteEntity, Integer>{
	SolicitudDocenteEntity findByIdSolicitudDocente(int idSolicitudDocente);
}
