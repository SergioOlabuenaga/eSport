package Modelo;

public class Administrador {
   private String nombre;
   private String dni;

   public Administrador() {
   }

   public Administrador(String nombre, String dni) {
      this.nombre = nombre;
      this.dni = dni;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getDni() {
      return dni;
   }

   public void setDni(String dni) {
      this.dni = dni;
   }

   //Funciones en el controlador
   public void GenerarJornadas(){}
   public void GenerarPartidos(){}
   public void UpdateJornada(){}
   public void ReadJornada(){}
   public void ReadClasificacion(){}
   public void CreateDueño(){}
   public void ReadDueño(){}
   public void UpdateDueño(){}
   public void DeleteDueño(){}
   public void CreateJugador(){}
   public void ReadJugador(){}
   public void UpdateJugador(){}
   public void DeleteJugador(){}
   public void CreateEquipo(){}
   public void ReadEquipo(){}
   public void UpdateEquipo(){}
   public void DeleteEquipo(){}
   public void CreateUsuario(){}
   public void ReadUsuario(){}
   public void UpdateUsuario(){}
   public void DeleteUsuario(){}












}

