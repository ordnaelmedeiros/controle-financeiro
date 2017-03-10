package integration.com.medeiros.ordnael.controlefinanceiro.controller.gastosubgrupo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.medeiros.ordnael.controlefinanceiro.repository.gasto.subgrupo.GastoSubGrupo;

import junit.framework.TestCase;

public class TestGastoSubGrupo extends TestCase {

	
	static RestTemplate restTemplate;
	ResponseEntity<GastoSubGrupo> entity;
	
	static {
		
		restTemplate = new RestTemplate();
		
	}
	
	private String getUrl(Long gastoGrupoId) {
		String url = "http://localhost:8080/controlefinanceiro/gasto/grupo/"+gastoGrupoId+"/sub";
		return url;
	}
	
	public void teste() {
		
		GastoSubGrupo gastoSubGrupo = new GastoSubGrupo();
		gastoSubGrupo.setDescricao("Teste");
		
		entity = restTemplate.postForEntity(this.getUrl(1l), gastoSubGrupo, GastoSubGrupo.class);
		
		assertNotNull(entity);
		
		GastoSubGrupo gastoSubGrupoSalvo = entity.getBody();
		assertNotNull(gastoSubGrupoSalvo);
		assertNotNull(gastoSubGrupoSalvo.getId());
		assertEquals(gastoSubGrupo.getDescricao(), gastoSubGrupoSalvo.getDescricao());
		
		gastoSubGrupoSalvo.setDescricao(gastoSubGrupoSalvo.getDescricao() + " 11");
		
		restTemplate.put(this.getUrl(1l), gastoSubGrupoSalvo);
		
		entity = restTemplate.getForEntity(this.getUrl(1l)+"/{id}", GastoSubGrupo.class, gastoSubGrupoSalvo.getId());
		assertNotNull(entity);
		
		GastoSubGrupo gastoSubGrupoAlterado = entity.getBody();
		
		assertNotNull(gastoSubGrupoAlterado);
		assertNotNull(gastoSubGrupoAlterado.getId());
		assertEquals(gastoSubGrupoSalvo.getDescricao(), gastoSubGrupoAlterado.getDescricao());
		
		restTemplate.delete(this.getUrl(1l)+"/{id}", gastoSubGrupoAlterado.getId());
		
		entity = restTemplate.getForEntity(this.getUrl(1l)+"/{id}", GastoSubGrupo.class, gastoSubGrupoSalvo.getId());
		assertNotNull(entity);
		assertNull(entity.getBody());
		
	}
	
}

