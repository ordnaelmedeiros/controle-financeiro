import { Component } from '@angular/core';
import { ViewController, LoadingController, Loading, AlertController } from 'ionic-angular';
import { FormBuilder, Validators } from '@angular/forms';
import { Config } from '../../app/core/config/config';
import { Http } from '@angular/http';
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
    this.loader = this.loadingCtrl.create({
      content: "Por favor espere...",
    });
    
  }

  logar() {

    this.loader.present();

    this.showMsgErro = false;

    this.http.post(this.config.url+"/rest/login", this.cadastro.value, null).subscribe(
      (response) => {
        
        let obj:any = response.json();
        this.config.sessao.usertoken = obj.usertoken;
        this.config.sessao.sessaotoken = obj.sessaotoken;
        this.config.usuario = obj.usuario;
        
        new UsuarioResource(this.banco).gravar(this.config.usuario,
          () => {

            new SessaoResource(this.banco).gravar(this.config.sessao,
              () => {
                
                this.config.terminouLogin();
                this.loader.dismiss();

              }, (error) => {

                this.loader.dismiss();
                let alert = this.alertCtrl.create({
                    title: 'Erro',
                    subTitle: error, 
                    buttons: ['OK']
                });
                alert.present();

              }
            )

          },
          (error) => {

            this.loader.dismiss();
            let alert = this.alertCtrl.create({
                title: 'Erro',
                subTitle: error, 
                buttons: ['OK']
            });
            alert.present();

          })
          
      }, (error) => {

        this.msgErro = error.text();
        this.showMsgErro = true;
        this.loader.dismiss();

      });

  }

}
