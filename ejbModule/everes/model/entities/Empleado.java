package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String idempleado;

	@Column(length=50)
	private String apellidosempleados;

	@Column(length=50)
	private String cargafamiliarempleado;

	@Column(length=50)
	private String correoempleado;

	@Column(length=50)
	private String direccionempleado;

	@Column(length=50)
	private String fechanacempleado;

	@Column(length=50)
	private String nombresempleado;

	@Column(length=50)
	private String passwordempleado;

	@Column(length=1)
	private String sexoempleado;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="empleado")
	private List<Alquiler> alquilers;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idrol")
	private Role role;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="empleado")
	private List<Horario> horarios;

	public Empleado() {
	}

	public String getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}

	public String getApellidosempleados() {
		return this.apellidosempleados;
	}

	public void setApellidosempleados(String apellidosempleados) {
		this.apellidosempleados = apellidosempleados;
	}

	public String getCargafamiliarempleado() {
		return this.cargafamiliarempleado;
	}

	public void setCargafamiliarempleado(String cargafamiliarempleado) {
		this.cargafamiliarempleado = cargafamiliarempleado;
	}

	public String getCorreoempleado() {
		return this.correoempleado;
	}

	public void setCorreoempleado(String correoempleado) {
		this.correoempleado = correoempleado;
	}

	public String getDireccionempleado() {
		return this.direccionempleado;
	}

	public void setDireccionempleado(String direccionempleado) {
		this.direccionempleado = direccionempleado;
	}

	public String getFechanacempleado() {
		return this.fechanacempleado;
	}

	public void setFechanacempleado(String fechanacempleado) {
		this.fechanacempleado = fechanacempleado;
	}

	public String getNombresempleado() {
		return this.nombresempleado;
	}

	public void setNombresempleado(String nombresempleado) {
		this.nombresempleado = nombresempleado;
	}

	public String getPasswordempleado() {
		return this.passwordempleado;
	}

	public void setPasswordempleado(String passwordempleado) {
		this.passwordempleado = passwordempleado;
	}

	public String getSexoempleado() {
		return this.sexoempleado;
	}

	public void setSexoempleado(String sexoempleado) {
		this.sexoempleado = sexoempleado;
	}

	public List<Alquiler> getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(List<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}

	public Alquiler addAlquiler(Alquiler alquiler) {
		getAlquilers().add(alquiler);
		alquiler.setEmpleado(this);

		return alquiler;
	}

	public Alquiler removeAlquiler(Alquiler alquiler) {
		getAlquilers().remove(alquiler);
		alquiler.setEmpleado(null);

		return alquiler;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setEmpleado(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setEmpleado(null);

		return horario;
	}

}