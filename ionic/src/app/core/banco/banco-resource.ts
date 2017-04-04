import { SQLite, SQLiteObject } from '@ionic-native/sqlite';
import { Config } from '../../core/config/config';
import { VersaoBancoResource } from '../banco/resource/versaobanco-resource';
import { UsuarioResource } from '../banco/resource/usuario-resource';
import { SessaoResource } from '../banco/resource/sessao-resource';

export class Banco {

    private config:Config;
    private db:SQLite = new SQLite();
    public sql:SQLiteObject;
    public versao:Number = 0;

    private callBack:Function;
    private :Function;

    constructor() {

    }

    public iniciarBanco(config:Config, callBack) {

        this.callBack = callBack;

        this.config = config;
        if (this.config.isMobile) {

            this.db.create({
                name: 'teste.db',
                location: 'default'
            })
            .then((sql: SQLiteObject) => {
                this.sql = sql;
                this.createVersaoBanco();
            })
            .catch((error) => {
                this.callBack(false, 'erro criar banco: ' + error);
            });

        } else {
            this.callBack(true, 'Criou Todos');
        }

    }

    private createVersaoBanco() {
        new VersaoBancoResource(this).create(
            (versao) => {
                this.versao = versao;
                //this.callBack(true, "Versão: " + this.versao);
                this.createUsuario();
            }, (erro) => {
                this.callBack(false, erro);
            }
        );
    }

    private createUsuario() {
        new UsuarioResource(this).create(
            (versao) => {
                this.createSessao();
            }, (erro) => {
                this.callBack(false, erro);
            }
        );
    }

    private createSessao() {
        new SessaoResource(this).create(
            (versao) => {
                this.callBack(true, 'Criou Todos');
            }, (erro) => {
                this.callBack(false, erro);
            }
        );
    }

}