package entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="matriculas")
public class Matricula {
	@Embedded
	private MatriculaPk pk;
	private double nota;
	
	
	
	
	@ManyToOne()
	@JoinColumn(name="usuario",referencedColumnName = "usuario")
	private Alumno alumno;
	
	@ManyToOne()
	@JoinColumn(name="idCurso",referencedColumnName = "idCurso")
	private Curso curso;
	
	public Matricula() {
		super();
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Matricula(MatriculaPk pk, double nota, Alumno alumno, Curso curso) {
		super();
		this.pk = pk;
		this.nota = nota;
		this.alumno = alumno;
		this.curso = curso;
	}

	public MatriculaPk getPk() {
		return pk;
	}
	public void setPk(MatriculaPk pk) {
		this.pk = pk;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

}
