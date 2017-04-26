import { Component } from '@angular/core';
import { 
  NavController,
  ModalController
} from 'ionic-angular';
import { Config } from '../../app/core/config/config';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(
    private navCtrl:NavController,
    private modalCtrl:ModalController,
    private config:Config
  ) {
    
  }

  procuraServidor() {
     
  }

  logoff() {
    this.config.abrirLogin();
  }

}
