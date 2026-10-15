package mbs.pet.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

	private List<Log> lista = new ArrayList<Log>();
	private static Integer id = 1;

	@PostMapping("/salvar")
	public Integer salvar(@RequestBody Log log) throws PetValidationException {
		if(log.getData() == null || log.getOperacao() == null|| log.getUsuario() == null
				|| log.getData().isEmpty() || log.getOperacao().isEmpty() 
				|| log.getUsuario().isEmpty() ) {
			System.out.println("Log não cadastrado");
			throw new PetValidationException("Todos os campos do log devem ser preenchidos");
		}
		log.setId(id);
		lista.add(log);		
		System.out.println("Log cadastrada com sucesso");
		return log.getId();
	}

	@GetMapping("/listar")
	public List<Log> listar() {
		System.out.println("Listando logs");
		return lista;
	}

	@DeleteMapping("/deletar-tudo")
	public void deletar() {
		lista.clear();		
		System.out.println("Todos os logs delelados com sucesso");		
	}

}
