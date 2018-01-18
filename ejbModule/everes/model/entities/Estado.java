package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name="estado")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADO_IDESTADO_GENERATOR", sequenceName="SEQ_ESTADO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_IDESTADO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idestado;

	@Column(length=1)
	private String estado;

	//bi-directional many-to-one association to ReservaEvento
	@OneToMany(mappedBy="estado")
	private List<ReservaEvento> reservaEventos;

	public Estado() {
	}

	public Integer getIdestado() {
		return this.idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ReservaEvento> getReservaEventos() {
		return this.reservaEventos;
	}

	public void setReservaEventos(List<ReservaEvento> reservaEventos) {
		this.reservaEventos = reservaEventos;
	}

	public ReservaEvento addReservaEvento(ReservaEvento reservaEvento) {
		getReservaEventos().add(reservaEvento);
		reservaEvento.setEstado(this);

		return reservaEvento;
	}

	public ReservaEvento removeReservaEvento(ReservaEvento reservaEvento) {
		getReservaEventos().remove(reservaEvento);
		reservaEvento.setEstado(null);

		return reservaEvento;
	}

}