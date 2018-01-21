package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique=true, nullable=false, length=13)
	private String idcliente;

	@Column(length=50)
	private String apellidoscliente;

	@Column(length=50)
	private String direccioncliente;

	@Column(length=50)
	private String emailcliente;

	@Column(length=1)
	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecharegistro;

	@Column(length=50)
	private String nombrescliente;

	@Column(length=50)
	private String passwordcliente;

	private Integer telefonocliente;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="cliente")
	private List<Alquiler> alquilers;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idrol")
	private Role role;

	//bi-directional many-to-one association to ReservaEvento
	@OneToMany(mappedBy="cliente")
	private List<ReservaEvento> reservaEventos;

	public Cliente() {
	}

	public String getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getApellidoscliente() {
		return this.apellidoscliente;
	}

	public void setApellidoscliente(String apellidoscliente) {
		this.apellidoscliente = apellidoscliente;
	}

	public String getDireccioncliente() {
		return this.direccioncliente;
	}

	public void setDireccioncliente(String direccioncliente) {
		this.direccioncliente = direccioncliente;
	}

	public String getEmailcliente() {
		return this.emailcliente;
	}

	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getNombrescliente() {
		return this.nombrescliente;
	}

	public void setNombrescliente(String nombrescliente) {
		this.nombrescliente = nombrescliente;
	}

	public String getPasswordcliente() {
		return this.passwordcliente;
	}

	public void setPasswordcliente(String passwordcliente) {
		this.passwordcliente = passwordcliente;
	}

	public Integer getTelefonocliente() {
		return this.telefonocliente;
	}

	public void setTelefonocliente(Integer telefonocliente) {
		this.telefonocliente = telefonocliente;
	}

	public List<Alquiler> getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(List<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}

	public Alquiler addAlquiler(Alquiler alquiler) {
		getAlquilers().add(alquiler);
		alquiler.setCliente(this);

		return alquiler;
	}

	public Alquiler removeAlquiler(Alquiler alquiler) {
		getAlquilers().remove(alquiler);
		alquiler.setCliente(null);

		return alquiler;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<ReservaEvento> getReservaEventos() {
		return this.reservaEventos;
	}

	public void setReservaEventos(List<ReservaEvento> reservaEventos) {
		this.reservaEventos = reservaEventos;
	}

	public ReservaEvento addReservaEvento(ReservaEvento reservaEvento) {
		getReservaEventos().add(reservaEvento);
		reservaEvento.setCliente(this);

		return reservaEvento;
	}

	public ReservaEvento removeReservaEvento(ReservaEvento reservaEvento) {
		getReservaEventos().remove(reservaEvento);
		reservaEvento.setCliente(null);

		return reservaEvento;
	}

}