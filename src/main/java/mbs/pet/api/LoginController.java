package mbs.pet.api;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	private Map<String, String> mapa = new HashMap<String, String>();
	
	public void setLogin(Map<String, String> mapa) {
		this.mapa = mapa;
	}

	@PostMapping("/logar")
	public Boolean login(@RequestBody Login login) throws PetValidationException {
		boolean resultado =  (mapa.containsKey(login.getUsuario()) 
				&& mapa.get(login.getUsuario()).equals(login.getSenha()));
		System.out.println("Logar = " + resultado);
		return resultado;
	}

	

}
