import { Component } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { FormBuilder, Validators } from '@angular/forms';
import { 
  NavController,
  ModalController,
  Loading, AlertController
} from 'ionic-angular';
import { Config } from '../../app/core/config/config';

@Component({
  selector: 'page-usuario',
  templateUrl: 'usuario.html'
})
export class UsuarioPage {

  private cadastro:any = {};

  constructor(
    private http:Http,
    private alertCtrl:AlertController,
    private navCtrl:NavController,
    private modalCtrl:ModalController,
    private config:Config,
    private formBuilder: FormBuilder,
  ) {

    this.cadastro = this.formBuilder.group({
      id:['', Validators.required],
      nome:['', Validators.required],
      email:['', Validators.required]
    });
    
  }

  gravar() {

    var vHeader = new Headers();
    vHeader.append("Accept", "application/json");
    vHeader.append("Content-Type", "application/json");
    vHeader.append("User-Token", ""+this.config.sessao.usertoken);
    vHeader.append("Session-Token", ""+this.config.sessao.sessaotoken);

    if (this.cadastro.value.id!="") {
      
      this.http.put(this.config.url+"/rest/usuario", this.cadastro.value, {headers: vHeader}).subscribe(
        (response) => {
          console.log(JSON.stringify(response.json()));
          this.cadastro.patchValue(response.json());
        },
        (error) => {
          let alert = this.alertCtrl.create({
            title: 'Erro',
            subTitle: error.text(), 
            buttons: ['OK']
          });
          alert.present();
        }
      );

    } else {

      this.http.post(this.config.url+"/rest/usuario", this.cadastro.value, {headers: vHeader}).subscribe(
        (response) => {
          console.log(JSON.stringify(response.json()));
          this.cadastro.patchValue(response.json());
        },
        (error) => {
          let alert = this.alertCtrl.create({
            title: 'Erro',
            subTitle: error.text(), 
            buttons: ['OK']
          });
          alert.present();
        }
      );
      
    }
    
  }

}
