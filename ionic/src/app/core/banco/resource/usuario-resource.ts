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

}