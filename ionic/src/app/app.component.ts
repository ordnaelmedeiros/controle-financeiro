import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AlertController, LoadingController, Loading } from 'ionic-angular';
import { Network } from '@ionic-native/network';

import { ValidacaoPage } from '../pages/validacao/validacao';
import { Config } from '../app/core/config/config';
import { Banco } from '../app/core/banco/banco-resource';
import { UsuarioResource } from '../app/core/banco/resource/usuario-resource';
import { SessaoResource } from '../app/core/banco/resource/sessao-resource';

import { LoginPage } from '../pages/login/login';
import { HomePage } from '../pages/home/home';
import { FamiliaPage } from '../pages/familia/familia';
import { UsuarioPage } from '../pages/usuario/usuario';

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
        content: "Por favor aguarde...",
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
        this.carregarUsuario();
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

  private carregarUsuario() {

    if (this.config.isMobile) {
      new UsuarioResource(this.banco).buscar(
        (usuario) => {
          if (usuario!=null) {
            this.config.usuario = usuario;

            new SessaoResource(this.banco).buscar(
              (sessao) => {
                if (sessao!=null) {
                  this.config.sessao = sessao;
                  this.abrirHome();
                } else {
                  this.abrirLogin();
                }
                //this.validarPlataforma();
              }, (error) => {
                let alert = this.alertCtrl.create({
                    title: 'Erro',
                    subTitle: error,
                    buttons: ['OK']
                });
                alert.present();
              }
            );

          } else {
            this.abrirLogin();
          }
          //this.validarPlataforma();
        }, (error) => {
          let alert = this.alertCtrl.create({
              title: 'Erro',
              subTitle: error,
              buttons: ['OK']
          });
          alert.present();
        }
      );
    } else {
      this.abrirLogin();
    }
    
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
    this.config.terminouLogin = () => {
      this.abrirHome();
    }
  }

  public abrirHome() {
    this.loader.dismiss();
    this.rootPage = HomePage;
  }

  private abrirFamilia() {
    this.rootPage = FamiliaPage;
  }

  private abrirUsuario() {
    this.rootPage = UsuarioPage;
  }
}
