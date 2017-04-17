package ar.com.xxxx.entities.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import ar.com.xxxx.entities.base.AbstractBO;

/**
 * <p> Objeto que se inserta en la base de datos,
 * relacionado a la tabla USUARIOS</p>
 * @author nconde
 * @since 14/03/2017
 *
 */
@Entity
@Table(name = "USUARIOS", schema = "dbo", catalog = "xxxxpruebas")
public class Usuario extends AbstractBO implements java.io.Serializable   {


	private static final long serialVersionUID = -2542908309322860555L;
	/**
	 * <p>Id para identificar el usuario.</p>
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * <p>Nombre del usuario.</p>
	 */
    @NotEmpty
	private String nombre;

    /**
     * <p>Apellido del usuario.</p>
     */
    @NotEmpty
	private String apellido;

    /**
     * Constructor vacio
     */
	public Usuario() {
	    super();
	}

	/**
	 * <p>Constructor con id.</p>
	 * @param id
	 *        <p>Id del usuario</p>
	 */
	public Usuario(final int id) {
	    super();
		this.id = id;
	}

	/**
	 * <p>Constructor con nombre y apellido.</p>
	 * @param nombre
	 * @param apellido
	 */
	public Usuario(final String nombre, final String apellido) {
        super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	   /**
     * <p>Constructor con nombre, apellido y id.</p>
     * @param nombre
     * @param apellido
     * @param id
     */
    public Usuario(final String nombre, final String apellido, final int id) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

	/**
	 * <p>Getter del id.</p>
	 * @return
	 */
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	/**
	 * <p>Setter del id</p>
	 * @param id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * <p>Getter del nombre.</p>
	 * @return
	 */
	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * <p>Setter del nombre.</p>
	 * @param nombre
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <p>Getter de apellidos.</p>
	 * @return
	 */
	@Column(name = "APELLIDO", length = 50)
	public String getApellido() {
		return this.apellido;
	}

	/**
	 * <p>Setter del apellido.</p>
	 * @param apellido
	 */
	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

}
