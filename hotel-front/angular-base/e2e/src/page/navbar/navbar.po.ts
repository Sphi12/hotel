import { by, element } from 'protractor';

export class NavbarPage {
    linkHome = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkReserva = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkUsuario = element(by.xpath('/html/body/app-root/app-navbar/nav/a[3]'));

    async clickUsuario() {
        await this.linkUsuario.click();
    }
}
