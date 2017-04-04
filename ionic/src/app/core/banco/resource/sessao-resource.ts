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

}