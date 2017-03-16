# controle-financeiro
<br/>
ObjetoTeste<br/>
GET		http://localhost:8080/controlefinanceiro/teste/ping<br/>
GET		http://localhost:8080/controlefinanceiro/teste/objeto<br/>
POST	http://localhost:8080/controlefinanceiro/teste/objeto<br/>
<br/>
Usuario<br/>
GET		http://localhost:8080/controlefinanceiro/usuario<br/>
GET		http://localhost:8080/controlefinanceiro/usuario/{id}<br/>
POST	http://localhost:8080/controlefinanceiro/usuario<br/>
PUT		http://localhost:8080/controlefinanceiro/usuario<br/>
REMOVE	http://localhost:8080/controlefinanceiro/usuario/{id}<br/>
<br/>
Gasto<br/>
GET		http://localhost:8080/controlefinanceiro/gasto<br/>
GET		http://localhost:8080/controlefinanceiro/gasto/{id}<br/>
POST	http://localhost:8080/controlefinanceiro/gasto<br/>
PUT		http://localhost:8080/controlefinanceiro/gasto<br/>
REMOVE	http://localhost:8080/controlefinanceiro/gasto/{id}<br/>
<br/>
GastoGrupo<br/>
GET		http://localhost:8080/controlefinanceiro/gasto/grupo<br/>
GET		http://localhost:8080/controlefinanceiro/gasto/grupo/{id}<br/>
POST	http://localhost:8080/controlefinanceiro/gasto/grupo<br/>
PUT		http://localhost:8080/controlefinanceiro/gasto/grupo<br/>
REMOVE	http://localhost:8080/controlefinanceiro/gasto/grupo/{id}<br/>
<br/>
GastoSubGrupo<br/>
GET		http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub<br/>
GET		http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub/{id}<br/>
POST	http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub<br/>
PUT		http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub<br/>
REMOVE	http://localhost:8080/controlefinanceiro/gasto/grupo/{grupoId}/sub/{id}<br/>