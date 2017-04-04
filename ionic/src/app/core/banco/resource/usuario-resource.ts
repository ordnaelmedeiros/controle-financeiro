import { Banco } from '../../banco/banco-resource';

export class Usuario {
    
    public id:Number;
    public nome:String;
    public email:String;
    
}

export class UsuarioResource {
    constructor (
        private banco:Banco
    ) {

    }

    public create(callBackSucesso, callBackErro) {

        this.banco.sql.executeSql(
            `create table if not exists usuario (
                id integer,
                nome text,
                email text
            )`, []
        ).then((data) => {
            callBackSucesso(data);
        }).catch((error) => {
            callBackErro("Erro ao criar Usuário");
        });

    }

    public gravar(usu:Usuario, callBackSucesso, callBackErro) {

        let arr = [usu.nome, usu.email, usu.id];

        this.banco.sql.executeSql(
            `select * from usuario`,[]
        ).then((dataSel) => {
            
            if (dataSel.rows.length==0) {
                
                this.banco.sql.executeSql(
                    `insert into usuario (nome, email, id) values (?, ?, ?)`, arr
                ).then((data) => {
                    callBackSucesso();
                }).catch((error) => {
                    callBackErro('Erro ao gravar Usuário.');
                });

            } else {

                this.banco.sql.executeSql(
                    `update usuario set nome = ?, email = ?, id = ?`, arr
                ).then((data) => {
                    callBackSucesso();
                }).catch((error) => {
                    callBackErro('Erro ao gravar Usuário..');
                });

            }

        }).catch((error) => {
            callBackErro('Erro ao gravar Usuário');
        });

    }

    public buscar(callBackSucesso, callBackErro) {

        this.banco.sql.executeSql(
            `select * from usuario`,[]
        ).then((dataSel) => {
            
            if (dataSel.rows.length==0) {
                callBackSucesso(null);
            } else {
                callBackSucesso(dataSel.rows.item(0));
            }

        }).catch((error) => {
            callBackErro('Erro ao Buscar Usuário');
        });

    }

}