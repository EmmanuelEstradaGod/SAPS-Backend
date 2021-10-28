package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.SolicitudAdministrativoEntity;

@Repository
public interface SolicitudAdmnistrativoRepository extends JpaRepository<SolicitudAdministrativoEntity, Integer>{
	SolicitudAdministrativoEntity findByIdSolicitudAdministrativo(int idSolicitudAdministrativo);
}
