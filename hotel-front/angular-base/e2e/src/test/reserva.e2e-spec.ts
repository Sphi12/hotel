import { browser } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { ReservaPage } from '../page/reserva/reserva.po';

describe('workspace-project Reserva', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let reserva: ReservaPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        reserva = new ReservaPage();
        browser.driver.manage().window().maximize();
    });

    fit('Deberia hacer chek-in', () => {
        browser.sleep(5000);
        page.navigateTo();
        navBar.clickReserva();
        browser.sleep(5000);
        reserva.clickBotonListarReserva();
        browser.sleep(3000);
        reserva.clickEditarPrimeraReserva();
        browser.sleep(3000);
        reserva.clickBotonOK();
    });

    it('Deberia crear reserva', () => {
        const ID_USUARIO = '1';
        const TIPO_HABITACION = 'Individual';
        const TIPO_PARQUEADERO = 'Moto';
        const FECHA_INGRESO = '09/18/2021';
        const FECHA_SALIDA = '09/20/2021';
        page.navigateTo();
        navBar.clickReserva();
        reserva.clickBotonLinkCrearReserva();
        browser.sleep(3000);
        reserva.ingresarIdUsuario(ID_USUARIO);
        reserva.cambiarSelectorEvento('tipoParqueadero', TIPO_PARQUEADERO);
        reserva.cambiarSelectorEvento('tipoHabitacion', TIPO_HABITACION);
        reserva.cambiarSelectorEvento('fechaIngreso', FECHA_INGRESO);
        reserva.cambiarSelectorEvento('fechaSalida', FECHA_SALIDA);
        reserva.ingresarFechaIngreso(FECHA_INGRESO);
        reserva.ingresarFechaSalida(FECHA_SALIDA);

        browser.sleep(5000);
        reserva.clickBotonCrear();
        browser.sleep(2000);
        expect(reserva.obtenerTextoSweetAlert()).toContain('Se creo la reserva');
    });

    it('Deberia listar reservas', () => {
        browser.sleep(5000);
        page.navigateTo();
        navBar.clickReserva();
        browser.sleep(5000);
        reserva.clickBotonListarReserva();
        browser.sleep(5000);
    });
});
