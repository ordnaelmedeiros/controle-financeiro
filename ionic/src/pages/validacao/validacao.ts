import { Component } from '@angular/core';
import 
  { 
    NavController, 
    LoadingController, 
    Loading, 
    Platform,
    ModalController, ViewController
  } from 'ionic-angular';
import { Network } from '@ionic-native/network';
import { LoginPage } from '../login/login';
import { Config } from '../../app/core/config/config';
import { UsuarioResource } from '../../app/res/usuario/usuario-resource';
import { Http } from '@angular/http';
import { AlertController } from 'ionic-angular';

@Component({
  selector: 'validacao-home',
  templateUrl: 'validacao.html'
})
export class ValidacaoPage {

  private isMobile:Boolean = false;
  private isLogado:Boolean = false;
  private isWifi:Boolean = false;

  private url:String = null;
  private network:Network = new Network();

  private contador:Number = new Number(0);

  loader:Loading;

  constructor(
    private alertCtrl:AlertController,
    private http:Http,
    private navCtrl: NavController,
    private loadingCtrl: LoadingController,
    public plt: Platform,
    public modalCtrl:ModalController,
    public viewCtrl:ViewController,
    public config:Config
  ) {

    //let temp = this;
    //let interval = setInterval(function() { temp.validaWifi(); }, 1000);  
    
    let mobile:Boolean = this.plt.is('mobile');
    let mobileweb:Boolean = this.plt.is('mobileweb');
    
    if (mobile && !mobileweb) {
      this.isMobile = true;
      this.url = "http://35.167.76.29/casa";
      //this.url = "http://192.168.100.4:8080/casa";

      if (this.network!=null && this.network.type=='wifi') {
        this.isWifi = true;
      }

    } else {
      this.isMobile = false;
      this.url = this.plt.url();
      if (this.url.indexOf("localhost")>-1) {
        this.url = "http://localhost:8080/casa";
      }
    }

    
  }

  private validar() {

    this.loader = this.loadingCtrl.create({
      content: "Please wait...",
      //duration: 3000
    });
    //this.loader.present();
    
    

    this.config.url = this.url;

    /*

    if (this.config.usuario.nome!="") {
      this.isLogado = true;
    } else {
      this.isLogado = false;
    }

    if (!this.isLogado) {
      this.abrirLogin();
    } else {
      this.config.isValidado = true;
      this.viewCtrl.dismiss();
    }
    */
  }

  private validaWifi() {

    if (this.network!=null && this.network.type=='wifi') {
      this.isWifi = true;
    } else {
      this.isWifi = false;
    }
    
  }

  private abrirLogin() {

    let modal = this.modalCtrl.create(LoginPage);
    let temp = this;
    modal.onDidDismiss(() => {
      temp.validar();
    });
    modal.present();

  }

}
