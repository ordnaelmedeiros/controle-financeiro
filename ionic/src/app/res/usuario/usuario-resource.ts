import { AlertController } from 'ionic-angular';
import { Http, Headers } from '@angular/http';
import { SQLite, SQLiteObject } from '@ionic-native/sqlite';

import { Config } from '../../core/config/config';
import { Usuario } from '../usuario/usuario';

export class UsuarioResource {

    private db:SQLite = new SQLite();
    private sql:SQLiteObject;

    constructor(
        private alertCtrl:AlertController,
        private http:Http,
        private config:Config
    ) {
        
        let tmp = this;

        if (this.config.isMobile) {

            this.db.create({
                name: 'teste.db',
                location: 'default'
            })
            .then((db: SQLiteObject) => {
                tmp.sql = db;
                db.executeSql(
                    `CREATE TABLE IF EXISTS usuario(
                        id integer,
                        nome TEXT(200),
                        email TEXT(200),
                        usertoken TEXT(128),
                        sessaotoken TEXT(128)
                    )`, {})
                .then(() => console.log('Executed SQL'))
                .catch(e => console.log(e));

            })
            .catch(e => console.log(e));

        }

    }

    private gravar(usuario:Usuario, call) {

        this.config.usuario.id = usuario.id;
        this.config.usuario.email = usuario.email;
        this.config.usuario.nome = usuario.nome;

        let tmp = this;

        if (this.config.isMobile) {
            this.sql.executeSql('INSERT INTO usuario (id, nome, email, usertoken, sessaotoken) values (?, ?, ?, ?, ?) ',
            [this.config.usuario.id, this.config.usuario.nome, this.config.usuario.email, this.config.usuario.usertoken, this.config.usuario.sessaotoken])
                .then((res) => {
                    call(usuario);
                })
                .catch(e => {
                     let alert = tmp.alertCtrl.create({
                        title: 'Erro',
                        subTitle: 'Erro: ' + e, 
                        buttons: ['OK']
                    });
                    alert.present();
                    call(usuario);
                });
        } else {
            call(usuario);
        }
    }

    public get(call) {

        if (this.config.isMobile) {
            this.sql.executeSql('SELECT * FROM usuario',[])
                .then((data) => {
                    
                    let usu:Usuario = data.json();
                    this.config.usuario.id = usu.id;
                    this.config.usuario.email = usu.email;
                    this.config.usuario.nome = usu.nome;
                    this.config.usuario.usertoken = usu.usertoken;
                    this.config.usuario.sessaotoken = usu.sessaotoken;

                    let alert = this.alertCtrl.create({
                        title: 'Sucesso',
                        subTitle: data, 
                        buttons: ['OK']
                    });
                    alert.present();

                })
                .catch(e => {
                    let alert = this.alertCtrl.create({
                        title: 'Erro',
                        subTitle: 'Erro: ' + e, 
                        buttons: ['OK']
                    });
                    alert.present();
                });;
        } else {
            call(null);
        }
         
    }

    public buscaServidor(call) {

        console.log('usertoken 2: '+this.config.usuario.usertoken);
        var myHeaders = new Headers({
            'user-token': this.config.usuario.usertoken
        });
        
        let tmp = this;
        this.http.get(this.config.url+"/rest/usuario/token", {headers: myHeaders})
            .subscribe((response) => {
                tmp.gravar(response.json(), call);
            }, (error) => {
                let alert = tmp.alertCtrl.create({
                    title: 'Erro',
                    subTitle: 'Erro: ' + error, 
                    buttons: ['OK']
                });
                alert.present();
                call(null);
            });
        
    }
    
}