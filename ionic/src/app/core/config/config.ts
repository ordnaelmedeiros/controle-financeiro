//import { SQLite, SQLiteObject } from '@ionic-native/sqlite';
//import { Storage } from '@ionic/storage';
import { Usuario } from '../banco/resource/usuario-resource';
import { Sessao } from '../banco/resource/sessao-resource';

export class Config {

    public isLogado:Boolean = false;
    public isWifi:Boolean = false;
    public isMobile:Boolean = false;
    public url:String = "";

    public usuario:Usuario = new Usuario();
    public sessao:Sessao = new Sessao();

    public terminouLogin:Function;
    public abrirLogin:Function;

    public ping:String = "";
    
    constructor() {

        
    }

    teste() {
        //console.log("config-teste sqlite ");
    }

}