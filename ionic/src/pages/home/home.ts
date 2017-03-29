import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { Network } from '@ionic-native/network';
import 'rxjs/add/operator/timeout';

import { NavController} from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  resposta:String = "Inicio!";
  retorno:String = "";
  retorno2:String = "";
  networkState:any;
  network:Network;

  constructor(public navCtrl: NavController, private http:Http) {
    this.network = new Network();
    this.resposta += 
      " - net: " + this.network.type 
      + "- link: " + this.network.downlinkMax;
  }

  clickTeste() {
    this.iniciaProcuraServidor();
  }

  num = 95;
  total = 0;
  num1 = 0;
  num2 = 0;

  iniciaProcuraServidor() {
    this.num1 = 100;
    this.num2 = 0;
    this.procuraServidor();
  }

  procuraServidor() {
    
    this.resposta = "Inicio! - Chamou!";
    
    let url = "";

    if (this.network!=null && this.network.type!=null) {
      url= "http://35.167.76.29:8080/controlefinanceiro/rest/teste/json";
    } else {
      url= "http://35.167.76.29:8080/controlefinanceiro/rest/teste/json";
    }

     
    //this.http.get(url).map(res => this.resposta += " - Veio Resposta");

    this.http.get(url).timeout(1000).subscribe((response) => {
        this.resposta += " - Veio Resposta!";
        this.retorno = response.text();
        this.retorno2 = response.json().vString + " - " + response.json().vLocalDate;
    }, (error) => {
      this.resposta += " - Veio Erro!" + error;
    });

    this.resposta += " - Fim Chamou!";
    

  }

}
