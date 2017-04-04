import { Banco } from '../../banco/banco-resource';

export class VersaoBanco {

    public versao:Number;

}

export class VersaoBancoResource {

    private nome:String = "Versionamento do Banco";

    constructor(
        private banco:Banco
    ) {

    }

    public create(callBackSucesso, callBackErro) {

        this.banco.sql.executeSql(
            `CREATE TABLE IF NOT EXISTS versaobanco (
                versao INTEGER
            )`, null
        ).then((r) => {
            
            this.banco.sql.executeSql(
                `SELECT * FROM versaobanco`, []
            ).then((data) => {
                
                if (data.rows.length==0) {
                    this.banco.sql.executeSql(`INSERT INTO versaobanco (versao) VALUES (?)`, [1])
                    .then((data2) => {
                        callBackSucesso(1);
                    }).catch((error) => {
                        callBackErro("Erro ao iniciar Versão do Banco");
                    });
                    
                } else {
                    callBackSucesso(data.rows.item(0).versao);
                }
                
            }).catch((error) => {
                callBackErro("Erro ao buscar Versão do Banco");
            });
            
        }).catch((error) => {
            callBackErro("Erro ao criar Versão do Banco");
        });
        
    }

    public alterar(ver:VersaoBanco) {
        

    }

}