package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.MotivoEntity;

@Repository
public interface MotivoRepository extends JpaRepository<MotivoEntity, Integer> {
	MotivoEntity findByIdMotivo(int idMotivo);
	List<MotivoEntity> findAllByStatus(boolean status);
}
