package ar.com.xxxx.business.test.impl;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import ar.com.xxxx.business.impl.UsuarioBusinessImpl;
import ar.com.xxxx.commons.constants.Constantes;
import ar.com.xxxx.entities.bo.Usuario;
import ar.com.xxxx.persistence.dao.IUsuarioDAO;


@RunWith(MockitoJUnitRunner.class)
public class UsuarioBusinessImplTest  {


    @InjectMocks
    private UsuarioBusinessImpl usuarioBusinessImpl;

    @Mock
    private IUsuarioDAO iusuarioDAO;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(usuarioBusinessImpl);



    }

    /**
     * <p>
     * Se prueba la request "/usuario" y verifica que retorna la url
     * </p>
     *
     * @throws Exception
     * @since 07/04/2017
     * @author nconde
     */
    @Test
    public void reportsUsuariosTest() throws Exception {

        when(usuarioBusinessImpl.getAll()).thenReturn(null);
        List<Usuario> usuario = usuarioBusinessImpl.getAll();
        assertNull(Constantes.NO_NULO, usuario);

    }

}
