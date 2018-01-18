package everes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SERVICIOS_IDSERVICIO_GENERATOR", sequenceName="SEQ_SERVICIOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICIOS_IDSERVICIO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idservicio;

	@Column(length=50)
	private String descripcionservicio;

	@Column(precision=5, scale=2)
	private BigDecimal precioservicio;

	private Integer stockservicio;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="servicio")
	private List<Alquiler> alquilers;

	public Servicio() {
	}

	public Integer getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
	}

	public String getDescripcionservicio() {
		return this.descripcionservicio;
	}

	public void setDescripcionservicio(String descripcionservicio) {
		this.descripcionservicio = descripcionservicio;
	}

	public BigDecimal getPrecioservicio() {
		return this.precioservicio;
	}

	public void setPrecioservicio(BigDecimal precioservicio) {
		this.precioservicio = precioservicio;
	}

	public Integer getStockservicio() {
		return this.stockservicio;
	}

	public void setStockservicio(Integer stockservicio) {
		this.stockservicio = stockservicio;
	}

	public List<Alquiler> getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(List<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}

	public Alquiler addAlquiler(Alquiler alquiler) {
		getAlquilers().add(alquiler);
		alquiler.setServicio(this);

		return alquiler;
	}

	public Alquiler removeAlquiler(Alquiler alquiler) {
		getAlquilers().remove(alquiler);
		alquiler.setServicio(null);

		return alquiler;
	}

}