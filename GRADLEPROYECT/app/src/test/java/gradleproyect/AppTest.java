package gradleproyect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;



public class AppTest {
    private Habitaciones habitaciones;
    private Usuarios usuarios;
    private Registres registres;

    @BeforeEach
    public void setUp() {
        habitaciones = new Habitaciones(new ArrayList<>());
        usuarios = new Usuarios(new ArrayList<>());
        registres = new Registres();
        
    }
    @Test
    public void testFerReserva() {
        UsuarioDto usuario1 = usuarios.CrearUsuario("user1", "user1@gmail.com");
        Habitacion habitacion1 = habitaciones.registrar_habitacio(1L, "Single", 100.0);
        
        Registre registre1 = registres.fer_reserva(habitacion1.getId(), usuario1);

        assertNotNull(registre1);
        assertEquals(habitacion1.getId(), registre1.getNumero_habitacio());
        assertEquals(usuario1, registre1.getUsuari());
    }

    @Test
    public void testVisualitzaReserves() {
        UsuarioDto usuario1 = usuarios.CrearUsuario("user1", "user1@gmail.com");
        Habitacion habitacion1 = habitaciones.registrar_habitacio(1L, "Single", 100.0);
        Registre reserva1 = registres.fer_reserva(habitacion1.getId(), usuario1);

        ArrayList<Registre> reservasUsuario1 = registres.visualitza_reserves(usuario1.getNombre());

        assertNotNull(reservasUsuario1);
        assertTrue(reservasUsuario1.contains(reserva1));
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