package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horarios database table.
 * 
 */
@Entity
@Table(name="horarios")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HORARIOS_IDHORARIO_GENERATOR", sequenceName="SEQ_HORARIOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HORARIOS_IDHORARIO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idhorario;

	@Column(length=5)
	private String descripcionempleado;

	@Column(length=10)
	private String diahorario;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	public Horario() {
	}

	public Integer getIdhorario() {
		return this.idhorario;
	}

	public void setIdhorario(Integer idhorario) {
		this.idhorario = idhorario;
	}

	public String getDescripcionempleado() {
		return this.descripcionempleado;
	}

	public void setDescripcionempleado(String descripcionempleado) {
		this.descripcionempleado = descripcionempleado;
	}

	public String getDiahorario() {
		return this.diahorario;
	}

	public void setDiahorario(String diahorario) {
		this.diahorario = diahorario;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}