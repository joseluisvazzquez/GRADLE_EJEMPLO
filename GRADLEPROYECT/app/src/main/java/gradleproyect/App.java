public class App{

    public class Habitacion{
        private int id;
        private String Tipo;
        private Double precio;

        public Habitacion(int id, String Tipo, Double precio){
            this.id = id;
            this.Tipo = Tipo;
            this.precio = precio;
        }


        public int getId() {
            return id;
        }

    }

    public class UsuarioDto{
        private String nombre;
        private String email;

        public UsuarioDto(String nombre, String email){
            this.nombre = nombre;
            this.email = email;
        }

        public String getNombre(){
            return nombre;
        }

    }

    public class Registre{
        private int numero_habitacio;
        private UsuarioDto usuari;

        public registre(int numero_habitacio, UsuarioDto usuari){
            this.numero_habitacio = numero_habitacio;
            this.usuari = usuari;
        }

        public int getNumero_habitacio(){
            return numero_habitacio;
        }

        public UsuarioDto getUsuari(){
            return usuari;
        }

    }
    
    public class Habitaciones{
        private List<Habitacion> habitaciones;

        public Habitaciones(List<Habitacion> habitaciones){ 
            this.habitaciones = habitaciones;
            
        }
        
        public Habitacion registrar_habitacio(int id, String tipo, Double precio) {
            Habitacion habitacion = new Habitacion(id, tipo, precio);
            habitaciones.add(habitacion);
            return habitacion;
        }
        public Habitacion eliminar_habitacio(int index) {
            if (index >= 0 && index < habitaciones.size()) {
                return habitaciones.remove(index);
            }
            return null;
        }

        public List<Habitacion> llistar_habitacions() {
            return habitaciones;
        }
        
    }
    
    public class Usuarios {
        private List<UsuarioDto> usuarios;

        public Usuarios(List<UsuarioDto> usuarios) {
            this.usuarios = usuarios;
        }

        public UsuarioDto CrearUsuario(String nombre, String email) {
            UsuarioDto usuario = new UsuarioDto(nombre, email);
            usuarios.add(usuario);
            return usuario;
        }

        public void eliminarUsuario(String nombreUsuario) {
            UsuarioDto usuario = obtenerUsuario(nombreUsuario);
            if (usuario != null) {
                usuarios.remove(usuario);
            }
        }

        public UsuarioDto obtenerUsuario(String nombreUsuario) {
            for (UsuarioDto usuario : usuarios) {
                if (usuario.getNombre().equals(nombreUsuario)) {
                    return usuario;
                }
            }
            return null;
        }

    }

    public class Registres {
        private Map<String, List<Registre>> reservasPorUsuario;

        public Registres() {
            this.reservasPorUsuario = new HashMap<>();
        }

        public Registre fer_reserva(int idHabitacion, UsuarioDto usuario) {
            Registre reserva = new Registre(idHabitacion, usuario);
            String nombreUsuario = usuario.getNombre();
            if (!reservasPorUsuario.containsKey(nombreUsuario)) {
                reservasPorUsuario.put(nombreUsuario, new ArrayList<>());
            }
            reservasPorUsuario.get(nombreUsuario).add(reserva);
            return reserva;
        }

        public List<Registre> visualitza_reserves(String nombreUsuario) {
            return reservasPorUsuario.getOrDefault(nombreUsuario, new ArrayList<>());
        }
}

}