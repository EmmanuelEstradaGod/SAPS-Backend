package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;

public interface BitacoraSolicitudRepository extends JpaRepository<BitacoraSolicitudEntity, Integer>{
	BitacoraSolicitudEntity findByIdBitacoraSolicitud(int idBitacoraSolicitud);
}