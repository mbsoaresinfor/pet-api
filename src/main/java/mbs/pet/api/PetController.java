package mbs.pet.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {

	private List<Pet> lista = new ArrayList<Pet>();
	private static Integer id = 1;

	@PostMapping("/salvar")
	public Integer salvar(@RequestBody Pet pet) throws PetValidationException {
		if(pet.getIdade() == null || pet.getIdade() < 0 ) {
			System.out.println("Pet não cadastrado");
			throw new PetValidationException("Idade inválida para o pet");
		}
		
		if(pet.getNome() == null || pet.getNome().isEmpty()) {
			System.out.println("Pet não cadastrado");
			throw new PetValidationException("Nome inválida para o pet");
		}
		pet.setId(id);
		lista.add(pet);
		id++;
		System.out.println("Pet cadastrada com sucesso");
		return pet.getId();
	}

	@GetMapping("/listar")
	public List<Pet> listar() {
		System.out.println("Listando pets");
		return lista;
	}

	@PutMapping("/atualizar/{id}")
	public void atualizar(@RequestBody Pet pet, @PathVariable Integer id) {
		var resultado = lista.removeIf(obj -> obj.getId().equals(id));
		if (resultado) {
			pet.setId(id);
			lista.add(pet);
			System.out.println("Pet atualizado com sucesso");
		} else {			
			System.out.println("Pet não atualizado");
			throw new IllegalArgumentException("Pet não encontada com id " + id);
		}
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Integer id) {
		var resultado = lista.removeIf(obj -> obj.getId().equals(id));
		if (resultado) {
			System.out.println("Pet delelado com sucesso");
		} else {
			System.out.println("Pet não deletado");
			throw new IllegalArgumentException("Pet não encontada com id " + id);
		}
	}

}
