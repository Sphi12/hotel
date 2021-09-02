package com.ceiba.configuracion;

import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.ServicioActualizarHabitacion;
import com.ceiba.habitacion.servicio.ServicioCrearHabitacion;
import com.ceiba.habitacion.servicio.ServicioEliminarHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.parqueadero.servicio.ServicioActualizarParqueadero;
import com.ceiba.parqueadero.servicio.ServicioCrearParqueadero;
import com.ceiba.parqueadero.servicio.ServicioEliminarParqueadero;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioActualizarTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioCrearTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioEliminarTipoHabitacion;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioActualizarTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioCrearTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioEliminarTipoParqueadero;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearTipoHabitacion servicioCrearTipoHabitacion(RepositorioTipoHabitacion repositorioTipoHabitacion) {
        return new ServicioCrearTipoHabitacion(repositorioTipoHabitacion);
    }
    @Bean
    public ServicioEliminarTipoHabitacion servicioEliminarTipoHabitacion(RepositorioTipoHabitacion repositorioTipoHabitacion) {
        return new ServicioEliminarTipoHabitacion(repositorioTipoHabitacion);
    }
    @Bean
    public ServicioActualizarTipoHabitacion servicioActualizarTipoHabitacion(RepositorioTipoHabitacion repositorioTipoHabitacion) {
        return new ServicioActualizarTipoHabitacion(repositorioTipoHabitacion);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioParqueadero repositorioParqueadero,
                                                     RepositorioHabitacion repositorioHabitacion, RepositorioUsuario repositorioUsuario,RepositorioTipoHabitacion repositorioTipoHabitacion, RepositorioTipoParqueadero repositorioTipoParqueadero) {
        return new ServicioCrearReserva(repositorioReserva, repositorioParqueadero, repositorioHabitacion, repositorioUsuario, repositorioTipoHabitacion, repositorioTipoParqueadero);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }
    @Bean
    public ServicioActualizarReserva actualizarReservan(RepositorioReserva repositorioReserva) {
        return new ServicioActualizarReserva(repositorioReserva);
    }

    @Bean
    public ServicioCrearTipoParqueadero servicioCrearTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        return new ServicioCrearTipoParqueadero(repositorioTipoParqueadero);
    }
    @Bean
    public ServicioEliminarTipoParqueadero servicioEliminarTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        return new ServicioEliminarTipoParqueadero(repositorioTipoParqueadero);
    }
    @Bean
    public ServicioActualizarTipoParqueadero servicioActualizarTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        return new ServicioActualizarTipoParqueadero(repositorioTipoParqueadero);
    }

    @Bean
    public ServicioCrearParqueadero servicioCrearParqueadero(RepositorioParqueadero repositorioParqueadero) {
        return new ServicioCrearParqueadero(repositorioParqueadero);
    }
    @Bean
    public ServicioEliminarParqueadero servicioEliminarParqueadero(RepositorioParqueadero repositorioParqueadero) {
        return new ServicioEliminarParqueadero(repositorioParqueadero);
    }
    @Bean
    public ServicioActualizarParqueadero servicioActualizarParqueadero(RepositorioParqueadero repositorioParqueadero) {
        return new ServicioActualizarParqueadero(repositorioParqueadero);
    }

    @Bean
    public ServicioCrearHabitacion servicioCrearHabitacion(RepositorioHabitacion repositorioHabitacion) {
        return new ServicioCrearHabitacion(repositorioHabitacion);
    }

    @Bean
    public ServicioEliminarHabitacion servicioEliminarHabitacion(RepositorioHabitacion repositorioHabitacion) {
        return new ServicioEliminarHabitacion(repositorioHabitacion);
    }
    @Bean
    public ServicioActualizarHabitacion servicioActualizarHabitacion(RepositorioHabitacion repositorioHabitacion) {
        return new ServicioActualizarHabitacion(repositorioHabitacion);
    }
}
