import { Component } from '@angular/core';
import { ViewController } from 'ionic-angular';
import { Http } from '@angular/http';
import { FormBuilder, Validators } from '@angular/forms';
import { AlertController } from 'ionic-angular';
import { Config } from '../../app/core/config/config';
import { UsuarioResource } from '../../app/res/usuario/usuario-resource';
import { Usuario } from '../../app/res/usuario/usuario';
//import 'rxjs/add/operator/timeout';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {

  private cadastro:any = {};
  
  constructor(
    private viewCtrl:ViewController,
    private http:Http,
    private formBuilder: FormBuilder,
    private alertCtrl:AlertController,
    private config:Config
  ) {
    
    console.log(this.config.url);

    this.cadastro = this.formBuilder.group({
      usuario:['', Validators.required],
      senha:['', Validators.required]
    });

  }

  private showMsgErro:Boolean = false;
  private msgErro:String = "";

  salvar() {

    this.showMsgErro = false;

    this.http.post(this.config.url+"/rest/login", this.cadastro.value, null)
      .subscribe((response) => {
        console.log("sucesso: "+response.text());
        this.config.usuario.usertoken = response.json().usertoken;
        this.config.usuario.sessaotoken = response.json().sessaotoken;
        
        let tmp = this;
        new UsuarioResource(this.alertCtrl, this.http, this.config).buscaServidor((usu:Usuario) => {
          let alert = tmp.alertCtrl.create({
              title: 'Sucesso',
              subTitle: 'Bem vindo ' + this.config.usuario.nome,
              buttons: [{
                text: 'OK',
                handler: data => {
                  tmp.viewCtrl.dismiss();
                }
              }]
          });
          alert.present();
        });

      }, (error) => {
        this.msgErro = error.text();
        this.showMsgErro = true;
      });

  }

}
