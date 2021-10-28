package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.SolicitudEntity;

@Repository
public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Integer>{
	SolicitudEntity findByIdSolicitud(int idSolicitud);
	List<SolicitudEntity> findAllBySolicitante_Usuario_IdUsuario(int idUsuario);
	List<SolicitudEntity> findAllByStatus(boolean status);
}
