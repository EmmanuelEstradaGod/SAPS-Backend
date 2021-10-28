package mx.edu.utez.saps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
	UsuarioEntity findByCorreo(String correo);
	UsuarioEntity findByIdUsuario(int idUsuario);
	List<UsuarioEntity> findAllByStatus(boolean status);
}
