package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer>{
	DepartamentoEntity findByIdDepartamento(int idDepartamento);
	List<DepartamentoEntity> findAllByStatus(boolean status);
}
