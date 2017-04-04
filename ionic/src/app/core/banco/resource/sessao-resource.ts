import { Banco } from '../../banco/banco-resource';

export class Sessao {
    
    public usertoken:String;
    public sessaotoken:String;
    
}

export class SessaoResource {
    constructor (
        private banco:Banco
    ) {

    }

    public create(callBackSucesso, callBackErro) {

        this.banco.sql.executeSql(
            `create table if not exists sessao (
                usertoken text,
                sessaotoken text
            )`, []
        ).then((data) => {
            callBackSucesso(data);
        }).catch((error) => {
            callBackErro("Erro ao criar Sessão");
        });

    }

    
    public gravar(ses:Sessao, callBackSucesso, callBackErro) {

        let arr = [ses.usertoken, ses.sessaotoken];

        this.banco.sql.executeSql(
            `select * from sessao`,[]
        ).then((dataSel) => {
            
            if (dataSel.rows.length==0) {
                
                this.banco.sql.executeSql(
                    `insert into sessao (usertoken, sessaotoken) values (?, ?)`, arr
                ).then((data) => {
                    callBackSucesso();
                }).catch((error) => {
                    callBackErro('Erro ao gravar Sessão.');
                });

            } else {

                this.banco.sql.executeSql(
                    `update sessao set usertoken = ?, sessaotoken = ?`, arr
                ).then((data) => {
                    callBackSucesso();
                }).catch((error) => {
                    callBackErro('Erro ao gravar Sessão..');
                });

            }

        }).catch((error) => {
            callBackErro('Erro ao gravar Sessão');
        });

    }

    public buscar(callBackSucesso, callBackErro) {

        this.banco.sql.executeSql(
            `select * from sessao`,[]
        ).then((dataSel) => {
            
            if (dataSel.rows.length==0) {
                callBackSucesso(null);
            } else {
                callBackSucesso(dataSel.rows.item(0));
            }

        }).catch((error) => {
            callBackErro('Erro ao Buscar Sessão');
        });

    }

}