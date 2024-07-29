package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculasDao;
import model.AlumnoDto;
import model.AlumnoMatriculadoDto;
import model.CursoDto;
import utilidades.Mapeador;
@Service

public class FormacionServiceImpl implements FormacionService {
	
	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	Mapeador mapeador;
	MatriculasDao matriculasDao;

	public FormacionServiceImpl(AlumnosDao alumnosDao, CursosDao cursosDao, Mapeador mapeador,MatriculasDao matriculasDao) {
		super();
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
		this.mapeador = mapeador;
		this.matriculasDao = matriculasDao;
	}
	@Transactional // se pone ya que al estar en modo lazy al hacer la llamada en el mapeador para get cursos, Spring cierra la sesion y con esta anotacion lo impedimos
	@Override
	public List<CursoDto> cursos() {
		
		return cursosDao.findAll().stream()
				.map(c->mapeador.cursoEntityToDto(c))
				.toList();
	}
	@Transactional
	@Override
	public List<AlumnoMatriculadoDto> buscarAlumnosMatriculados(int idCurso) {
		
		//a partir del curso, obtiene las matriculas y en ellas están tanto curso como alumno
		return cursosDao.findById(idCurso).get() //Curso
				.getMatriculas().stream() //Stream<Matricula>
				.map(m->new AlumnoMatriculadoDto(mapeador.alumnoEntityToDto(m.getAlumno()),
						mapeador.cursoEntityToDto(m.getCurso()),
						m.getNota()))//Stream<AlumnoMatriculadoDto>
				.toList(); 
	}
	@Override
	public boolean altaCurso(CursoDto curso) {
		
		/*if(clientesDao.findByUsuario(cliente.getUsuario())==null) {//si no encuentra cliente con ese usuario, lo guarda
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;*/
		
		if(cursosDao.findByNombreAndFechaInicio(curso.getNombre(), curso.getFechaInicio())==null){
			cursosDao.save(mapeador.cursoDtoToEntity(curso));
			return true;
			
		}
		return false;

	}
	
	
	/*@Override
	public List<AlumnoMatriculadoDto> notas() {
		matriculasDao.
		return null;
	}*/
	
	@Override
	public double notaMediaCurso(int idCurso) {
		if(cursosDao.findById(idCurso).isPresent()) {
			return matriculasDao.avgByIdCurso(idCurso);
		}
		return 0;
	}
	}
	
