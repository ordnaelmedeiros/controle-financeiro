import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { 
  NavController,
  ModalController
} from 'ionic-angular';
import { Config } from '../../app/core/config/config';

@Component({
  selector: 'page-familia',
  templateUrl: 'familia.html'
})
export class FamiliaPage {

  private cadastro:any = {};

  constructor(
    private navCtrl:NavController,
    private modalCtrl:ModalController,
    private config:Config,
    private formBuilder: FormBuilder,
  ) {

    this.cadastro = this.formBuilder.group({
      id:['', Validators.required],
      descricao:['', Validators.required]
    });
    
  }

  gravar() {
     
  }

}
