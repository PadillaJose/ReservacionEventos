package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alquiler database table.
 * 
 */
@Entity
@Table(name="alquiler")
@NamedQuery(name="Alquiler.findAll", query="SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALQUILER_IDALQUILER_GENERATOR", sequenceName="SEQ_ALQUILER", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALQUILER_IDALQUILER_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idalquiler;

	private Integer cantidadalquiler;

	private Integer cantidaddevolucion;

	private Boolean devolucionprenda;

	@Temporal(TemporalType.DATE)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	@Column(length=50)
	private String prendaalquiler;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	public Alquiler() {
	}

	public Integer getIdalquiler() {
		return this.idalquiler;
	}

	public void setIdalquiler(Integer idalquiler) {
		this.idalquiler = idalquiler;
	}

	public Integer getCantidadalquiler() {
		return this.cantidadalquiler;
	}

	public void setCantidadalquiler(Integer cantidadalquiler) {
		this.cantidadalquiler = cantidadalquiler;
	}

	public Integer getCantidaddevolucion() {
		return this.cantidaddevolucion;
	}

	public void setCantidaddevolucion(Integer cantidaddevolucion) {
		this.cantidaddevolucion = cantidaddevolucion;
	}

	public Boolean getDevolucionprenda() {
		return this.devolucionprenda;
	}

	public void setDevolucionprenda(Boolean devolucionprenda) {
		this.devolucionprenda = devolucionprenda;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getPrendaalquiler() {
		return this.prendaalquiler;
	}

	public void setPrendaalquiler(String prendaalquiler) {
		this.prendaalquiler = prendaalquiler;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}