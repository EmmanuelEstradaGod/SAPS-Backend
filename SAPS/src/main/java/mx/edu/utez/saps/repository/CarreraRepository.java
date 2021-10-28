package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.CarreraEntity;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, Integer>{
	CarreraEntity findByIdCarrera(int idCarrera);
	List<CarreraEntity> findAllByStatus(boolean status);
}
