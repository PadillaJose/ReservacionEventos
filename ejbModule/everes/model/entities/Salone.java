package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the salones database table.
 * 
 */
@Entity
@Table(name="salones")
@NamedQuery(name="Salone.findAll", query="SELECT s FROM Salone s")
public class Salone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SALONES_IDSALON_GENERATOR", sequenceName="SEQ_SALONES", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SALONES_IDSALON_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idsalon;

	private Integer capacidadsalon;

	@Column(length=50)
	private String descripcionsalon;

	@Column(precision=5, scale=2)
	private BigDecimal preciosalon;

	//bi-directional many-to-one association to ReservaEvento
	@OneToMany(mappedBy="salone")
	private List<ReservaEvento> reservaEventos;

	public Salone() {
	}

	public Integer getIdsalon() {
		return this.idsalon;
	}

	public void setIdsalon(Integer idsalon) {
		this.idsalon = idsalon;
	}

	public Integer getCapacidadsalon() {
		return this.capacidadsalon;
	}

	public void setCapacidadsalon(Integer capacidadsalon) {
		this.capacidadsalon = capacidadsalon;
	}

	public String getDescripcionsalon() {
		return this.descripcionsalon;
	}

	public void setDescripcionsalon(String descripcionsalon) {
		this.descripcionsalon = descripcionsalon;
	}

	public BigDecimal getPreciosalon() {
		return this.preciosalon;
	}

	public void setPreciosalon(BigDecimal preciosalon) {
		this.preciosalon = preciosalon;
	}

	public List<ReservaEvento> getReservaEventos() {
		return this.reservaEventos;
	}

	public void setReservaEventos(List<ReservaEvento> reservaEventos) {
		this.reservaEventos = reservaEventos;
	}

	public ReservaEvento addReservaEvento(ReservaEvento reservaEvento) {
		getReservaEventos().add(reservaEvento);
		reservaEvento.setSalone(this);

		return reservaEvento;
	}

	public ReservaEvento removeReservaEvento(ReservaEvento reservaEvento) {
		getReservaEventos().remove(reservaEvento);
		reservaEvento.setSalone(null);

		return reservaEvento;
	}

}