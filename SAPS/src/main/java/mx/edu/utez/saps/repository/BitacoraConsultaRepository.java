package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.BitacoraConsultaEntity;

@Repository
public interface BitacoraConsultaRepository extends JpaRepository<BitacoraConsultaEntity, Integer>{
	
	BitacoraConsultaEntity findByIdBitacoraConsulta(int idBitacoraConsulta);
	List<BitacoraConsultaEntity> findAllByConsulta_Solicitud_Solicitante_Usuario_IdUsuario(int idUsuario);

}
