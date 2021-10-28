package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.RoleEntity;
import mx.edu.utez.saps.enums.Role;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
	RoleEntity findByRole(Role role);
	List<RoleEntity> findAllByStatus(boolean status);
}
