package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Curso;


@Repository
public class CursosDaoImpl implements CursosDao {
	
	@Autowired
	JdbcTemplate template;
	


	@Override
	public void save(Curso curso) {
		String sql="insert into cursos(codCurso,nombre,temática,duracion,precio) values(?,?,?,?,?)";
		template.update(sql,curso.getCodCurso(),curso.getNombre(),curso.getTematica(),curso.getDuracion(),curso.getPrecio());
	}

	@Override
	public Curso findByNombre(String nombre) {
		String sql="select * from cursos where nombre=?";
		List<Curso> cursos= template.query(sql, (r,f)->new Curso(r.getInt("codCurso"),
													r.getString("nombre"),
													r.getString("tematica"),
													r.getInt("duracion"),
													r.getDouble("precio")),nombre);
		return cursos.size()>0?cursos.get(0):null;
}

	

	@Override
	public void deleteByNombre (String nombre) {
		String sql="delete from resultados where nombre=?";
		template.update(sql, nombre);

	}

	@Override
	public List<Curso> findByPrecipoMax(Double precio) {
		String sql="select * from cursos where precio<=?";
		return template.query(sql, (r,f)->new Curso(r.getInt("codCurso"),
													r.getString("nombre"),
													r.getString("tematica"),
													r.getInt("duracion"),
													r.getDouble("precio")),precio);
	}

}
