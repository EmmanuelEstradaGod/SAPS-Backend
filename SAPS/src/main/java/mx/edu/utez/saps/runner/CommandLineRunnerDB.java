package mx.edu.utez.saps.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mx.edu.utez.saps.entity.CarreraEntity;
import mx.edu.utez.saps.entity.DepartamentoEntity;
import mx.edu.utez.saps.entity.DivisionEntity;
import mx.edu.utez.saps.entity.EstadoCivilEntity;
import mx.edu.utez.saps.entity.MotivoEntity;
import mx.edu.utez.saps.entity.NivelEntity;
import mx.edu.utez.saps.entity.RoleEntity;
import mx.edu.utez.saps.entity.SintomaEntity;
import mx.edu.utez.saps.entity.SolicitudAdministrativoEntity;
import mx.edu.utez.saps.entity.SolicitudDocenteEntity;
import mx.edu.utez.saps.entity.SolicitudEstudianteEntity;
import mx.edu.utez.saps.entity.TipoUsuarioEntity;
import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.enums.Role;
import mx.edu.utez.saps.enums.TipoUsuario;
import mx.edu.utez.saps.repository.CarreraRepository;
import mx.edu.utez.saps.repository.DepartamentoRepository;
import mx.edu.utez.saps.repository.DivisionRepository;
import mx.edu.utez.saps.repository.EstadoCivilRepository;
import mx.edu.utez.saps.repository.MotivoRepository;
import mx.edu.utez.saps.repository.NivelRepository;
import mx.edu.utez.saps.repository.RoleRepository;
import mx.edu.utez.saps.repository.SintomaRepository;
import mx.edu.utez.saps.repository.SolicitudAdmnistrativoRepository;
import mx.edu.utez.saps.repository.SolicitudDocenteRepository;
import mx.edu.utez.saps.repository.SolicitudEstudianteRepository;
import mx.edu.utez.saps.repository.TipoUsuarioRepository;
import mx.edu.utez.saps.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class CommandLineRunnerDB implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private SintomaRepository sintomaRepository;
	@Autowired
	private MotivoRepository motivoRepository;
	@Autowired
	private EstadoCivilRepository estadoCivilRepository;
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	@Autowired
	private CarreraRepository carreraRepository;
	@Autowired
	private NivelRepository nivelRepository;
	@Autowired
	private SolicitudEstudianteRepository solicitudEstudianteRepository;
	@Autowired
	private SolicitudDocenteRepository solicitudDocenteRepository;
	@Autowired
	private SolicitudAdmnistrativoRepository solicitudAdmnistrativoRepository;
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	@Autowired
	private UsuarioService usuarioService;
	//-------------------------------------
	
	@Override
	public void run(String... args) throws Exception {
		
		if(roleRepository.findAll().isEmpty()) {
			roleRepository.save(new RoleEntity(Role.ROLE_ADMIN));
			roleRepository.save(new RoleEntity(Role.ROLE_CONSULTOR));
			roleRepository.save(new RoleEntity(Role.ROLE_SOLICITANTE));
		}
		
		logger.info("Roles creados");
		
		//-------------------------------------
		
		if (sintomaRepository.findAll().isEmpty()) {
			sintomaRepository.save(new SintomaEntity("Depresión", true));
			sintomaRepository.save(new SintomaEntity("Estrés", true));
		}
		
		logger.info("Síntomas creados");
		
		//-------------------------------------
		
		if (motivoRepository.findAll().isEmpty()) {
			motivoRepository.save(new MotivoEntity("Autoestima", true));
			motivoRepository.save(new MotivoEntity("Motivos Personales", true));
		}
		
		logger.info("Motivos creados");
		
		//-------------------------------------
		
		if (estadoCivilRepository.findAll().isEmpty()) {
			estadoCivilRepository.save(new EstadoCivilEntity("Casado", true));
			estadoCivilRepository.save(new EstadoCivilEntity("Soltero", true));
		}
		
		logger.info("Estados civiles creados");
		
		//-------------------------------------
		
		if (departamentoRepository.findAll().isEmpty()) {
			departamentoRepository.save(new DepartamentoEntity("Servicios Escolares", true));
			departamentoRepository.save(new DepartamentoEntity("Apoyo Psicopedagógico", true));
		}
		
		logger.info("Departamentos creados");
		
		//-------------------------------------
		
		if (divisionRepository.findAll().isEmpty()) {
			divisionRepository.save(new DivisionEntity("DATIC", true));
			divisionRepository.save(new DivisionEntity("DATEFI", true));
		}
		
		logger.info("Divisiones creadas");
		
		//-------------------------------------
		
		if (carreraRepository.findAll().isEmpty()) {
			carreraRepository.save(new CarreraEntity("Ingeniería en desarrollo y Gestión de Software",divisionRepository.findByIdDivision(1), true));
			carreraRepository.save(new CarreraEntity("Rehabilitación",divisionRepository.findByIdDivision(2), true));
		}
		
		logger.info("Carreras creadas");
		
		//-------------------------------------
		
		if (nivelRepository.findAll().isEmpty()) {
			nivelRepository.save(new NivelEntity("TSU",true));
			nivelRepository.save(new NivelEntity("Ingeniería", true));
		}
		
		logger.info("Niveles académicos creados");
		
		//-------------------------------------
		
		if (solicitudEstudianteRepository.findAll().isEmpty()) {
			solicitudEstudianteRepository.save(new SolicitudEstudianteEntity("20183ti079",nivelRepository.findByIdNivel(1),carreraRepository.findByIdCarrera(1),"10","A","Iván Sotelo Colín",true));
			solicitudEstudianteRepository.save(new SolicitudEstudianteEntity("20183ti126",nivelRepository.findByIdNivel(1),carreraRepository.findByIdCarrera(2),"10","B","Marco Antonio Luna Ortega",true));
		}
		
		logger.info("Solicitudes Estudiante creados");
		
		//-------------------------------------
		
		if (solicitudDocenteRepository.findAll().isEmpty()) {
			solicitudDocenteRepository.save(new SolicitudDocenteEntity(divisionRepository.findByIdDivision(1),true));
			solicitudDocenteRepository.save(new SolicitudDocenteEntity(divisionRepository.findByIdDivision(2),true));
		}
		
		logger.info("Solicitudes Docente creados");
		
		//-------------------------------------
		
		if (solicitudAdmnistrativoRepository.findAll().isEmpty()) {
			solicitudAdmnistrativoRepository.save(new SolicitudAdministrativoEntity(departamentoRepository.findByIdDepartamento(1), true));
			solicitudAdmnistrativoRepository.save(new SolicitudAdministrativoEntity(departamentoRepository.findByIdDepartamento(2), true));
		}
		
		logger.info("Solicitudes Administrativo creados");
		
		//-------------------------------------
		
		if (tipoUsuarioRepository.findAll().isEmpty()) {
			tipoUsuarioRepository.save(new TipoUsuarioEntity(TipoUsuario.Administrativo,null,null,solicitudAdmnistrativoRepository.findByIdSolicitudAdministrativo(1),true));
			tipoUsuarioRepository.save(new TipoUsuarioEntity(TipoUsuario.Administrativo,null,null,solicitudAdmnistrativoRepository.findByIdSolicitudAdministrativo(2),true));
			tipoUsuarioRepository.save(new TipoUsuarioEntity(TipoUsuario.Docente, null, solicitudDocenteRepository.findByIdSolicitudDocente(1), null, true));
			tipoUsuarioRepository.save(new TipoUsuarioEntity(TipoUsuario.Docente, null, solicitudDocenteRepository.findByIdSolicitudDocente(2), null, true));
			tipoUsuarioRepository.save(new TipoUsuarioEntity(TipoUsuario.Estudiante, solicitudEstudianteRepository.findByIdSolicitudEstudiante(1), null, null, true));
			tipoUsuarioRepository.save(new TipoUsuarioEntity(TipoUsuario.Estudiante, solicitudEstudianteRepository.findByIdSolicitudEstudiante(2), null, null, true));
		}
		
		logger.info("Tipo Usuario creados");
		
		//-------------------------------------
		
		if (usuarioService.getUsuarios().isEmpty()) {
			
			usuarioService.saveUsuario(new UsuarioEntity("Emmanuel", "Estrada", "Godínez", "20183ti079@utez.edu.mx", "1234", "Hombre", tipoUsuarioRepository.findByIdTipoUsuario(5), true),Role.ROLE_SOLICITANTE);
			usuarioService.saveUsuario(new UsuarioEntity("Carlos Eduardo", "Arce", "de la Torre", "20183ti126@utez.edu.mx", "1234", "Hombre", tipoUsuarioRepository.findByIdTipoUsuario(6), true),Role.ROLE_SOLICITANTE);
		}
		
		logger.info("Usuarios creados");
		
		//-------------------------------------
	}

}
