//import { SQLite, SQLiteObject } from '@ionic-native/sqlite';
//import { Storage } from '@ionic/storage';
import { Usuario } from '../../res/usuario/usuario';

export class Config {

    public isLogado:Boolean = false;
    public isWifi:Boolean = false;
    public isValidado:Boolean = false;
    public isMobile:Boolean = false;
    public url:String = "";
    public usuario:Usuario = new Usuario();

    constructor() {

        
    }

    teste() {
        //console.log("config-teste sqlite ");
    }

}