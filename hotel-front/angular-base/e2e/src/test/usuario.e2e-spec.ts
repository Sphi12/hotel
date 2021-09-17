import { browser } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { UsuarioPage } from '../page/usuario/usuario.po';

describe('workspace-project Usuario', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let usuario: UsuarioPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        usuario = new UsuarioPage();
        browser.driver.manage().window().maximize();
    });

    it('Deberia crear usuario', () => {
        const ID = Math.random().valueOf();
        const NOMBRE = 'Usuario de pruebas';
        const CLAVE = '1234';
        const FECHA_INGRESO = '09/13/2021';

        page.navigateTo();
        browser.sleep(3000);
        navBar.clickUsuario();
        browser.sleep(3000);
        console.log("1")
        usuario.clickBotonLinkCrearUsuario();
        browser.sleep(3000);
        console.log("2")
        usuario.ingresarId(ID);
        usuario.ingresarNombre(NOMBRE);
        usuario.ingresarClave(CLAVE);
        usuario.ingresarFechaIngreso(FECHA_INGRESO);

        console.log("3")

        browser.sleep(5000);
        usuario.clickBotonCrear();
        console.log("4")
        browser.sleep(3000);
        expect(usuario.obtenerTextoSweetAlert()).toContain('Se creo el usuario');
        console.log("5")
        });

        it('Deberia listar usuarios', () => {
            page.navigateTo();
            navBar.clickUsuario();
            usuario.clickBotonListarUsuarios;
          });
});
