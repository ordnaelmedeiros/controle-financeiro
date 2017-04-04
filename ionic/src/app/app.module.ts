import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { ValidacaoPage } from '../pages/validacao/validacao';
import { LoginPage } from '../pages/login/login';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { Config } from '../app/core/config/config';
import { Banco } from '../app/core/banco/banco-resource';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
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
