import { by, element } from 'protractor';

export class ReservaPage {
    private linkCrearReserva = element(by.id('linkCrearRes'));
    private linkListarReservas = element(by.id('linkListarReserva'));
    private inputTipoHabitacion = element(by.id('tipoHabitacion'));
    private inputTipoParqueadero = element.all(by.id('tipoParqueadero')).then(function(items) {
      expect(items.length).toBe(4);
      expect(items[0].getText()).toBe('Moto');
    });
    private inputIdUsuario = element(by.id('idUsuario'));
    private inputFechaIngreso = element(by.id('fechaIngreso'));
    private inputFechaSalida = element(by.id('fechaSalida'));
    private botonCrearReserva = element(by.buttonText('Crear Reserva'));
    private botonCrear = element(by.buttonText('Crear'));
    private botonCheckIn = element(by.buttonText('Check-in'));
    private botonCheckOut = element(by.buttonText('Check-out'));
    private textoSweetAlert = element(by.id('swal2-title'));
    private botonOkVentanaModal = element(by.buttonText('Si'));

    async clickBotonOK() {
        await this.botonOkVentanaModal.click();
      }

    async clickBotonLinkCrearReserva() {
        await this.linkCrearReserva.click();
    }

    async clickBotonListarReserva() {
        await this.linkListarReservas.click();
    }

    async ingresarIdUsuario(idUsuario) {
        this.inputIdUsuario.clear();
        await this.inputIdUsuario.sendKeys(idUsuario);
    }

    async ingresarTipoHabitacion(tipoHabitacion) {
        this.inputTipoHabitacion.clear();
        await this.inputTipoHabitacion.sendKeys(tipoHabitacion);
    }

    async ingresarTipoParqueadero() {
        await this.inputTipoParqueadero;
    }

    async ingresarFechaIngreso(fechaIngreso) {
        this.inputFechaIngreso.clear();
        await this.inputFechaIngreso.sendKeys(fechaIngreso);
    }

    async ingresarFechaSalida(fechaSalida) {
        this.inputFechaSalida.clear();
        await this.inputFechaSalida.sendKeys(fechaSalida);
    }

      async clickBotonCrearReserva() {
        await this.botonCrearReserva.click();
      }

      async clickBotonCrear() {
        await this.botonCrear.click();
      }

      async clickBotonCheckIn() {
        await this.botonCheckIn.click();
      }
      async clickBotonCheckOut() {
        await this.botonCheckOut.click();
      }
      obtenerTextoSweetAlert() {
        return this.textoSweetAlert.getText() as Promise<string>;
      }
}
