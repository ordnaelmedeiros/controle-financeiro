import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AlertController, LoadingController, Loading } from 'ionic-angular';
import { Network } from '@ionic-native/network';

import { HomePage } from '../pages/home/home';
import { ValidacaoPage } from '../pages/validacao/validacao';
import { Config } from '../app/core/config/config';
import { Banco } from '../app/core/banco/banco-resource';

import { LoginPage } from '../pages/login/login';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  
  private network:Network = new Network();
  private rootPage:any;
  private loader:Loading;

  constructor(
    private platform: Platform, 
    statusBar: StatusBar, 
    private splashScreen: SplashScreen, 
    private alertCtrl:AlertController,
    private config:Config,
    private loadingCtrl: LoadingController,
    private banco:Banco,
  ) {

    platform.ready().then(() => {

      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      //statusBar.styleDefault();
      //splashScreen.hide();
      //this.rootPage = HomePage;
      this.loader = this.loadingCtrl.create({
        content: "Por favor espere...",
        //duration: 3000
      });
      this.loader.present();

      let temp = this;
      let interval = setInterval(function() { temp.validaWifi(); }, 10000);
      this.validarPlataforma();

    });
  }

  private validarPlataforma() {
    
    let mobile:Boolean = this.platform.is('mobile');
    let mobileweb:Boolean = this.platform.is('mobileweb');

    if (mobile && !mobileweb) {

      this.config.isMobile = true;
      this.config.url = "http://35.167.76.29/casa";
      
    } else {

      this.config.isMobile = false;
      this.config.url = this.platform.url();
      if (this.config.url.indexOf("localhost")>-1) {
        this.config.url = "http://localhost:8080/casa";
      }

    }

    this.banco.iniciarBanco(this.config, (sucesso, msg) => {
      
      if (sucesso) {
        this.abrirLogin();
      } else {
        let alert = this.alertCtrl.create({
            title: 'Erro',
            subTitle: msg, 
            buttons: ['OK']
        });
        alert.present();
      }

    });

  }

  private validaWifi() {

    if (this.network!=null && this.network.type=='wifi') {
      this.config.isWifi = true;
    } else {
      this.config.isWifi = false;
    }
    
  }

  private abrirLogin() {
    this.splashScreen.hide();
    this.loader.dismiss();
    this.rootPage = LoginPage;
  }

}
