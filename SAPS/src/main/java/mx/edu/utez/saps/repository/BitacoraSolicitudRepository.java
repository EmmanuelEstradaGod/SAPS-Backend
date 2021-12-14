package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;

@Repository
public interface BitacoraSolicitudRepository extends JpaRepository<BitacoraSolicitudEntity, Integer>{
	
	BitacoraSolicitudEntity findByIdBitacoraSolicitud(int idBitacoraSolicitud);

}
