//import { Http } from '@angular/http';
//import { Network } from '@ionic-native/network';

export class CasaRest {

    //private baseUrl:String = "http://<ip>:8080/casa/rest";

    //private network:Network;

    constructor() {
        /*
        this.network = new Network();
        if (this.network!=null && this.network.type!=null) {
            this.baseUrl= "http://35.167.76.29:8080/casa";
        } else {
            this.baseUrl= "http://localhost:8080/casa";
        }
        */

        /*

        let sqllite:SQLite = new SQLite();
        
        sqllite.create({
            name: 'casa.db',
            location: 'default'
        }).then((db: SQLiteObject) => {
            let alert = alertCtrl.create({
                title: 'New Friend!',
                subTitle: 'Criou SQLite!',
                buttons: ['OK']
            });
            alert.present();
        })
        .catch(e => {

            let alert = alertCtrl.create({
                title: 'New Friend!',
                subTitle: 'Erro!',
                buttons: ['OK']
            });
            alert.present();

        });

        let storage:Storage = new Storage();
        let alert = alertCtrl.create({
            title: 'New Friend!',
            subTitle: 'Storage: ' + (storage!=null),
            buttons: ['OK']
        });
        alert.present();
        */
        
    }

    teste():String {
        return "casa-rest - ";// + this.network.type;
    }

}