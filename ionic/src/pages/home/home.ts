import { Component } from '@angular/core';
import { 
  NavController,
  ModalController
} from 'ionic-angular';
import { Config } from '../../app/core/config/config';
import { ValidacaoPage } from '../../pages/validacao/validacao';

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
    
    if (!this.config.isValidado) {
      let modal = this.modalCtrl.create(ValidacaoPage);
      let temp = this;
      modal.present();
    }

  }

  procuraServidor() {
     
  }

}
