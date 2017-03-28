import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  resposta:String = "Inicio!";
  retorno:String = "";
  retorno2:String = "";
  
  static get parameters() {
    return [[NavController],[Http]];
  }

  constructor(public navCtrl: NavController, private http:Http) {

    this.procuraServidor();
  }

  procuraServidor() {
    this.resposta += " - Chamou!";
    
    let url = "http://192.168.100.4:8080/controlefinanceiro/rest/teste/json";
    //this.http.get(url).map(res => this.resposta += " - Veio Resposta");
    this.http.get(url).subscribe((response) => {
        this.resposta += " - Veio Resposta!";
        this.retorno = response.text();
        this.retorno2 = response.json().vString + " - " + response.json().vLocalDate;
    }, (error) => {
      this.resposta += " - Veio Erro!";
    });

    this.resposta += " - Fim Chamou!";
    

  }

}
