import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { 
  NavController,
  ModalController,
  AlertController
} from 'ionic-angular';
import { Config } from '../../app/core/config/config';
import { Http, Headers } from '@angular/http';

@Component({
  selector: 'page-familia',
  templateUrl: 'familia.html'
})
export class FamiliaPage {

  private cadastro:any = {};
  private usuarios:any = [];
  private salvou:Boolean = false;
  private vHeader = new Headers();

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
      usuarios:['', Validators.required]
    });

    
    this.vHeader.append("User-Token", ""+this.config.sessao.usertoken);
    this.vHeader.append("Session-Token", ""+this.config.sessao.sessaotoken);

    this.http.get(this.config.url+"/rest/usuario", {headers: this.vHeader}).subscribe(
        (response) => {
          console.log(JSON.stringify(response.json()));
          this.usuarios = response.json();
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

  gravar() {
     console.log(JSON.stringify(this.cadastro.value));

     this.http.post(this.config.url+"/rest/familia", this.cadastro.value, {headers: this.vHeader}).subscribe(
      (response) => {
        this.salvou = true;
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
