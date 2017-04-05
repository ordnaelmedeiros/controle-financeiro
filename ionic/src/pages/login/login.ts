import { Component } from '@angular/core';
import { ViewController, LoadingController, Loading, AlertController } from 'ionic-angular';
import { FormBuilder, Validators } from '@angular/forms';
import { Config } from '../../app/core/config/config';
import { Http, Headers } from '@angular/http';
import { Banco } from '../../app/core/banco/banco-resource';
import { UsuarioResource } from '../../app/core/banco/resource/usuario-resource';
import { SessaoResource } from '../../app/core/banco/resource/sessao-resource';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {

  private cadastro:any = {};
  private showMsgErro:Boolean = false;
  private msgErro:String = "";
  private loader:Loading;

  constructor(
    private viewCtrl:ViewController,
    private formBuilder: FormBuilder,
    private config:Config,
    private http:Http,
    private loadingCtrl: LoadingController,
    private banco:Banco,
    private alertCtrl:AlertController,
  ) {
    
    this.cadastro = this.formBuilder.group({
      nomeacesso:['', Validators.required],
      senha:['', Validators.required]
    });
    
    
  }

  private mostrarCarregando() {
    this.loader = this.loadingCtrl.create({
      content: "Por favor aguarde...",
    });
    this.loader.present();
  }

  private logar() {

    var vHeader = new Headers();
    vHeader.append("Accept", "application/json");
    vHeader.append("Content-Type", "application/json");


    this.mostrarCarregando();

    this.showMsgErro = false;

    this.http.post(this.config.url+"/rest/login", this.cadastro.value, {headers: vHeader}).subscribe(
      (response) => {
        
        let obj:any = response.json();
        this.config.sessao.usertoken = obj.usertoken;
        this.config.sessao.sessaotoken = obj.sessaotoken;
        this.config.usuario = obj.usuario;
        
        if (this.config.isMobile) {
          new UsuarioResource(this.banco).gravar(this.config.usuario, 
          () => {
            this.gravouUsuario();
          }, (error) => {
            this.exceptionErro(error);
          });
        } else {
          this.terminarLogin();
        }
          
      }, (error) => {
        this.mostrarErro(error);
      });

  }

  private gravouUsuario() {
    new SessaoResource(this.banco).gravar(this.config.sessao, 
      () => {
        this.terminarLogin();
      }, (error) => {
        this.exceptionErro(error);
      });
  }

  private terminarLogin() {
    this.config.terminouLogin();
    this.loader.dismiss();
  }

  private exceptionErro(error) {
    this.loader.dismiss();
    let alert = this.alertCtrl.create({
      title: 'Erro',
      subTitle: error, 
      buttons: ['OK']
    });
    alert.present();
  }

  private mostrarErro(error) {
    this.msgErro = error.text();
    this.showMsgErro = true;
    this.loader.dismiss();
  }

}
