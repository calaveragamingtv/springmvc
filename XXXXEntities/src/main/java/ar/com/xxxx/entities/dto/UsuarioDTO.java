package ar.com.xxxx.entities.dto;


import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

import ar.com.xxxx.entities.base.ConvertDTO;
import ar.com.xxxx.entities.bo.Usuario;

/**
 * <p> Objeto dto de Usuario,
 * relacionado a la tabla USUARIOS</p>
 * @author nconde
 * @since 14/03/2017
 *
 */

public class UsuarioDTO implements  ConvertDTO<Usuario>   {


    /**
	 * <p>Id para identificar el usuario.</p>
	 */

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

	private String recaptchaMessage;

    /**
     * Constructor vacio
     */
	public UsuarioDTO() {
	    super();
	}


	/**
	 * <p>Constructor con id.</p>
	 * @param id
	 *        <p>Id del usuario</p>
	 */
	public UsuarioDTO(final int id) {
	    super();
		this.id = id;
	}

	/**
	 * <p>Constructor con nombre y apellido.</p>
	 * @param nombre
	 * @param apellido
	 */
	public UsuarioDTO(final String nombre, final String apellido) {
        super();
		this.nombre = nombre;
		this.apellido = apellido;
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


    @Override
    public Usuario invert() {
        Usuario usuario = new Usuario(this.nombre, this.apellido, this.id);
        return usuario;
    }


    @Override
    public void convert(Usuario entity) {
        this.nombre = entity.getNombre();
        this.apellido = entity.getApellido();
        this.id = entity.getId();

    }


    /**
     * @return the recaptchaMessage
     */
    public String getRecaptchaMessage() {
        return recaptchaMessage;
    }


    /**
     * @param recaptchaMessage the recaptchaMessage to set
     */
    public void setRecaptchaMessage(String recaptchaMessage) {
        this.recaptchaMessage = recaptchaMessage;
    }

}
