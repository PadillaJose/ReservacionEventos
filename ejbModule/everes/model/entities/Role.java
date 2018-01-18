package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLES_IDROL_GENERATOR", sequenceName="SEQ_ROLES",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_IDROL_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idrol;

	@Column(length=500)
	private String descripcionrol;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="role")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="role")
	private List<Empleado> empleados;

	public Role() {
	}

	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public String getDescripcionrol() {
		return this.descripcionrol;
	}

	public void setDescripcionrol(String descripcionrol) {
		this.descripcionrol = descripcionrol;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setRole(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setRole(null);

		return cliente;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setRole(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setRole(null);

		return empleado;
	}

}