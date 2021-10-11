package mx.edu.utez.saps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.saps.entity.TipoUsuarioEntity;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Integer>{
	
	TipoUsuarioEntity findByIdTipoUsuario(int idTipoUsuario);
}
