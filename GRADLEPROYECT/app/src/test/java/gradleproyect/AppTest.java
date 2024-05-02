package gradleproyect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;


public class AppTest {
    private Habitaciones habitaciones;
    private Usuarios usuarios;
    private Registro registros;

    @BeforeEach
    public void setUp() {
        habitaciones = new Habitaciones(new ArrayList<>());
        usuarios = new Usuarios(new ArrayList<>());
        registros = new Registro(new HashMap<>());
        
    }
    @Test
    public void testFerReserva(){
        UsuarioDto usuario1 = new UsuarioDto("user1", "user1@gmail.com");
        Habitacion habitacion1 = new Habitacion(2L, "Suite", 300.0);
        Habitacion habitacion2 = new Habitacion(4L, "Suite Presidencial", 300.0);
        registros.fer_reserva(habitacion1, usuario1);
        registros.fer_reserva(habitacion2, usuario1);

        assertEquals(habitacion1, registros.visualitzar_reservas(usuario1));

    }
    @Test
    public void testVisualitzarReseva(){
        usuarios.CrearUsuario("User", "User@gmail.com");
        habitaciones.registrar_habitacio(6L, "Suite", 8000.0);
        assertEquals(registros, habitaciones);

        
    }
    @Test
    public void testEliminarUsuario(){
        usuarios.CrearUsuario("user2", "user2@gmail.com");
        usuarios.eliminarUsuario("user2");
        assertNull(usuarios.obtenerUsuario("user2"));
        
    }
    @Test 
    public void testCrearUsuario(){
        UsuarioDto usuario = usuarios.CrearUsuario("user1","user1@gmail.com");

        assertEquals(usuario, usuarios.obtenerUsuario("user1"));

    }
    @Test
    public void testRegistrarHabitacio() {
        Habitacion habitacion = habitaciones.registrar_habitacio(1L, "Single", 100.0);
        assertEquals(1, habitaciones.llistar_habitacions().size());
        assertEquals(habitacion, habitaciones.llistar_habitacions().get(0));
    }

    @Test
    public void testEliminarHabitacio() {
        Habitacion habitacion = habitaciones.registrar_habitacio(1L, "Single", 100.0);
        Habitacion removedHabitacion = habitaciones.eliminar_habitacio(0);
        
        assertEquals(0, habitaciones.llistar_habitacions().size());
        assertEquals(habitacion, removedHabitacion);
    }
}