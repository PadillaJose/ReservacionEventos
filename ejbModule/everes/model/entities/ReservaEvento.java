package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the reserva_evento database table.
 * 
 */
@Entity
@Table(name="reserva_evento")
@NamedQuery(name="ReservaEvento.findAll", query="SELECT r FROM ReservaEvento r")
public class ReservaEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESERVA_EVENTO_IDEVENTO_GENERATOR", sequenceName="SEQ_RESERVA_EVENTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESERVA_EVENTO_IDEVENTO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idevento;

	@Column(length=50)
	private String descripcion;

	private Timestamp fecha;

	@Column(name="precio_evento", precision=10, scale=2)
	private BigDecimal precioEvento;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="idestado")
	private Estado estado;

	//bi-directional many-to-one association to Salone
	@ManyToOne
	@JoinColumn(name="idsalon")
	private Salone salone;

	//bi-directional one-to-one association to TipoEvento
	@OneToOne
	@JoinColumn(name="idevento", nullable=false, insertable=false, updatable=false)
	private TipoEvento tipoEvento;

	public ReservaEvento() {
	}

	public Integer getIdevento() {
		return this.idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getPrecioEvento() {
		return this.precioEvento;
	}

	public void setPrecioEvento(BigDecimal precioEvento) {
		this.precioEvento = precioEvento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Salone getSalone() {
		return this.salone;
	}

	public void setSalone(Salone salone) {
		this.salone = salone;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}