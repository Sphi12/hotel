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
    it('Deberia crear reserva', () => {     
        const ID_USUARIO = '1097729359';
        const TIPO_HABITACION = 'Individual';
       // const TIPO_PARQUEADERO = 'Moto';
        const FECHA_INGRESO = '09/16/2021';
        const FECHA_SALIDA = '09/20/2021';

        console.log("Crear reserva")
        page.navigateTo();
        navBar.clickReserva();
        reserva.clickBotonLinkCrearReserva();
        browser.sleep(3000);

        reserva.ingresarIdUsuario(ID_USUARIO);
        browser.sleep(3000);
        reserva.ingresarTipoParqueadero();
        browser.sleep(5000);
        reserva.ingresarFechaIngreso(FECHA_INGRESO);
        reserva.ingresarFechaSalida(FECHA_SALIDA);
        reserva.ingresarTipoHabitacion(TIPO_HABITACION);

        console.log("3R")

        browser.sleep(5000);
        reserva.clickBotonCrear();
        console.log("4R")
        browser.sleep(3000);
        reserva.clickBotonOK();
        browser.sleep(2000);
        expect(reserva.obtenerTextoSweetAlert()).toContain('Se creo la reserva');
        console.log("5R")

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
