package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.ConsultaEntity;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Integer>{
	ConsultaEntity findByIdConsulta(int idConsulta);
	List<ConsultaEntity> findAllBySolicitud_Solicitante_Usuario_IdUsuario(int idUsuario);
	List<ConsultaEntity> findAllByConsultor_IdConsultor(int idConsultor);

}
