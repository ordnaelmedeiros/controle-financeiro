import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { Config } from '../app/core/config/config';
import { Banco } from '../app/core/banco/banco-resource';

import { ValidacaoPage } from '../pages/validacao/validacao';
import { LoginPage } from '../pages/login/login';
import { HomePage } from '../pages/home/home';
import { UsuarioPage } from '../pages/usuario/usuario';
import { FamiliaPage } from '../pages/familia/familia';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    UsuarioPage,
    FamiliaPage,
    ValidacaoPage,
    LoginPage
  ],
  imports: [
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    UsuarioPage,
    FamiliaPage,
    ValidacaoPage,
    LoginPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    Config,
    Banco,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {
}
