package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.EstadoCivilEntity;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivilEntity, Integer>{
	EstadoCivilEntity findByIdEstadoCivil(int idEstadoCivil);
}
