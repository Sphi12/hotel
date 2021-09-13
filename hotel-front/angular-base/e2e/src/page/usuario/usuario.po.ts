import { by, element } from 'protractor';

export class UsuarioPage {
    private linkCrearUsuario = element(by.id('linkCrearUsuario'));
    private linkListarUsuarios = element(by.id('linkListarUsuario'));
    private inputIdUsuario = element(by.id('id'));
    private inputNombreUsuario = element(by.id('nombre'));
    private inputClaveUsuario = element(by.id('clave'));
    private inputFechaIngresoUsuario = element(by.id('fechaCreacion'));
    private botonCrearUsuario = element(by.buttonText('Crear usuario'));
    private botonCrear = element(by.buttonText('Crear'));
    private listaUsuarios = element.all(by.css('ul.usuarios li'));
    private textoSweetAlert = element(by.id('swal2-title'));
    
    async clickBotonLinkCrearUsuario() {
        await this.linkCrearUsuario.click();
    }

    async clickBotonListarUsuarios() {
        await this.linkListarUsuarios.click();
    }

    async ingresarId(id) {
        this.inputIdUsuario.clear();
        await this.inputIdUsuario.sendKeys(id);
    }

    async ingresarFechaIngreso(fechaCreacion) {
        this.inputFechaIngresoUsuario.clear();
        await this.inputFechaIngresoUsuario.sendKeys(fechaCreacion);
    }

    async ingresarClave(clave) {
        this.inputClaveUsuario.clear();
        await this.inputClaveUsuario.sendKeys(clave);
    }

    async ingresarNombre(nombre) {
        this.inputNombreUsuario.clear();
        await this.inputNombreUsuario.sendKeys(nombre);
    }
    async contarProductos() {
        return this.listaUsuarios.count();
    }


    async clickBotonCrear() {
        await this.botonCrear.click();
      }

      async clickBotonCrearUsuario() {
        await this.botonCrearUsuario.click();
      }

      obtenerTextoSweetAlert() {
        return this.textoSweetAlert.getText() as Promise<string>;
      }
}
