package mbs.pet.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	/**
	 * Pet-Api
	 * @author marcelo soares.
	 * @param args
	 */
	
	public static void main(String[] args) {
		  SpringApplication.run(MainApplication.class, args);
	}
	
	 @Bean
	  CommandLineRunner initDatabase(LoginController loginController) {

	    return args -> {
	      Map<String,String> mapaLogin = new HashMap<String,String>();
	      mapaLogin.put("admin", "123");
	      mapaLogin.put("pedro", "678");
	      mapaLogin.put("marcelo", "1234");
	      mapaLogin.put("maria", "9098");
	      mapaLogin.put("joana", "abc");
	      loginController.setLogin(mapaLogin);
	      System.out.println("Login ativados no PetApi: " + mapaLogin);
	    };
	  }
}
