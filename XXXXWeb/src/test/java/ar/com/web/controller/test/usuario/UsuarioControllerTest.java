package ar.com.web.controller.test.usuario;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ar.com.web.controller.usuario.UsuarioController;
import ar.com.xxxx.business.base.exceptions.BusinessException;
import ar.com.xxxx.business.impl.UsuarioBusinessImpl;
import ar.com.xxxx.entities.bo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/config-servletTest.xml" })
@WebAppConfiguration
/**
 * <p>Usuario controller test</p>
 * @author nconde
 * @since 07/04/2017
 */
public class UsuarioControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioBusinessImpl iUsuarioBusiness;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

    }

    /**
     * <p>
     * Se prueba la request "/usuario" y verifica que retorna la
     * url
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
  @Test
    public void listUsuariosTest() throws Exception {

        when(iUsuarioBusiness.getAll()).thenReturn(null);

        mockMvc.perform(get("/usuarios")).andExpect(status().isOk()).andExpect(forwardedUrl("usuario/usuarios"));
        /// .param("username", "john").param("password", "secret")
    }


    /**
     * <p>
     * Se prueba la request "/nuevoUsuario" y verifica que retorna la
     * url
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
    @Test
    public void newUsuarioTest() throws Exception {

        mockMvc.perform(get("/nuevoUsuario")).andExpect(status().isOk()).andExpect(forwardedUrl("usuario/usuarioAlta"));
        /** .param("username", "john").param("password", "secret")*/
    }

    /**
     * <p>
     * Se prueba la request "/guardarUsuario" y verifica que retorna la
     * url, no update.
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
    @Test
    public void saveUsuarioNotUpdateTest() throws Exception {

        doNothing().when(iUsuarioBusiness).add(any(Usuario.class));
        mockMvc.perform(post("/guardarUsuario")).andExpect(status().isOk()).andExpect(forwardedUrl("usuario/usuarioAlta"));

    }

    /**
     * <p>
     * Se prueba la request "/guardarUsuario" y verifica que retorna la
     * url, update.
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
    @Test
    public void saveUsuarioUpdateTest() throws Exception {

        doNothing().when(iUsuarioBusiness).saveOrUpdate(any(Usuario.class));
        mockMvc.perform(post("/guardarUsuario")).andExpect(status().isOk()).andExpect(forwardedUrl("usuario/usuarioAlta"));

    }


    /**
     * <p>
     * Se prueba la request "/guardarUsuario" y verifica que retorna la
     * url, update.
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
    @Test
    public void saveUsuarioUpdateThrowExceptionTest() throws Exception {


        doThrow(new BusinessException()).when(iUsuarioBusiness).saveOrUpdate(any(Usuario.class));
        mockMvc.perform(post("/guardarUsuario")).andExpect(status().isOk()).andExpect(forwardedUrl("usuario/usuarioAlta"));

    }


    /**
     * <p>
     * Se prueba la request "/guardarUsuario" y verifica que retorna la
     * url
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
    @Test
    public void borrarUsuarioTest() throws Exception {
        Usuario usuario = new Usuario();

        doNothing().when(iUsuarioBusiness).remove(usuario);
        when(iUsuarioBusiness.getAll()).thenReturn(null);
        mockMvc.perform(get("/borrarUsuario").param("id", "20")).andExpect(status().isOk()).andExpect(forwardedUrl("usuario/usuarios"));
        /** .param("username", "john").param("password", "secret")*/
    }



}
