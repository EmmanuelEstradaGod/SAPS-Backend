package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.DivisionEntity;

@Repository
public interface DivisionRepository extends JpaRepository<DivisionEntity, Integer>{
	DivisionEntity findByIdDivision(int idDivision);
	List<DivisionEntity> findAllByStatus(boolean status);
}
