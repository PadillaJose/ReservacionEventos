package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tipo_evento database table.
 * 
 */
@Entity
@Table(name="tipo_evento")
@NamedQuery(name="TipoEvento.findAll", query="SELECT t FROM TipoEvento t")
public class TipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_EVENTO_IDEVENTO_GENERATOR", sequenceName="SEQ_TIPO_EVENTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_EVENTO_IDEVENTO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idevento;

	@Column(length=100)
	private String descripcion;

	@Column(length=100)
	private String nombre;

	@Column(precision=10, scale=2)
	private BigDecimal precio;

	//bi-directional one-to-one association to ReservaEvento
	@OneToOne(mappedBy="tipoEvento")
	private ReservaEvento reservaEvento;

	public TipoEvento() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public ReservaEvento getReservaEvento() {
		return this.reservaEvento;
	}

	public void setReservaEvento(ReservaEvento reservaEvento) {
		this.reservaEvento = reservaEvento;
	}

}