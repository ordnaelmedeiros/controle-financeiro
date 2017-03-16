# controle-financeiro

ObjetoTeste
GET		http://localhost:8080/controlefinanceiro/teste/ping
GET		http://localhost:8080/controlefinanceiro/teste/objeto
POST	http://localhost:8080/controlefinanceiro/teste/objeto

Usuario
GET		http://localhost:8080/controlefinanceiro/usuario
GET		http://localhost:8080/controlefinanceiro/usuario/{id}
POST	http://localhost:8080/controlefinanceiro/usuario
PUT		http://localhost:8080/controlefinanceiro/usuario
REMOVE	http://localhost:8080/controlefinanceiro/usuario/{id}

Gasto
GET		http://localhost:8080/controlefinanceiro/gasto
GET		http://localhost:8080/controlefinanceiro/gasto/{id}
POST	http://localhost:8080/controlefinanceiro/gasto
PUT		http://localhost:8080/controlefinanceiro/gasto
REMOVE	http://localhost:8080/controlefinanceiro/gasto/{id}

GastoGrupo
GET		http://localhost:8080/controlefinanceiro/gasto/grupo
GET		http://localhost:8080/controlefinanceiro/gasto/grupo/{id}
POST	http://localhost:8080/controlefinanceiro/gasto/grupo
PUT		http://localhost:8080/controlefinanceiro/gasto/grupo
REMOVE	http://localhost:8080/controlefinanceiro/gasto/grupo/{id}

GastoGrupo
GET		http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub
GET		http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub/{id}
POST	http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub
PUT		http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub
REMOVE	http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub/{id}